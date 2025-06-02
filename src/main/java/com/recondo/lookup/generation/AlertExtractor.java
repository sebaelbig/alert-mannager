package com.recondo.lookup.generation;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlertExtractor {

    public static List<String> getGeneratedAlertTexts(String jsonResponse) throws IOException {
        List<String> alertTexts = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonResponse);
        JsonNode generatedAlerts = rootNode.path("generatedAlerts");

        for (JsonNode alert : generatedAlerts) {
            String text = alert.path("text").asText();
            alertTexts.add(text);
        }

        return alertTexts;
    }


}

