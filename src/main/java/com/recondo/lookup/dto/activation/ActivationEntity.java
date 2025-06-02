package com.recondo.lookup.dto.activation;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.recondo.lookup.RealmID;
import com.recondo.lookup.dto.Customer;
import com.recondo.lookup.dto.Payer;

public class ActivationEntity {
    private Customer customer;
    private Integer id;
    @JsonProperty("isDisabled")
    private boolean disabled;
    private String lastUpdateTimestamp;
    private String lastUpdateUsername;
    private Payer payer;
    private String providerCode;
    private RealmID realm;

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    @JsonProperty("isDisabled")
    public boolean isDisabled() { return disabled; }
    @JsonProperty("isDisabled")
    public void setDisabled(boolean disabled) { this.disabled = disabled; }

    public String getLastUpdateTimestamp() { return lastUpdateTimestamp; }
    public void setLastUpdateTimestamp(String lastUpdateTimestamp) { this.lastUpdateTimestamp = lastUpdateTimestamp; }

    public String getLastUpdateUsername() { return lastUpdateUsername; }
    public void setLastUpdateUsername(String lastUpdateUsername) { this.lastUpdateUsername = lastUpdateUsername; }

    public Payer getPayer() { return payer; }
    public void setPayer(Payer payer) { this.payer = payer; }

    public String getProviderCode() { return providerCode; }
    public void setProviderCode(String providerCode) { this.providerCode = providerCode; }

    public RealmID getRealm() { return realm; }
    public void setRealm(RealmID realm) { this.realm = realm; }
}