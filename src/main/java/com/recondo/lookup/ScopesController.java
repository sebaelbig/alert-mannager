package com.recondo.lookup;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recondo.lookup.dto.ActivationRequest;
import com.recondo.lookup.dto.CreateScopeDTO;
import com.recondo.lookup.dto.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@Path("/scopes")
public class ScopesController {

    @DELETE
    @Path("/{scopeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteScope(
            @PathParam("scopeId") String scopeId,
            @HeaderParam("Authorization") String authToken,
            @HeaderParam("Realm") RealmID realmId) {
        if (authToken == null || authToken.trim().isEmpty()) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity(createErrorResponse("Authorization token is required"))
                    .build();
        }

        try {
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
    public Response handleScopeRequest(CreateScopeDTO scopeRequest) {
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
                    .url(scopeRequest.getRelm().getScopeApiUrl())
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
    @Path("/activate/{realm}/{scopeName}/{customerId}")
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

            // Create activation request using DTOs
            ActivationRequest activationRequest = ActivationRequest.activateCustomer(customerId);

            // Convert DTO to JSON using ObjectMapper
            ObjectMapper mapper = new ObjectMapper();
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
                    String errorMessage = String.format("Failed to activate scope: %s (Status: %d)",
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
                    .entity(createErrorResponse("Failed to activate scope: " + e.getMessage()))
                    .build();
        }
    }

    private Map<String, String> createErrorResponse(String message) {
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        return response;
    }
}