package com.recondo.lookup;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = RealmIDDeserializer.class)
public enum RealmID {

    DEV(4, "TEST", "http://dloualrtms000.recondo.vci/revenueCycleAlertsService/rcalerts/v1"),
    STAGE(3, "STAGE", "http://sloualrtms000.recondo.vci/revenueCycleAlertsService/rcalerts/v1"),
    PROD(1, "PROD", "http://Ploualrtms000.recondo.vci/revenueCycleAlertsService/rcalerts/v1");

    private final int value;
    private final String name;
    private final String scopeApiUrl;

    RealmID(int value, String name, String scopeApiUrl) {
        this.value = value;
        this.name = name;
        this.scopeApiUrl = scopeApiUrl;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getScopeApiUrl() {
        return scopeApiUrl;
    }
}
