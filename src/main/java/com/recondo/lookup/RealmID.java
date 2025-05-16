package com.recondo.lookup;

public enum RealmID {

    DEV(4, "http://dloualrtms000.recondo.vci/revenueCycleAlertsService/rcalerts/v1/scopes"),
    STAGE(3, "http://sloualrtms000.recondo.vci/revenueCycleAlertsService/rcalerts/v1/scopes"),
    PROD(1, "http://Ploualrtms000.recondo.vci/revenueCycleAlertsService/rcalerts/v1/scopes");

    private final int value;
    private final String scopeApiUrl;

    RealmID(int value, String scopeApiUrl) {
        this.value = value;
        this.scopeApiUrl = scopeApiUrl;
    }

    public int getValue() {
        return value;
    }

    public String getScopeApiUrl() {
        return scopeApiUrl;
    }
}
