package com.recondo.lookup;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recondo.lookup.dto.activation.Activation;
import com.recondo.lookup.dto.activation.ActivationEntity;
import com.recondo.lookup.dto.activation.ActivationRequest;
import com.recondo.lookup.dto.activation.ActivationResponse;
import com.recondo.lookup.dto.scope.CreateScopeDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import com.fasterxml.jackson.annotation.JsonInclude;

@Path("/scopes")
public class ScopesController {

  @DELETE
  @Path("/{scopeName}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteByName(
    @PathParam("scopeName") String scopeName,
    @HeaderParam("Authorization") String authToken,
    @HeaderParam("Realm") RealmID realmId) {
    if (authToken == null || authToken.trim().isEmpty()) {
      return Response.status(Response.Status.UNAUTHORIZED)
        .entity(createErrorResponse("Authorization token is required"))
        .build();
    }

    try {
      // First get the scope_ref_id from the database
      String sql = "select scope_ref_id from alert_configuration.scope_ref where scope_name = ?";
      int scopeId;

      try (Connection conn = DatabaseManager.getConfigurationConnection(realmId);
           PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, scopeName);

        try (ResultSet rs = stmt.executeQuery()) {
          if (!rs.next()) {
            return Response.status(Response.Status.NOT_FOUND)
              .entity(createErrorResponse("Scope not found: " + scopeName))
              .build();
          }
          scopeId = rs.getInt("scope_ref_id");
        }
      }

      // Create HTTP client
      OkHttpClient client = new OkHttpClient();

      // Create request with the token
      Request request = new Request.Builder()
        .url(realmId.getScopeApiUrl() + "/" + scopeId)
        .addHeader("Accept", "*/*")
        .addHeader("Authorization", authToken)
        .delete()
        .build();

      // Execute the request
      try (okhttp3.Response response = client.newCall(request).execute()) {
        if (!response.isSuccessful()) {
          String errorMessage = String.format("Failed to delete scope: %s (Status: %d)",
            response.message(),
            response.code());
          return Response.status(response.code())
            .entity(createErrorResponse(errorMessage))
            .build();
        }

        // Return success response
        return Response.ok().build();
      }

    } catch (Exception e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .entity(createErrorResponse("Failed to delete scope: " + e.getMessage()))
        .build();
    }
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response create(CreateScopeDTO scopeRequest) {
    try {
      String token;
      if (scopeRequest.getAuthToken() != null && !scopeRequest.getAuthToken().isEmpty()) {
        token = scopeRequest.getAuthToken();
      } else {
        // Get the authentication token using cookies
        token = TokenHelper.getAuthToken(
          scopeRequest.getCookies().getDsmSessionId(),
          scopeRequest.getCookies().getJsessionId());
      }

      if (token == null) {
        return Response.status(Response.Status.UNAUTHORIZED)
          .entity(createErrorResponse("Failed to obtain authentication token"))
          .build();
      }

      // Create HTTP client
      OkHttpClient client = new OkHttpClient();

      // Convert only the scope details to JSON for the request
      ObjectMapper mapper = new ObjectMapper();
      String jsonBody = mapper.writeValueAsString(scopeRequest.getScope());

      // Create request with the token and JSON body
      Request request = new Request.Builder()
        .url(scopeRequest.getRealm().getScopeApiUrl() + "/scopes/")
        .addHeader("Content-Type", "application/json")
        .addHeader("Accept", "application/json")
        .addHeader("Authorization", token)
        .post(okhttp3.RequestBody.create(
          okhttp3.MediaType.parse("application/json"),
          jsonBody))
        .build();

      // Execute the request
      try (okhttp3.Response response = client.newCall(request).execute()) {
        String responseBody = response.body().string();

        if (!response.isSuccessful()) {
          String errorMessage;
          if (response.code() == 409) {
            errorMessage = "Unable to create scope: this scope already exists.";
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

        // Return the API response
        return Response.ok(responseBody).build();
      }

    } catch (Exception e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .entity(createErrorResponse("Failed to create scope: " + e.getMessage()))
        .build();
    }
  }

  @POST
  @Path("/activation/{realm}/{scopeName}/{customerId}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response activateScope(
    @PathParam("realm") RealmID realmId,
    @PathParam("scopeName") String scopeName,
    @PathParam("customerId") int customerId,
    @HeaderParam("Authorization") String authToken) {

    if (authToken == null || authToken.trim().isEmpty()) {
      return Response.status(Response.Status.UNAUTHORIZED)
        .entity(createErrorResponse("Authorization token is required"))
        .build();
    }

    try {
      // First get the scope_ref_id from the database
      String sql = "select scope_ref_id from alert_configuration.scope_ref where scope_name = ?";
      int scopeId;

      try (Connection conn = DatabaseManager.getConfigurationConnection(realmId);
           PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, scopeName);

        try (ResultSet rs = stmt.executeQuery()) {
          if (!rs.next()) {
            return Response.status(Response.Status.NOT_FOUND)
              .entity(createErrorResponse("Scope not found: " + scopeName))
              .build();
          }
          scopeId = rs.getInt("scope_ref_id");
        }
      }

      // Configure ObjectMapper to ignore null values
      ObjectMapper mapper = new ObjectMapper();
      mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

      // If the response is not successful, check if it is already activated for the
      // customerId
      Response getScopeActivationResponse = getScopeActivation(realmId, scopeId);
      Object res = getScopeActivationResponse.getEntity();
      String activationResponseJson = ((String) res);
      ActivationResponse activationResponse = mapper.readValue(activationResponseJson, ActivationResponse.class);

      // Check if the scope is already activated
      for (Activation activation : activationResponse.getActivations()) {
        if (activation.getCount() == 0) {
          continue;
        }

        for (ActivationEntity activationEntity : activation.getActivationEntities()) {
          if (activationEntity.getRealm() == null ||
            activationEntity.getRealm().getValue() != realmId.getValue()) {
            // Not this realm
            continue;
          }

          if (activationEntity.isDisabled()) {
            // Disabled
            continue;
          }

          if (activationEntity.getCustomer() == null) {
            // No customer
            if (activationEntity.getPayer() == null) {
              // No payer
              return Response.status(Response.Status.CONFLICT)
                .entity(createErrorResponse("Already generally activated for: " + realmId.getName()))
                .build();
            }
            // TODO check for the payer
          } else {
            // Check if it is activated for the customerId
            if (activationEntity.getCustomer().getId() == customerId) {
              // TODO check for the payer and customer
              return Response.status(Response.Status.CONFLICT)
                .entity(createErrorResponse("Already activated for: " + activationEntity.getCustomer().getName()))
                .build();
            }
          }
        }
      }

      // Create activation request using DTOs
      ActivationRequest activationRequest = ActivationRequest.activationCustomer(customerId);
      String jsonBody = mapper.writeValueAsString(activationRequest);

      Request request = new Request.Builder()
        .url(realmId.getScopeApiUrl() + "/activation/scopes/" + scopeId + "/" + realmId.getValue())
        .addHeader("Content-Type", "application/json")
        .addHeader("Accept", "text/plain")
        .addHeader("Authorization", authToken)
        .post(okhttp3.RequestBody.create(
          okhttp3.MediaType.parse("application/json"),
          jsonBody))
        .build();

      // Execute the request
      OkHttpClient client = new OkHttpClient();
      try (okhttp3.Response response = client.newCall(request).execute()) {
        if (!response.isSuccessful()) {
          String errorMessage = String.format(
            "Failed to activate scope: %s (Status: %d). RealmID: %d, body: %s",
            response.message(),
            response.code(),
            realmId.getValue(),
            jsonBody);
          return Response.status(response.code())
            .entity(createErrorResponse(errorMessage))
            .build();
        }

        // Return success response
        return Response.ok().build();
      }

    } catch (Exception e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .entity(createErrorResponse("Failed to activate scope: " + e.getMessage()))
        .build();
    }
  }

  public Response getScopeActivation(RealmID realmId, int scopeId) {

    try {
      // Create HTTP client
      OkHttpClient client = new OkHttpClient();

      // Build the URL with query parameters
      HttpUrl url = HttpUrl.parse(realmId.getScopeApiUrl() + "/activation/scopes/" + scopeId)
        .newBuilder()
        .addQueryParameter("page", "1")
        .addQueryParameter("pageSize", "1000")
        .build();

      // Create request
      Request request = new Request.Builder()
        .url(url)
        .addHeader("Accept", "application/json")
        .get()
        .build();

      // Execute the request
      try (okhttp3.Response response = client.newCall(request).execute()) {
        if (!response.isSuccessful()) {
          String errorMessage = String.format("Failed to get scope activation history: %s (Status: %d)",
            response.message(),
            response.code());
          return Response.status(response.code())
            .entity(createErrorResponse(errorMessage))
            .build();
        }

        // Return the API response
        String responseBody = response.body().string();

        return Response.ok(responseBody).build();
      }

    } catch (Exception e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .entity(createErrorResponse("Failed to get scope activation history: " + e.getMessage()))
        .build();
    }
  }

  @GET
  @Path("/activation")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getScopeActivationByName(
    @QueryParam("realmid") RealmID realmId,
    @QueryParam("scopeName") String scopeName) {

    try {
      // First get the scope_ref_id from the database
      String sql = "select scope_ref_id from alert_configuration.scope_ref where scope_name = ?";
      int scopeId;

      try (Connection conn = DatabaseManager.getConfigurationConnection(realmId);
           PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, scopeName);

        try (ResultSet rs = stmt.executeQuery()) {
          if (!rs.next()) {
            return Response.status(Response.Status.NOT_FOUND)
              .entity(createErrorResponse("Scope not found: " + scopeName))
              .build();
          }
          scopeId = rs.getInt("scope_ref_id");
        }
      }

      // Get activation info using existing method
      return getScopeActivation(realmId, scopeId);

    } catch (Exception e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .entity(createErrorResponse("Failed to get scope activation: " + e.getMessage()))
        .build();
    }
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllScopes(
    @QueryParam("realmId") RealmID realmId) {

    try {
      // Create HTTP client
      OkHttpClient client = new OkHttpClient();

      // Build the URL with query parameters
      HttpUrl url = HttpUrl.parse(realmId.getScopeApiUrl() + "/scopes")
        .newBuilder()
        .addQueryParameter("productId", String.valueOf(3))
        .addQueryParameter("page", String.valueOf(1))
        .addQueryParameter("pageSize", String.valueOf(1000))
        .build();

      // Create request with the token
      Request request = new Request.Builder()
        .url(url)
        .addHeader("Accept", "application/json")
        //.get()
        .build();

      // Execute the request
      try (okhttp3.Response response = client.newCall(request).execute()) {
        if (!response.isSuccessful()) {
          String errorMessage = String.format("Failed to get scopes: %s (Status: %d)",
            response.message(),
            response.code());
          return Response.status(response.code())
            .entity(createErrorResponse(errorMessage))
            .build();
        }

        // Return the API response
        String responseBody = response.body().string();
        return Response.ok(responseBody).build();
      }

    } catch (Exception e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .entity(createErrorResponse("Failed to get scopes: " + e.getMessage()))
        .build();
    }
  }

  private Map<String, String> createErrorResponse(String message) {
    Map<String, String> response = new HashMap<>();
    response.put("message", message);
    return response;
  }
}
