package com.recondo.lookup;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recondo.lookup.dto.AlertConfigurationDTO;
import com.recondo.lookup.dto.DatamartDTO;
import com.recondo.lookup.dto.GeneratedAlertDTO;
import com.recondo.lookup.generation.GeneratedAlert;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.glassfish.jersey.server.monitoring.ResponseStatistics;

import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/lookup")
public class LookupController {

  private static final String PRS_TOOL_URL = "http://papaprsfmt001.recondo.vci:8080/prsMultiTool/#/lookupResults";
  private static final String UUID_REGEXP = "[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}";
  private static final String BHT03_REGEXP = "[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}";

  @GET
  @Path("/uuid")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getBHT03Uuid(@QueryParam("realmid") RealmID realmID, @QueryParam("bht03Code") String bht03Code) {
    if (bht03Code == null || bht03Code.trim().isEmpty()) {
      return Response.status(Response.Status.BAD_REQUEST)
        .entity(createErrorResponse("BHT03 code is required"))
        .build();
    }

    try {
      String prsUuid = getPrsUuid(bht03Code);
      if (prsUuid == null) {

        if (realmID.equals(RealmID.STAGE)) {
          prsUuid = this.searchSherpaData("uiowae", "U of Iowa RTE Stage Node A", "4340", realmID, bht03Code);
          if (prsUuid == null) {
            prsUuid = this.searchSherpaData("ptrsna", "Peterson Regional Stage Node A", "4410", realmID, bht03Code);
          }
        } else if (realmID.equals(RealmID.PROD)) {
          //If it is not a PRS uuid for this, try using Sherpa
          prsUuid = this.searchSherpaData("uiowae", "U of Iowa RTE Prod Node B", "4401", realmID, bht03Code);
          if (prsUuid == null) {
            prsUuid = this.searchSherpaData("ptrsna", "Peterson Regional Prod Node A", "4410", realmID, bht03Code);
          }
        }

        if (prsUuid == null) {
          return Response.status(Response.Status.NOT_FOUND)
            .entity(createErrorResponse("PRS UUID not found for the given BHT03 code"))
            .build();
        }
      }

      Map<String, String> response = new HashMap<>();
      response.put("uuid", prsUuid);
      return Response.ok(response).build();

    } catch (Exception e) {
      e.printStackTrace();
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .entity(createErrorResponse("Error processing request: " + e.getMessage()))
        .build();
    }
  }

  private String searchSherpaData(String abbr, String name, String envId, RealmID realmID, String bht03Code) {
    return this.loadSherpaData(abbr, name, envId, realmID, bht03Code).getEntity().toString();
  }

  @GET
  @Path("/details")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getLookupDetails(@QueryParam("realmid") RealmID realmID, @QueryParam("prsUuid") String prsUuid) {
    if (prsUuid == null || prsUuid.trim().isEmpty() || !prsUuid.matches(UUID_REGEXP)) {
      return Response.status(Response.Status.BAD_REQUEST)
        .entity(createErrorResponse("PRS UUID is required"))
        .build();
    }

    if (realmID == null) {
      realmID = RealmID.PROD;
    }

    try {
      // Query Datamart with the UUID
      DatamartDTO sqlResults = querySqlWithUuid(realmID, prsUuid);

      if (sqlResults.getResponseBody() == null) {
        return Response.status(Response.Status.NOT_FOUND)
          .entity(createErrorResponse("No DATAMART record for PRS UUID:" + prsUuid))
          .build();
      }

      // Get the rule bodies of all the alerts that have the same alertText
      List<AlertConfigurationDTO> ruleConfigurations = this
        .getAlertRuleBodiesThatHaveTheSameText(realmID, sqlResults.getResponseBody().getGeneratedAlerts());

      // Create response
      Map<String, Object> response = new HashMap<>();
      response.put("uuid", prsUuid);
      response.put("sqlResults", sqlResults);
      response.put("ruleConfigurations", ruleConfigurations);

      return Response.ok(response).build();

    } catch (Exception e) {
      e.printStackTrace();
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .entity(createErrorResponse("Error processing request: " + e.getMessage()))
        .build();
    }
  }

  private String getPrsUuid(String bht03Code) throws IOException {
    OkHttpClient client = new OkHttpClient();

    // First, check in PRS DataWarehouse
    HttpUrl url = HttpUrl
      .parse("http://papadwsapi000.recondo.vci:8080/dataWarehouseServiceApi/dws/v1/prstransactiongroup")
      .newBuilder()
      .addQueryParameter("requestBht03", bht03Code)
      .addQueryParameter("limit", "1000")
      .addQueryParameter("sortcol", "txDatetime")
      .addQueryParameter("sortasc", "false")
      .build();

    Request request = new Request.Builder()
      .url(url)
      .build();

    try (okhttp3.Response response = client.newCall(request).execute()) {
      if (!response.isSuccessful())
        throw new IOException("Unexpected code " + response);

      String responseBody = response.body().string();
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode jsonResponse = objectMapper.readTree(responseBody);

      // Extract the id property of the first item
      JsonNode items = jsonResponse.get("items");
      if (items != null && items.isArray() && items.size() > 0) {
        String prsUuid = items.get(0).get("id").asText();
        System.out.println("ID of the first item: " + prsUuid);
        return prsUuid;
      } else {
        System.out.println("No items found in the response.");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  private DatamartDTO querySqlWithUuid(RealmID realmID, String uuid) throws SQLException, NamingException {
    DatamartDTO result = new DatamartDTO();

    String sql = "SELECT " +
      "alert_request_body.request_body, " +
      "alert_request.response_body" +
      " FROM " +
      "alert_datamart.alert_request, " +
      "alert_datamart.alert_request_body " +
      "WHERE " +
      "alert_request.alert_request_id = alert_request_body.alert_request_id AND " +
      "alert_request.episode_rid = CAST(? AS UUID) " +
      "ORDER BY " +
      "alert_request_body.xact_timestamp DESC";

    try (Connection conn = DatabaseManager.getDatamartConnection(realmID);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

      stmt.setString(1, uuid);

      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          result.setRequestBody(rs.getString("request_body"));
          result.setResponseBody(rs.getString("response_body"));
        }
      }
    }

    return result;
  }

  public List<AlertConfigurationDTO> getAlertRuleBodiesThatHaveTheSameText(RealmID realmID,
                                                                           List<GeneratedAlert> generatedAlerts) throws SQLException, NamingException {
    List<AlertConfigurationDTO> results = new ArrayList<>();

    String sql = "SELECT DISTINCT " +
      "alert_rule_body.realm_ref_id, " +
      "alert_rule_body.alert_rule_id, " +
      "alert_rule.rule_name, " +
      "alert_rule_body.rule_body, " +
      "alert_text_ref.alert_text " +
      "FROM " +
      "alert_configuration.alert_rule_body " +
      "INNER JOIN alert_configuration.alert_rule ON (alert_rule_body.alert_rule_id = alert_rule.alert_rule_id) "
      +
      "INNER JOIN alert_configuration.alert_text_ref ON (alert_text_ref.alert_text_ref_id = alert_rule.alert_text_ref_id) "
      +
      "WHERE " +
      "alert_text_ref.alert_text = ? AND alert_rule_body.realm_ref_id = ? AND alert_rule.scope_ref_id = ?";

    try (Connection conn = DatabaseManager.getConfigurationConnection(realmID);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

      for (GeneratedAlert generatedAlert : generatedAlerts) {
        if (generatedAlert.getText().startsWith("PHC1001 ")) {
          stmt.setString(1, generatedAlert.getText());
          stmt.setInt(2, realmID.getValue());
          stmt.setInt(3, 220);

          try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
              AlertConfigurationDTO dto = new AlertConfigurationDTO();
              dto.setRealmRefId(rs.getString("realm_ref_id"));
              dto.setAlertRuleId(rs.getString("alert_rule_id"));
              dto.setRuleName(rs.getString("rule_name"));
              dto.setRuleBody(rs.getString("rule_body"));
              dto.setAlertText(rs.getString("alert_text"));
              results.add(dto);
            }
          }
        }
      }
    }

    return results;
  }

  private Map<String, String> createErrorResponse(String message) {
    Map<String, String> response = new HashMap<>();
    response.put("message", message);
    return response;
  }

  @GET
  @Path("/sherpa/dataload")
  @Produces(MediaType.APPLICATION_JSON)
  public Response loadSherpaData(
    @QueryParam("customerAbbr") String customerAbbr,
    @QueryParam("customerName") String customerName,
    @QueryParam("envid") String envId,
    @QueryParam("realmid") RealmID realmId,
    @QueryParam("testAccount") String testAccount) {

    if (customerName == null || customerName.trim().isEmpty()) {
      return Response.status(Response.Status.BAD_REQUEST)
        .entity(createErrorResponse("Customer Name is required"))
        .build();
    }

    try {
      OkHttpClient client = new OkHttpClient();

      String dbCode = customerAbbr + "_" + realmId.getName().toLowerCase();
      HttpUrl url = HttpUrl
        .parse("https://sherpa.recondohealth.net/sherpaService/sherpa/v1/sherpa/dataload")
        .newBuilder()
        .addQueryParameter("pretty", "false")
        .addQueryParameter("db", dbCode)
        .addQueryParameter("customer", customerName)
        .addQueryParameter("envid", envId) // stage 43141
        .addQueryParameter("scriptabsolutepath",
          "/home/local/RECONDO/service_cloud_sso_ro/Sherpa_stuff/RIDPuller/")
        .addQueryParameter("scriptfilename", "encounter_to_rid.sh")
        .addQueryParameter("extraargs", testAccount)
        .build();

      Request request = new Request.Builder()
        .url(url)
        .addHeader("Accept", "application/json, text/plain, */*")
        // .addHeader("Origin", "http://dapasherpa001.recondo.vci:8080")
        // .addHeader("Referer", "http://dapasherpa001.recondo.vci:8080/")
        .build();

      try (okhttp3.Response response = client.newCall(request).execute()) {
        if (!response.isSuccessful()) {
          return Response.status(Response.Status.BAD_REQUEST)
            .entity(createErrorResponse("Sherpa API error: " + response.code()))
            .build();
        }

        String responseBody = response.body().string();
        String globalTxId = extractGlobalTxId(responseBody);

        if (globalTxId == null) {
          return Response.status(Response.Status.NOT_FOUND)
            .entity(createErrorResponse("Global TX Id not found in Sherpa response"))
            .build();
        }

        return Response.ok(globalTxId).build();
      }

    } catch (Exception e) {
      e.printStackTrace();
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .entity(createErrorResponse("Error processing request: " + e.getMessage()))
        .build();
    }
  }

  private String extractGlobalTxId(String responseBody) {
    if (responseBody == null || responseBody.isEmpty()) {
      return null;
    }

    String[] lines = responseBody.split("Global TX Id = ");
    if (lines.length == 2) {
      return lines[1].substring(0, 36);
    }
    return null;
  }

}
