package com.recondo.lookup.dto.rule;

public class RuleBody {
    private String body;
    private Integer id;
    private Boolean ignoreAlertTextValidation;
    private Integer realmId;

    // Getters and Setters
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIgnoreAlertTextValidation() {
        return ignoreAlertTextValidation;
    }

    public void setIgnoreAlertTextValidation(Boolean ignoreAlertTextValidation) {
        this.ignoreAlertTextValidation = ignoreAlertTextValidation;
    }

    public Integer getRealmId() {
        return realmId;
    }

    public void setRealmId(Integer realmId) {
        this.realmId = realmId;
    }
}