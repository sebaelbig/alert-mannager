package com.recondo.lookup.dto.rule;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class InMemoryRuleDTO {
    @JsonProperty("alertText")
    private String alertText;

    @JsonProperty("ruleId")
    private Integer ruleId;

    @JsonProperty("ruleIdsContained")
    private List<Integer> ruleIdsContained;

    @JsonProperty("ruleName")
    private String ruleName;

    @JsonProperty("scopeId")
    private Integer scopeId;

    @JsonProperty("ruleBody")
    private String ruleBody;

    @JsonProperty("dbAlertText")
    private String dbAlertText;

    // Default constructor required for Jackson deserialization
    public InMemoryRuleDTO() {
    }

    // Constructor with parameters
    public InMemoryRuleDTO(String ruleName, String alertText, String ruleBody) {
        this.ruleName = ruleName;
        this.alertText = alertText;
        this.ruleBody = ruleBody;
    }

    // Getters and Setters
    public String getAlertText() {
        return alertText;
    }

    public void setAlertText(String alertText) {
        this.alertText = alertText;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public List<Integer> getRuleIdsContained() {
        return ruleIdsContained;
    }

    public void setRuleIdsContained(List<Integer> ruleIdsContained) {
        this.ruleIdsContained = ruleIdsContained;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Integer getScopeId() {
        return scopeId;
    }

    public void setScopeId(Integer scopeId) {
        this.scopeId = scopeId;
    }

    public String getRuleBody() {
        return ruleBody;
    }

    public void setRuleBody(String ruleBody) {
        this.ruleBody = ruleBody;
    }

    public String getDbAlertText() {
        return dbAlertText;
    }

    public void setDbAlertText(String dbAlertText) {
        this.dbAlertText = dbAlertText;
    }
}