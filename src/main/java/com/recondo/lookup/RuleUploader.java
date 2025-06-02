package com.recondo.lookup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.RequestBody;

public class RuleUploader {
    private static final List<String> failureRuleList = new ArrayList<>();
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    
    private String authToken;
    private String baseUrl;
    private String scopeName;
    private String productValue = "EPLUS";
    private int realmId = 4; // TEST environment
    private boolean dryRun = true;

    public RuleUploader(String authToken, String baseUrl) {
        this.authToken = authToken;
        this.baseUrl = baseUrl;
    }

    private void failRule(String rule, String errorMessage) {
        failureRuleList.add(String.format("%s: %s", errorMessage, rule));
    }

    private Response getFromUrl(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
                
        Response response = client.newCall(request).execute();
        if (!isSuccessful(response.code())) {
            throw new IOException("Failed to get response from " + url);
        }
        return response;
    }

    private Response postToUrl(String url, String body) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(body, JSON);
            
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", authToken)
                .post(requestBody)
                .build();
                
        Response response = client.newCall(request).execute();
        if (!isSuccessful(response.code())) {
            throw new IOException("Failed to post to " + url);
        }
        return response;
    }

    private boolean isSuccessful(int code) {
        return code == 200 || code == 201 || code == 409;
    }

    public List<String> getFailures() {
        return new ArrayList<>(failureRuleList);
    }

    public void setDryRun(boolean dryRun) {
        this.dryRun = dryRun;
    }

    public void uploadRules(String rulesFile) {
        try {
            if (dryRun) {
                System.out.println("Dry run mode - no changes will be made");
            }
            
            // TODO: Implement rule file reading and processing
            // 1. Read the rules file
            // 2. Parse each rule
            // 3. Validate rule format
            // 4. If not dry run, upload each valid rule
            // 5. Track failures in failureRuleList
            
        } catch (Exception e) {
            System.err.println("Error uploading rules: " + e.getMessage());
            failRule("ALL", "Failed to process rules file: " + e.getMessage());
        }
    }
}