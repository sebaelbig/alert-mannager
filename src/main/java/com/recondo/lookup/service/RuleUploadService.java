package com.recondo.lookup.service;

import com.recondo.lookup.dto.Message;
import com.recondo.lookup.dto.RulePayload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RuleUploadService {

    @Value("${rcalerts.api.base-url}")
    private String baseUrl;

    @Value("${rcalerts.api.auth-token}")
    private String authToken;

    private final RestTemplate restTemplate;

    public RuleUploadService() {
        this.restTemplate = new RestTemplate();
    }

    public List<String> extractRules(String content) {
        List<String> rules = new ArrayList<>();
        Pattern pattern = Pattern.compile("rule\\s+\\\".*?end\\s*", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            rules.add(matcher.group());
        }
        return rules;
    }

    public List<String> processRules(List<String> rules) {
        List<String> failedRules = new ArrayList<>();
        for (String rule : rules) {
            try {
                RulePayload payload = buildPayload(rule);
                postRule(payload);
            } catch (Exception e) {
                failedRules.add(rule);
            }
        }
        return failedRules;
    }

    private RulePayload buildPayload(String ruleText) {
        String ruleName = extractRuleName(ruleText);
        String alertText = extractAlertText(ruleText);
        List<String> payerIds = extractPayerIds(ruleText);
        List<String> providerIds = extractProviderIds(ruleText);

        RulePayload payload = new RulePayload();
        payload.setName(ruleName);
        payload.setScope(buildScope());
        payload.setDisabledByDefault(false);
        payload.setMessage(buildMessage(alertText));
        payload.setRuleBody(buildRuleBody(ruleText));

        return payload;
    }

    private void postRule(RulePayload payload) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + authToken);

        HttpEntity<RulePayload> request = new HttpEntity<>(payload, headers);
        restTemplate.postForEntity(baseUrl + "/rules", request, String.class);
    }

    private String extractRuleName(String ruleText) {
        Matcher matcher = Pattern.compile("rule\\s+\\\"([^\\\"]*)\\\"").matcher(ruleText);
        return matcher.find() ? matcher.group(1) : null;
    }

    private String extractAlertText(String ruleText) {
        Matcher matcher = Pattern.compile("ResponseUtils\\.addEplusAlertToResponse\\(\\$response,\\s*\\\"([^\\\"]*)\\\"").matcher(ruleText);
        return matcher.find() ? matcher.group(1) : null;
    }

    private List<String> extractPayerIds(String ruleText) {
        List<String> ids = new ArrayList<>();
        Matcher matcher = Pattern.compile("payerId\\s*[=!]=\\s*\\\"([^\\\"]*)\\\"").matcher(ruleText);
        while (matcher.find()) ids.add(matcher.group(1));
        return ids;
    }

    private List<String> extractProviderIds(String ruleText) {
        List<String> ids = new ArrayList<>();
        Matcher matcher = Pattern.compile("providerId\\s*[=!]=\\s*\\\"([^\\\"]*)\\\"").matcher(ruleText);
        while (matcher.find()) ids.add(matcher.group(1));
        return ids;
    }

    private Map<String, Object> buildScope() {
        String scopeName = "SHIELDS_RADIOLOGY_ALERTS"; // or inject via config
        String productName = "ELIGIBILITY_PLUS";
    
        String url = baseUrl + "/scopes?scopeName=" + scopeName + "&product=" + productName;
    
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + authToken);
    
        HttpEntity<Void> request = new HttpEntity<>(headers);
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, request, Map.class);
    
        List<Map<String, Object>> scopes = (List<Map<String, Object>>) response.getBody().get("scopes");
    
        Map<String, Object> scope = new HashMap<>();
        scope.put("name", scopeName);
        scope.put("productId", getProductId(productName)); // implement this method
        scope.put("disabledByDefault", false);
    
        for (Map<String, Object> s : scopes) {
            if (scopeName.equals(s.get("name"))) {
                scope.put("id", s.get("id"));
                break;
            }
        }
    
        return scope;
    }
    

    private Message buildMessage(String alertText) {
        String url = baseUrl + "/messages";
    
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + authToken);
    
        HttpEntity<Void> request = new HttpEntity<>(headers);
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, request, Map.class);
    
        List<Map<String, Object>> messages = (List<Map<String, Object>>) response.getBody().get("messages");
    
        for (Map<String, Object> message : messages) {
            if (alertText.equals(message.get("text"))) {
                Long id = ((Number) message.get("id")).longValue();
                return new Message(alertText, id);
            }
        }
    
        return new Message(alertText); // New message, no ID yet
    }
    

    private Map<String, Object> buildRuleBody(String ruleText) {
        String imports = String.join("\n",
            "package rules.eplusAlerts.convertedRuleScopes;",
            "import com.recondotech.revenueCycleAlerts.models.generation.ruleInput.RuleRequest;",
            "import com.recondotech.revenueCycleAlerts.models.generation.ruleInput.RuleResponse;",
            "import com.recondotech.revenueCycleAlerts.models.generation.ruleInput.eligibility.parts.response.RuleBenefit;",
            "import com.recondotech.revenueCycleAlerts.models.generation.ruleInput.eligibility.parts.response.RuleBenefitRelatedEntity;",
            "import com.recondotech.revenueCycleAlerts.models.generation.ruleInput.eligibility.parts.RuleRef;",
            "import com.recondotech.revenueCycleAlerts.models.generation.ruleInput.eligibility.parts.RuleProvider;",
            "import com.recondotech.revenueCycleAlerts.processors.generation.utils.ResponseUtils;",
            "import com.recondotech.revenueCycleAlerts.models.generation.providerInterface.ProviderInterface;",
            "import com.recondotech.revenueCycleAlerts.models.generation.providerInterface.parts.PayerPlan;",
            "import com.recondotech.revenueCycleAlerts.models.generation.ruleInput.eligibility.parts.RuleInsured;",
            "import com.recondotech.revenueCycleAlerts.models.generation.ruleInput.eligibility.parts.RuleEligibilityDate;",
            "import java.text.SimpleDateFormat;",
            "import java.util.HashSet;",
            "import java.util.ArrayList;",
            "import java.util.Map;",
            "import java.util.TreeSet;",
            "import org.apache.commons.lang.StringUtils;",
            "import com.recondotech.revenueCycleAlerts.processors.generation.utils.BenefitUtils;"
        );
    
        String fullRuleBody = imports + "\n\n" + ruleText;
    
        Map<String, Object> ruleBodyMap = new HashMap<>();
        ruleBodyMap.put("body", fullRuleBody);
        ruleBodyMap.put("realmId", getRealmId("PROD")); // You can change to TEST/STAGE as needed
    
        return ruleBodyMap;
    }

    private int getRealmId(String realmName) {
        String url = baseUrl + "/realms";
    
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + authToken);
    
        HttpEntity<Void> request = new HttpEntity<>(headers);
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, request, Map.class);
    
        List<Map<String, Object>> realms = (List<Map<String, Object>>) response.getBody().get("realmList");
    
        for (Map<String, Object> realm : realms) {
            if (realmName.equalsIgnoreCase((String) realm.get("name"))) {
                return ((Number) realm.get("realmId")).intValue();
            }
        }
    
        throw new RuntimeException("Realm not found: " + realmName);
    }
    
    private int getProductId(String productName) {
        String url = baseUrl + "/products";
    
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + authToken);
    
        HttpEntity<Void> request = new HttpEntity<>(headers);
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, request, Map.class);
    
        List<Map<String, Object>> products = (List<Map<String, Object>>) response.getBody().get("products");
    
        for (Map<String, Object> product : products) {
            if (productName.equalsIgnoreCase((String) product.get("name"))) {
                return ((Number) product.get("id")).intValue();
            }
        }
    
        throw new RuntimeException("Product not found: " + productName);
    }
}
