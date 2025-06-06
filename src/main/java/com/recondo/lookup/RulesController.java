package com.recondo.lookup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recondo.lookup.dto.RulePayload;
import com.recondo.lookup.dto.activation.Activation;
import com.recondo.lookup.dto.activation.ActivationEntity;
import com.recondo.lookup.dto.activation.ActivationRequest;
import com.recondo.lookup.dto.activation.ActivationResponse;
import com.recondo.lookup.dto.rule.CreateRuleDTO;
import com.recondo.lookup.dto.rule.InMemoryRuleDTO;
import com.recondo.lookup.dto.rule.MgmtRuleResponseDTO;
import com.recondo.lookup.dto.rule.RuleDetailsDTO;
import com.recondo.lookup.dto.rule.RuleDetailsResponseDTO;
import com.recondo.lookup.helper.RuleHelper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import com.fasterxml.jackson.annotation.JsonInclude;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;

@Path("/rules")
public class RulesController {

  @DELETE
  @Path("/{realm}/{ruleId}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response delete(
    @PathParam("realm") RealmID realmId,
    @PathParam("ruleId") String ruleId,
    @HeaderParam("Authorization") String authToken) {
    if (authToken == null || authToken.trim().isEmpty()) {
      return Response.status(Response.Status.UNAUTHORIZED)
        .entity(createErrorResponse("Authorization token is required"))
        .build();
    }

    try {
      OkHttpClient client = new OkHttpClient();

      Request request = new Request.Builder()
        .url(realmId.getScopeApiUrl() + "/" + ruleId)
        .addHeader("Accept", "*/*")
        .addHeader("Authorization", authToken)
        .delete()
        .build();

      try (okhttp3.Response response = client.newCall(request).execute()) {
        if (!response.isSuccessful()) {
          String errorMessage = String.format("Failed to delete rule: %s (Status: %d)",
            response.message(),
            response.code());
          return Response.status(response.code())
            .entity(createErrorResponse(errorMessage))
            .build();
        }

        return Response.ok().build();
      }

    } catch (Exception e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .entity(createErrorResponse("Failed to delete rule: " + e.getMessage()))
        .build();
    }
  }

  @DELETE
  @Path("/name/{realm}/{ruleName}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteByName(
    @PathParam("realm") RealmID realmId,
    @PathParam("ruleName") String ruleName,
    @HeaderParam("Authorization") String authToken) {

    if (authToken == null || authToken.trim().isEmpty()) {
      return Response.status(Response.Status.UNAUTHORIZED)
        .entity(createErrorResponse("Authorization token is required"))
        .build();
    }

    try {
      String sql = "select rule_ref_id from alert_configuration.rule_ref where rule_name = ?";
      int ruleId;

      try (Connection conn = DatabaseManager.getConfigurationConnection(realmId);
           PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, ruleName);

        try (ResultSet rs = stmt.executeQuery()) {
          if (!rs.next()) {
            return Response.status(Response.Status.NOT_FOUND)
              .entity(createErrorResponse("Rule not found: " + ruleName))
              .build();
          }
          ruleId = rs.getInt("rule_ref_id");
        }
      }

      return this.delete(realmId, String.valueOf(ruleId), authToken);

    } catch (Exception e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .entity(createErrorResponse("Failed to delete rule: " + e.getMessage()))
        .build();
    }
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response create(CreateRuleDTO ruleRequest,
                         @HeaderParam("Authorization") String authToken) {
    try {
      if (authToken == null || authToken.trim().isEmpty()) {
        return Response.status(Response.Status.UNAUTHORIZED)
          .entity(createErrorResponse("Authorization token is required"))
          .build();
      }

      OkHttpClient client = new OkHttpClient();

      ObjectMapper mapper = new ObjectMapper();
      String jsonBody = mapper.writeValueAsString(ruleRequest.getRule());
      RulePayload requestBody = new RulePayload();

      String ruleContent = ruleRequest.getRule();
      String ruleName = null;

      // Extract rule name from the rule content
      if (ruleContent != null) {
        int ruleKeywordIndex = ruleContent.indexOf("rule \"");
        if (ruleKeywordIndex != -1) {
          int startIndex = ruleKeywordIndex + 6; // Length of 'rule "'
          int endIndex = ruleContent.indexOf("\"", startIndex);
          if (endIndex != -1) {
            ruleName = ruleContent.substring(startIndex, endIndex);
          }
        }
      }

      requestBody.setName(ruleName != null ? ruleName : ruleContent);

      Map<String, Object> message = new HashMap<>();
      message.put("id", 1084);
//      requestBody.put("message", message);
//
//      requestBody.put("name", ruleRequest.getRule().getName());
//      requestBody.put("realmId", ruleRequest.getRealm().getId());
//
//      Map<String, Object> ruleBody = new HashMap<>();
//      ruleBody.put("body", ruleRequest.getRule().getBody());
//      ruleBody.put("realmId", ruleRequest.getRealm().getId());
//      requestBody.put("ruleBody", ruleBody);
//
//      Map<String, Object> scope = new HashMap<>();
//      scope.put("id", 234);
//      scope.put("productId", 3);
//      requestBody.put("scope", scope);
//
//      requestBody.put("username", "Sebastian.Garcia@waystar.com");

      jsonBody = mapper.writeValueAsString(requestBody);

      Request request = new Request.Builder()
        .url(ruleRequest.getRealm().getScopeApiUrl() + "/rules/")
        .addHeader("Content-Type", "application/json")
        .addHeader("Accept", "application/json")
        .addHeader("Authorization", authToken)
        .post(okhttp3.RequestBody.create(
          okhttp3.MediaType.parse("application/json"),
          jsonBody))
        .build();

      try (okhttp3.Response response = client.newCall(request).execute()) {
        String responseBody = response.body().string();

        if (!response.isSuccessful()) {
          String errorMessage;
          if (response.code() == 409) {
            errorMessage = "Unable to create rule: this rule already exists.";
          } else {
            errorMessage = String.format("API request failed: %s (Status: %d)\nResponse: %s",
              response.message(),
              response.code(),
              responseBody);
          }
          return Response.status(response.code())
            .entity(createErrorResponse(errorMessage))
            .build();
        }

        return Response.ok(responseBody).build();
      }

    } catch (Exception e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .entity(createErrorResponse("Failed to create rule: " + e.getMessage()))
        .build();
    }
  }

  public Integer getAlertRuleIdByRuleName(RealmID realmID, String ruleName) throws SQLException {

    String sql = "SELECT alert_rule_body.alert_rule_id FROM alert_configuration.alert_rule WHERE  alert_rule.rule_name = ?";

    try (Connection conn = DatabaseManager.getConfigurationConnection(realmID);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

      stmt.setString(1, ruleName);

      try (ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
          return rs.getInt("alert_rule_id");
        }
      }

    } catch (SQLException e) {
      throw e;
    }

    return null;
  }

  public Integer getAlertTextRefIdByRuleMessage(RealmID realmID, String ruleMessage) throws SQLException {

    String sql = "SELECT alert_text_ref.alert_text_ref_id FROM alert_configuration.alert_text_ref WHERE  alert_text_ref.alert_text = ?";

    try (Connection conn = DatabaseManager.getConfigurationConnection(realmID);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

      stmt.setString(1, ruleMessage);

      try (ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
          return rs.getInt("alert_text_ref_id");
        }
      }

    } catch (SQLException e) {
      throw e;
    }

    return null;
  }

  @POST
  @Path("/activation/{realm}/{ruleName}/{customerId}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response activation(
    @PathParam("realm") RealmID realmId,
    @PathParam("ruleName") String ruleName,
    @PathParam("customerId") int customerId,
    @HeaderParam("Authorization") String authToken) {

    if (authToken == null || authToken.trim().isEmpty()) {
      return Response.status(Response.Status.UNAUTHORIZED)
        .entity(createErrorResponse("Authorization token is required"))
        .build();
    }

    try {
      String sql = "select rule_ref_id from alert_configuration.rule_ref where rule_name = ?";
      int ruleId;

      try (Connection conn = DatabaseManager.getConfigurationConnection(realmId);
           PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, ruleName);

        try (ResultSet rs = stmt.executeQuery()) {
          if (!rs.next()) {
            return Response.status(Response.Status.NOT_FOUND)
              .entity(createErrorResponse("Rule not found: " + ruleName))
              .build();
          }
          ruleId = rs.getInt("rule_ref_id");
        }
      }

      ObjectMapper mapper = new ObjectMapper();
      mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

      Response getRuleActivationResponse = getRuleActivation(realmId, ruleId);
      Object res = getRuleActivationResponse.getEntity();
      String activationResponseJson = ((String) res);
      ActivationResponse activationResponse = mapper.readValue(activationResponseJson, ActivationResponse.class);

      for (Activation activation : activationResponse.getActivations()) {
        if (activation.getCount() == 0) {
          continue;
        }

        for (ActivationEntity activationEntity : activation.getActivationEntities()) {
          if (activationEntity.getRealm() == null ||
            activationEntity.getRealm().getValue() != realmId.getValue()) {
            continue;
          }

          if (activationEntity.isDisabled()) {
            continue;
          }

          if (activationEntity.getCustomer() == null) {
            if (activationEntity.getPayer() == null) {
              return Response.status(Response.Status.CONFLICT)
                .entity(createErrorResponse("Already generally activationd for: " + realmId.getName()))
                .build();
            }
          } else {
            if (activationEntity.getCustomer().getId() == customerId) {
              return Response.status(Response.Status.CONFLICT)
                .entity(createErrorResponse("Already activationd for: " + activationEntity.getCustomer().getName()))
                .build();
            }
          }
        }
      }

      ActivationRequest activationRequest = ActivationRequest.activationCustomer(customerId);
      String jsonBody = mapper.writeValueAsString(activationRequest);

      Request request = new Request.Builder()
        .url(realmId.getScopeApiUrl() + "/activation/rules/" + ruleId + "/" + realmId.getValue())
        .addHeader("Content-Type", "application/json")
        .addHeader("Accept", "text/plain")
        .addHeader("Authorization", authToken)
        .post(okhttp3.RequestBody.create(
          okhttp3.MediaType.parse("application/json"),
          jsonBody))
        .build();

      OkHttpClient client = new OkHttpClient();
      try (okhttp3.Response response = client.newCall(request).execute()) {
        if (!response.isSuccessful()) {
          String errorMessage = String.format(
            "Failed to activation rule: %s (Status: %d). RealmID: %d, body: %s",
            response.message(),
            response.code(),
            realmId.getValue(),
            jsonBody);
          return Response.status(response.code())
            .entity(createErrorResponse(errorMessage))
            .build();
        }

        return Response.ok().build();
      }

    } catch (Exception e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .entity(createErrorResponse("Failed to activation rule: " + e.getMessage()))
        .build();
    }
  }

  private Response getRuleActivation(RealmID realmId, int ruleId) {

    try {
      OkHttpClient client = new OkHttpClient();

      HttpUrl url = HttpUrl.parse(realmId.getScopeApiUrl() + "/activation/rules/" + ruleId)
        .newBuilder()
        .addQueryParameter("page", "1")
        .addQueryParameter("pageSize", "1000")
        .build();

      Request request = new Request.Builder()
        .url(url)
        .addHeader("Accept", "application/json")
        .get()
        .build();

      try (okhttp3.Response response = client.newCall(request).execute()) {
        if (!response.isSuccessful()) {
          String errorMessage = String.format("Failed to get rule activation history: %s (Status: %d)",
            response.message(),
            response.code());
          return Response.status(response.code())
            .entity(createErrorResponse(errorMessage))
            .build();
        }

        String responseBody = response.body().string();
        return Response.ok(responseBody).build();
      }

    } catch (Exception e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .entity(createErrorResponse("Failed to get rule activation history: " + e.getMessage()))
        .build();
    }
  }

  @GET
  @Path("/activation/{realm}/{ruleName}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getRuleActivationByName(
    @PathParam("realm") RealmID realmId,
    @PathParam("ruleName") String ruleName) {

    try {
      String sql = "select rule_ref_id from alert_configuration.rule_ref where rule_name = ?";
      int ruleId;

      try (Connection conn = DatabaseManager.getConfigurationConnection(realmId);
           PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, ruleName);

        try (ResultSet rs = stmt.executeQuery()) {
          if (!rs.next()) {
            return Response.status(Response.Status.NOT_FOUND)
              .entity(createErrorResponse("Rule not found: " + ruleName))
              .build();
          }
          ruleId = rs.getInt("rule_ref_id");
        }
      }

      return getRuleActivation(realmId, ruleId);

    } catch (Exception e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .entity(createErrorResponse("Failed to get rule activation: " + e.getMessage()))
        .build();
    }
  }

  @GET
  @Path("/list")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllRules() {
    try {
      // For now, return an empty list wrapped in a response object
      Map<String, Object> response = new HashMap<>();
      response.put("rules", new ArrayList<>());

      return Response.ok(response).build();
    } catch (Exception e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .entity(createErrorResponse("Failed to retrieve rules: " + e.getMessage()))
        .build();
    }
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response searchRule(
    @QueryParam("scope") String scope,
    @QueryParam("realmId") RealmID realmId,
    @QueryParam("ruleName") String ruleName,
    @QueryParam("alertText") String alertText) {
    try {
      RuleDetailsResponseDTO result = executeRuleDetailsQuery(realmId, ruleName, alertText, scope);

      if (result.getError() != null) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
          .entity(createErrorResponse(result.getError()))
          .build();
      }

      return Response.ok(result).build();

    } catch (Exception e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .entity(createErrorResponse("Failed to search rule: " + e.getMessage()))
        .build();
    }
  }

  private RuleDetailsResponseDTO executeRuleDetailsQuery(RealmID realmId, String ruleName, String alertText,
                                                         String scopeName) {
    String sql = "SELECT DISTINCT " +
      "scope_ref.scope_name, " +
      "alert_rule.alert_rule_id, " +
      "alert_rule.rule_name, " +
      "alert_rule_body.alert_rule_body_id, " +
      "alert_rule_body.rule_body, " +
      "alert_rule_body.realm_ref_id, " +
      "alert_text_ref.alert_text, " +
      "entity_association.customer_id, " +
      "entity_association.payer_id, " +
      "entity_association.provider_code, " +
      "entity_association_rule_map.is_disabled " +
      "FROM " +
      "alert_configuration.alert_rule " +
      "INNER JOIN alert_configuration.alert_rule_body ON (alert_rule_body.alert_rule_id = alert_rule.alert_rule_id) "
      +
      "INNER JOIN alert_configuration.alert_text_ref ON (alert_rule.alert_text_ref_id = alert_text_ref.alert_text_ref_id) "
      +
      "INNER JOIN alert_configuration.entity_association_rule_map ON (entity_association_rule_map.alert_rule_id = alert_rule.alert_rule_id AND alert_rule_body.realm_ref_id = entity_association_rule_map.realm_ref_id) "
      +
      "INNER JOIN alert_configuration.scope_ref ON (scope_ref.scope_ref_id = alert_rule.scope_ref_id) " +
      "INNER JOIN alert_configuration.entity_association ON (entity_association_rule_map.entity_association_id = entity_association.entity_association_id) "
      +
      "WHERE " +
      "entity_association_rule_map.realm_ref_id = ? AND alert_rule_body.realm_ref_id = ?";

    List<Object> params = new ArrayList<>();
    params.add(realmId.getValue());
    params.add(realmId.getValue());

    // Add optional conditions
    if (ruleName != null && !ruleName.trim().isEmpty()) {
      sql += " AND alert_rule.rule_name LIKE ?";
      params.add("%" + ruleName + "%");
    }
    if (alertText != null && !alertText.trim().isEmpty()) {
      sql += " AND alert_text_ref.alert_text LIKE ?";
      params.add("%" + alertText + "%");
    }
    if (scopeName != null && !scopeName.trim().isEmpty()) {
      sql += " AND scope_ref.scope_name = ?";
      params.add(scopeName);
    }

    sql += " ORDER BY alert_rule_body.realm_ref_id, scope_ref.scope_name, alert_rule.rule_name";

    RuleDetailsResponseDTO result = new RuleDetailsResponseDTO();
    try (Connection conn = DatabaseManager.getConfigurationConnection(realmId);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

      // Set parameters
      for (int i = 0; i < params.size(); i++) {
        stmt.setObject(i + 1, params.get(i));
      }

      try (ResultSet rs = stmt.executeQuery()) {
        List<RuleDetailsDTO> rules = new ArrayList<>();
        while (rs.next()) {
          RuleDetailsDTO rule = new RuleDetailsDTO()
            .setRuleBody(rs.getString("rule_body"))
            .setScopeName(rs.getString("scope_name"))
            .setAlertRuleBodyId(rs.getInt("alert_rule_body_id"))
            .setRealmRefId(rs.getInt("realm_ref_id"))
            .setAlertText(rs.getString("alert_text"))
            .setRuleName(rs.getString("rule_name"))
            .setAlertRuleId(rs.getInt("alert_rule_id"))
            .setCustomerId(rs.getInt("customer_id"))
            .setPayerId(rs.getInt("payer_id"))
            .setProviderCode(rs.getString("provider_code"))
            .setIsDisabled(rs.getBoolean("is_disabled"));
          rules.add(rule);
        }
        result.setRules(rules);
      }
    } catch (Exception e) {
      result.setError("Failed to execute rule details query: " + e.getMessage());
    }
    return result;
  }

  @POST
  @Path("/bulk")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createBulkRules(
    @HeaderParam("Authorization") String authToken,
    List<CreateRuleDTO> ruleRequests) {

    if (authToken == null || authToken.trim().isEmpty()) {
      return Response.status(Response.Status.UNAUTHORIZED)
        .entity(createErrorResponse("Authorization token is required"))
        .build();
    }

    List<Map<String, Object>> results = new ArrayList<>();
    boolean hasErrors = false;

    // for (CreateRuleDTO ruleRequest : ruleRequests) {
    // try {
    // // Validate rule request
    // if (ruleRequest.getRule() == null || ruleRequest.getRelm() == null) {
    // Map<String, Object> error = new HashMap<>();
    // error.put("ruleName", ruleRequest.getRule() != null ?
    // ruleRequest.getRule().getName() : "Unknown");
    // error.put("error", "Invalid rule request: missing required fields");
    // results.add(error);
    // hasErrors = true;
    // continue;
    // }
    //
    // // Create rule
    // OkHttpClient client = new OkHttpClient();
    // ObjectMapper mapper = new ObjectMapper();
    // String jsonBody = mapper.writeValueAsString(ruleRequest.getRule());
    //
    // Request request = new Request.Builder()
    // .url(ruleRequest.getRelm().getScopeApiUrl() + "/rules/")
    // .addHeader("Content-Type", "application/json")
    // .addHeader("Accept", "application/json")
    // .addHeader("Authorization", authToken)
    // .post(okhttp3.RequestBody.create(
    // okhttp3.MediaType.parse("application/json"),
    // jsonBody))
    // .build();
    //
    // try (okhttp3.Response response = client.newCall(request).execute()) {
    // Map<String, Object> result = new HashMap<>();
    // result.put("ruleName", ruleRequest.getRule().getName());
    //
    // if (!response.isSuccessful()) {
    // String errorMessage;
    // if (response.code() == 409) {
    // errorMessage = "Rule already exists";
    // } else {
    // errorMessage = String.format("API request failed: %s (Status: %d)",
    // response.message(),
    // response.code());
    // }
    // result.put("error", errorMessage);
    // hasErrors = true;
    // } else {
    // result.put("status", "success");
    // result.put("response", response.body().string());
    // }
    // results.add(result);
    // }
    //
    // } catch (Exception e) {
    // Map<String, Object> error = new HashMap<>();
    // error.put("ruleName", ruleRequest.getRule() != null ?
    // ruleRequest.getRule().getName() : "Unknown");
    // error.put("error", "Failed to create rule: " + e.getMessage());
    // results.add(error);
    // hasErrors = true;
    // }
    // }

    Map<String, Object> response = new HashMap<>();
    response.put("results", results);
    response.put("totalRules", ruleRequests.size());
    response.put("successCount", results.stream().filter(r -> !r.containsKey("error")).count());
    response.put("hasErrors", hasErrors);

    return Response.status(hasErrors ? Response.Status.PARTIAL_CONTENT : Response.Status.OK)
      .entity(response)
      .build();
  }

  @POST
  @Path("/validate")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response validateRule(CreateRuleDTO request) {
    if (request == null) {
      return Response.status(Response.Status.BAD_REQUEST)
        .entity(createErrorResponse("Rule body is required"))
        .build();
    }

    String rule = request.getRule();
    try {
      boolean isValid = RuleHelper.isDroolsRuleValid(rule);
      Map<String, Object> response = new HashMap<>();
      response.put("valid", isValid);
      return Response.ok(response).build();
    } catch (Exception e) {
      e.printStackTrace();
      return Response.status(Response.Status.BAD_REQUEST)
        .entity(createErrorResponse("Invalid rule: " + e.getMessage()))
        .build();
    }
  }

  private Map<String, String> createErrorResponse(String message) {
    Map<String, String> response = new HashMap<>();
    response.put("error", message);
    return response;
  }

  @GET
  @Path("/cached")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getCachedRule(@QueryParam("realmId") RealmID realmId, @QueryParam("ruleName") String ruleName,
                                @QueryParam("alertText") String alertText) {

    // Validate realm
    if (realmId == null) {
      return Response.status(Response.Status.BAD_REQUEST)
        .entity(createErrorResponse("Realm ID is required"))
        .build();
    }

    // Validate that at least one search criteria is provided
    if ((ruleName == null || ruleName.trim().isEmpty()) && (alertText == null || alertText.trim().isEmpty())) {
      return Response.status(Response.Status.BAD_REQUEST)
        .entity(createErrorResponse("Either ruleName or alertText must be provided"))
        .build();
    }

    return getCachedRuleByPage(realmId, ruleName, alertText, 1);
  }

  private Response getCachedRuleByPage(RealmID realmId, String ruleName, String alertText, Integer page) {
    // Validate page number
    if (page == null || page < 1) {
      return Response.status(Response.Status.BAD_REQUEST)
        .entity(createErrorResponse("Page number must be greater than 0"))
        .build();
    }

    try {
      OkHttpClient client = new OkHttpClient();

      Request request = new Request.Builder()
        .url(realmId.getScopeApiUrl() + "/mgmt/rules?page=" + page.toString() + "&pageSize=1000")
        .addHeader("Accept", "*/*")
        .get()
        .build();

      try (okhttp3.Response response = client.newCall(request).execute()) {
        if (!response.isSuccessful()) {
          String errorMessage = String.format("Failed to fetch revenue cycle rules: %s (Status: %d)",
            response.message(),
            response.code());
          return Response.status(response.code())
            .entity(createErrorResponse(errorMessage))
            .build();
        }

        ObjectMapper mapper = new ObjectMapper();
        MgmtRuleResponseDTO mgmtRuleResponse = mapper.readValue(
          response.body().string(),
          MgmtRuleResponseDTO.class);
        // search the rule name in the list of rules
        List<InMemoryRuleDTO> ruleList = mgmtRuleResponse.getRuleList();
        List<InMemoryRuleDTO> filteredRuleList = new ArrayList<>();
        for (InMemoryRuleDTO rule : ruleList) {
          if (ruleName != null && rule.getRuleName().contains(ruleName)) {
            filteredRuleList.add(rule);
          } else if (alertText != null && rule.getAlertText().contains(alertText)) {
            filteredRuleList.add(rule);
          }
        }

        // if the rule is not found and is not the last page, fetch the next page
        if (filteredRuleList.isEmpty() && mgmtRuleResponse.getTotalPages() > page) {
          return getCachedRuleByPage(realmId, ruleName, alertText, page + 1);
        } else if (filteredRuleList.isEmpty() && mgmtRuleResponse.getTotalPages() <= page) {
          return Response.ok(new ArrayList<>()).build();
        } else if (!filteredRuleList.isEmpty()) {
          // Get rules from database to compare alert text
          for (InMemoryRuleDTO filteredRule : filteredRuleList) {
            try (Connection conn = DatabaseManager.getConfigurationConnection(realmId)){
              String sql = "SELECT alert_text_ref.alert_text " +
                " FROM alert_configuration.alert_rule " +
                "   INNER JOIN alert_configuration.alert_text_ref ON (alert_rule.alert_text_ref_id = alert_text_ref.alert_text_ref_id) " +
                " WHERE alert_rule.alert_rule_id = ?";

              try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, filteredRule.getRuleId());

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                  filteredRule.setDbAlertText(rs.getString("alert_text"));
                }

              }
            } catch (SQLException e) {
              e.printStackTrace();
            }
          }
          return Response.ok(new MgmtRuleResponseDTO(filteredRuleList)).build();
        }
        return Response.ok(filteredRuleList).build();
      }

    } catch (Exception e) {
      e.printStackTrace();
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .entity(createErrorResponse("Failed to fetch revenue cycle rules: " + e.getMessage()))
        .build();
    }
  }
}
