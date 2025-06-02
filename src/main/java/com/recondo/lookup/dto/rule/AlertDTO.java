package com.recondo.lookup.dto.rule;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.ZonedDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlertDTO {
    
    @JsonProperty("alert_rule_id")
    private Integer alertRuleId;
    
    @JsonProperty("scope_ref_id")
    private Integer scopeRefId;
    
    @JsonProperty("rule_name")
    private String ruleName;
    
    @JsonProperty("alert_text_ref_id")
    private Integer alertTextRefId;
    
    @JsonProperty("create_username")
    private String createUsername;
    
    @JsonProperty("create_timestamp")
    private ZonedDateTime createTimestamp;
    
    @JsonProperty("xact_username")
    private String xactUsername;
    
    @JsonProperty("xact_timestamp")
    private ZonedDateTime xactTimestamp;

    // Default constructor
    public AlertDTO() {}

    // Getters and Setters
    public Integer getAlertRuleId() {
        return alertRuleId;
    }

    public void setAlertRuleId(Integer alertRuleId) {
        this.alertRuleId = alertRuleId;
    }

    public Integer getScopeRefId() {
        return scopeRefId;
    }

    public void setScopeRefId(Integer scopeRefId) {
        this.scopeRefId = scopeRefId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Integer getAlertTextRefId() {
        return alertTextRefId;
    }

    public void setAlertTextRefId(Integer alertTextRefId) {
        this.alertTextRefId = alertTextRefId;
    }

    public String getCreateUsername() {
        return createUsername;
    }

    public void setCreateUsername(String createUsername) {
        this.createUsername = createUsername;
    }

    public ZonedDateTime getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(ZonedDateTime createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getXactUsername() {
        return xactUsername;
    }

    public void setXactUsername(String xactUsername) {
        this.xactUsername = xactUsername;
    }

    public ZonedDateTime getXactTimestamp() {
        return xactTimestamp;
    }

    public void setXactTimestamp(ZonedDateTime xactTimestamp) {
        this.xactTimestamp = xactTimestamp;
    }
}