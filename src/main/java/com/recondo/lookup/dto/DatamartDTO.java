package com.recondo.lookup.dto;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DatamartDTO {

    private RequestBodyDTO requestBody;
    private String requestBodyJSON;
    private AlertResponseDTO responseBody;

    public RequestBodyDTO getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        try {
            this.requestBodyJSON = requestBody;
            ObjectMapper mapper = new ObjectMapper();
            this.requestBody = mapper.readValue(requestBody, RequestBodyDTO.class);
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

    public AlertResponseDTO getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            this.responseBody = mapper.readValue(responseBody, AlertResponseDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("Error deserializing response body", e);
        }
    }
}
