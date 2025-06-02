package com.recondo.lookup.dto.rule;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.recondo.lookup.RealmID;

public class CreateRuleDTO {
    private RealmID relm;
    private RuleDetails rule;
    private Cookies cookies;
    private String authToken;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public RealmID getRelm() {
        return relm;
    }

    public void setRelm(RealmID relm) {
        this.relm = relm;
    }

    public RuleDetails getRule() {
        return rule;
    }

    public void setRule(RuleDetails rule) {
        this.rule = rule;
    }

    public Cookies getCookies() {
        return cookies;
    }

    public void setCookies(Cookies cookies) {
        this.cookies = cookies;
    }

    public static class RuleDetails {
        private boolean disabledByDefault = false;
        private String name;
        private int productId = 3;
        private boolean terminateAfterHit = true;

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