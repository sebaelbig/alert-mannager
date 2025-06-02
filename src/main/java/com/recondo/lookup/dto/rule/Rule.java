package com.recondo.lookup.dto.rule;

import com.recondo.lookup.dto.scope.Scope;

public class Rule {
    private String createTimestamp;
    private String createUsername;
    private Boolean disabledByDefault;
    private Integer id;
    private String lastUpdateTimestamp;
    private Message message;
    private String name;
    private RuleBody ruleBody;
    private Scope scope;
    private String username;

    // Getters and Setters
    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getCreateUsername() {
        return createUsername;
    }

    public void setCreateUsername(String createUsername) {
        this.createUsername = createUsername;
    }

    public Boolean getDisabledByDefault() {
        return disabledByDefault;
    }

    public void setDisabledByDefault(Boolean disabledByDefault) {
        this.disabledByDefault = disabledByDefault;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    public void setLastUpdateTimestamp(String lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RuleBody getRuleBody() {
        return ruleBody;
    }

    public void setRuleBody(RuleBody ruleBody) {
        this.ruleBody = ruleBody;
    }

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}