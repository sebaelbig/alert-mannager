package com.recondo.lookup.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recondo.lookup.generation.AlertRequest;
import com.recondo.lookup.generation.AlertResponse;

public class DatamartDTO {

    private AlertRequest requestBody;
    private String requestBodyJSON;
    private AlertResponse responseBody;

    public AlertRequest getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        try {
            this.requestBodyJSON = requestBody;
            ObjectMapper mapper = new ObjectMapper();
            this.requestBody = mapper.readValue(requestBody, AlertRequest.class);
        } catch (Exception e) {
            throw new RuntimeException("Error deserializing request body", e);
        }
    }

    public String getRequestBodyJSON() {
        return requestBodyJSON;
    }

    public void setRequestBodyJSON(String requestBodyJSON) {
        this.requestBodyJSON = requestBodyJSON;
    }

    public AlertResponse getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            this.responseBody = mapper.readValue(responseBody, AlertResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Error deserializing response body", e);
        }
    }
}
