package com.recondo.lookup.dto.rule;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RuleDetailsDTO {
    private String ruleBody;
    private String scopeName;
    private Integer alertRuleBodyId;
    private Integer realmRefId;
    private String alertText;
    private String ruleName;
    private Integer alertRuleId;
    private Integer customerId;
    private Integer payerId;
    private String providerCode;
    private Boolean isDisabled;

    // Getters
    public String getRuleBody() {
        return ruleBody;
    }

    public String getScopeName() {
        return scopeName;
    }

    public Integer getAlertRuleBodyId() {
        return alertRuleBodyId;
    }

    public Integer getRealmRefId() {
        return realmRefId;
    }

    public String getAlertText() {
        return alertText;
    }

    public String getRuleName() {
        return ruleName;
    }

    public Integer getAlertRuleId() {
        return alertRuleId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Integer getPayerId() {
        return payerId;
    }

    public String getProviderCode() {
        return providerCode;
    }

    public Boolean getIsDisabled() {
        return isDisabled;
    }

    // Modified setters to return 'this' for method chaining
    public RuleDetailsDTO setRuleBody(String ruleBody) {
        this.ruleBody = ruleBody;
        return this;
    }

    public RuleDetailsDTO setScopeName(String scopeName) {
        this.scopeName = scopeName;
        return this;
    }

    public RuleDetailsDTO setAlertRuleBodyId(Integer alertRuleBodyId) {
        this.alertRuleBodyId = alertRuleBodyId;
        return this;
    }

    public RuleDetailsDTO setRealmRefId(Integer realmRefId) {
        this.realmRefId = realmRefId;
        return this;
    }

    public RuleDetailsDTO setAlertText(String alertText) {
        this.alertText = alertText;
        return this;
    }

    public RuleDetailsDTO setRuleName(String ruleName) {
        this.ruleName = ruleName;
        return this;
    }

    public RuleDetailsDTO setAlertRuleId(Integer alertRuleId) {
        this.alertRuleId = alertRuleId;
        return this;
    }

    public RuleDetailsDTO setCustomerId(Integer customerId) {
        this.customerId = customerId;
        return this;
    }

    public RuleDetailsDTO setPayerId(Integer payerId) {
        this.payerId = payerId;
        return this;
    }

    public RuleDetailsDTO setProviderCode(String providerCode) {
        this.providerCode = providerCode;
        return this;
    }

    public RuleDetailsDTO setIsDisabled(Boolean isDisabled) {
        this.isDisabled = isDisabled;
        return this;
    }
}