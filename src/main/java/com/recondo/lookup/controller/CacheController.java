package com.recondo.lookup.controller;

import com.recondo.lookup.RealmID;
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

    private static final Map<RealmID, List<String>> REALM_HOSTS = new HashMap<>() {{
        put(RealmID.PROD, Arrays.asList(
            "ploualrtms001:8080", "ploualrtms002:8080", "ploualrtms003:8080", "ploualrtms004:8080",
            "ploualrtms005:8080", "ploualrtms006:8080", "plourtealt001:8080", "plourtealt002:8080",
            "plourtealt003:8080", "plourtealt004:8080"
        ));
        put(RealmID.STAGE, Arrays.asList(
            "sloualrtms001:8080", "sloualrtms002:8080"
        ));
        put(RealmID.DEV, Arrays.asList(
            "dloualrtms001:8080"
        ));
    }};

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

}
