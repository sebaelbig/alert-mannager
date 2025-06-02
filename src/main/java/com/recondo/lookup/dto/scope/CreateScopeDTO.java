package com.recondo.lookup.dto.scope;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.recondo.lookup.RealmID;

public class CreateScopeDTO {
    private RealmID realm;
    private ScopeDetails scope;
    private Cookies cookies;
    private String authToken;

    // Add getter and setter for authToken
    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    // Updated Getters and Setters for relm
    public RealmID getRealm() {
        return realm;
    }

    public void setRealm(RealmID relm) {
        this.realm = relm;
    }

    public ScopeDetails getScope() {
        return scope;
    }

    public void setScope(ScopeDetails scope) {
        this.scope = scope;
    }

    public Cookies getCookies() {
        return cookies;
    }

    public void setCookies(Cookies cookies) {
        this.cookies = cookies;
    }

    // Inner class for scope details
    public static class ScopeDetails {
        private boolean disabledByDefault = false; // Default value set to false
        private String name;
        private int productId = 3; // Default value set to 3
        private boolean terminateAfterHit = true; // Default value set to true

        // Getters and Setters
        public boolean isDisabledByDefault() {
            return disabledByDefault;
        }

        public void setDisabledByDefault(boolean disabledByDefault) {
            this.disabledByDefault = disabledByDefault;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public boolean isTerminateAfterHit() {
            return terminateAfterHit;
        }

        public void setTerminateAfterHit(boolean terminateAfterHit) {
            this.terminateAfterHit = terminateAfterHit;
        }
    }

    // Inner class for cookies
    public static class Cookies {
        private String dsmSessionId;
        private String jsessionId;

        public String getDsmSessionId() {
            return dsmSessionId;
        }

        public void setDsmSessionId(String dsmSessionId) {
            this.dsmSessionId = dsmSessionId;
        }

        public String getJsessionId() {
            return jsessionId;
        }

        public void setJsessionId(String jsessionId) {
            this.jsessionId = jsessionId;
        }
    }

    @JsonCreator
    public static RealmID fromValue(int value) {
        for (RealmID realm : RealmID.values()) {
            if (realm.getValue() == value) {
                return realm;
            }
        }
        throw new IllegalArgumentException("Invalid realm value: " + value);
    }
}