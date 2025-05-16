package com.recondo.lookup.dto;

public class AlertConfigurationDTO {
    private String realmRefId;
    private String alertRuleId;
    private String ruleName;
    private String ruleBody;
    private String alertText;

    public String getRealmRefId() {
        return realmRefId;
    }

    public void setRealmRefId(String realmRefId) {
        this.realmRefId = realmRefId;
    }

    public String getAlertRuleId() {
        return alertRuleId;
    }

    public void setAlertRuleId(String alertRuleId) {
        this.alertRuleId = alertRuleId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleBody() {
        return ruleBody;
    }

    public void setRuleBody(String ruleBody) {
        this.ruleBody = ruleBody;
    }

    public String getAlertText() {
        return alertText;
    }

    public void setAlertText(String alertText) {
        this.alertText = alertText;
    }
}