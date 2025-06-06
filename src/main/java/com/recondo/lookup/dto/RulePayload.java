package com.recondo.lookup.dto;

public class RulePayload {
    private boolean disabledByDefault = false;
    private String name;
    private Object scope;
    private Object ruleBody;
    private Message message;

    public boolean isDisabledByDefault() {
        return disabledByDefault;
    }

    public void setDisabledByDefault(boolean disabledByDefault) {
        this.disabledByDefault = disabledByDefault;
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

    public Object getScope() {
        return scope;
    }

    public void setScope(Object scope) {
        this.scope = scope;
    }


    public Object getRuleBody() {
        return ruleBody;
    }

    public void setRuleBody(Object ruleBody) {
        this.ruleBody = ruleBody;
    }
}
