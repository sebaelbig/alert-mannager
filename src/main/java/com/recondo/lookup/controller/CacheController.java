package com.recondo.lookup.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recondo.lookup.RealmID;
import com.recondo.lookup.dto.cache.CacheRefreshRequest;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/cache")
public class CacheController {

  private static final Map<RealmID, List<String>> REALM_HOSTS = new HashMap<>() {
    {
      put(RealmID.PROD, Arrays.asList(
        "ploualrtms001:8080", "ploualrtms002:8080", "ploualrtms003:8080", "ploualrtms004:8080",
        "ploualrtms005:8080", "ploualrtms006:8080", "plourtealt001:8080", "plourtealt002:8080",
        "plourtealt003:8080", "plourtealt004:8080"));
      put(RealmID.STAGE, Arrays.asList(
        "sloualrtms001:8080", "sloualrtms002:8080"));
      put(RealmID.DEV, Arrays.asList(
        "dloualrtms001:8080"));
    }
  };

  @POST
  @Path("/refresh/{realm}")
  @Produces(MediaType.TEXT_PLAIN)
  public Response propagateMgmt(
    @PathParam("realm") RealmID realmId,
    @HeaderParam("Authorization") String authToken) {

    if (authToken == null || authToken.trim().isEmpty()) {
      return Response.status(Response.Status.UNAUTHORIZED)
        .entity("Authorization token is required")
        .build();
    }

    List<String> hosts = REALM_HOSTS.get(realmId);
    if (hosts == null || hosts.isEmpty()) {
      return Response.status(Response.Status.BAD_REQUEST)
        .entity("Unsupported or unknown realm: " + realmId)
        .build();
    }

    StringBuilder resultLog = new StringBuilder();
    OkHttpClient client = new OkHttpClient();

    for (String host : hosts) {
      String url = "http://" + host + "/revenueCycleAlertsService/rcalerts/v1/mgmt?propagate=false";
      Request request = new Request.Builder()
        .url(url)
        .addHeader("Content-Type", "application/json")
        .addHeader("Accept", "text/plain")
        .addHeader("Authorization", authToken)
        .post(okhttp3.RequestBody.create(
          okhttp3.MediaType.parse("application/json"), "{}"))
        .build();

      try (okhttp3.Response response = client.newCall(request).execute()) {
        String responseBody = response.body() != null ? response.body().string() : "";
        resultLog.append(String.format("[%s] %s: %s%n", realmId.name(), host, responseBody));
      } catch (Exception e) {
        resultLog.append(String.format("[%s] %s: ERROR - %s%n", realmId.name(), host, e.getMessage()));
      }
    }

    return Response.ok(resultLog.toString()).build();
  }

  @POST
  @Path("/scope")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response refreshCache(
    @QueryParam("realmid") RealmID realmID,
    CacheRefreshRequest request) {

    // Validate realm
    if (realmID == null) {
      return Response.status(Response.Status.BAD_REQUEST)
        .entity(createErrorResponse("Realm ID is required"))
        .build();
    }

    // Validate request body
    if (request == null || request.getScopeIds() == null || request.getScopeIds().isEmpty()) {
      return Response.status(Response.Status.BAD_REQUEST)
        .entity(createErrorResponse("Request must contain at least one scope ID"))
        .build();
    }

    // Validate that no scope IDs are null
    if (request.getScopeIds().stream().anyMatch(id -> id == null)) {
      return Response.status(Response.Status.BAD_REQUEST)
        .entity(createErrorResponse("Scope IDs cannot be null"))
        .build();
    }

    try {
      ObjectMapper mapper = new ObjectMapper();
      String jsonBody = mapper.writeValueAsString(request);

      Request httpRequest = new Request.Builder()
        .url(realmID.getScopeApiUrl() + "/cache/scopes")
        .addHeader("Content-Type", "application/json")
        .addHeader("Accept", "text/plain")
        .post(okhttp3.RequestBody.create(
          okhttp3.MediaType.parse("application/json"),
          jsonBody))
        .build();

      OkHttpClient client = new OkHttpClient();
      try (okhttp3.Response response = client.newCall(httpRequest).execute()) {
        if (!response.isSuccessful()) {
          String errorMessage = String.format("Failed to refresh cache: %s (Status: %d, URL: %s)",
            response.message(),
            response.code(),
            response.request().url());
          return Response.status(response.code())
            .entity(createErrorResponse(errorMessage))
            .build();
        }

        Map<String, Object> successResponse = new HashMap<>();
        successResponse.put("status", "success");
        successResponse.put("message", "Cache refreshed successfully");

        return Response.ok(successResponse).build();
      }

    } catch (Exception e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .entity(createErrorResponse("Failed to refresh cache: " + e.getMessage()))
        .build();
    }
  }

  private Map<String, String> createErrorResponse(String message) {
    Map<String, String> response = new HashMap<>();
    response.put("error", message);
    return response;
  }

}
