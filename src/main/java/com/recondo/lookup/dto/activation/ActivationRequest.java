package com.recondo.lookup.dto.activation;

import com.recondo.lookup.dto.Customer;
import com.recondo.lookup.dto.Payer;

public class ActivationRequest {

    public static final String ACTION_ACTIVATE = "ACTIVATE";
    public static final String ACTION_DEACTIVATE = "DEACTIVATE";

    private String action;
    private Customer customer;
    private Payer payer;
    private String providerCode;

    // Getters and Setters
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        if (!ACTION_ACTIVATE.equals(action) && !ACTION_DEACTIVATE.equals(action)) {
            throw new IllegalArgumentException("Action must be either ACTIVATE or DEACTIVATE");
        }
        this.action = action;
    }

    public static ActivationRequest activationCustomer(int customerId) {
        ActivationRequest activationRequest = new ActivationRequest();
        activationRequest.action = ACTION_ACTIVATE;
        if (customerId > 0) {
            activationRequest.customer = new Customer();
            activationRequest.customer.setId(customerId);
        }
        return activationRequest;
    }

    public static ActivationRequest deactivate() {
        ActivationRequest activationRequest = new ActivationRequest();
        activationRequest.action = ACTION_DEACTIVATE;
        return activationRequest;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Payer getPayer() {
        return payer;
    }

    public void setPayer(Payer payer) {
        this.payer = payer;
    }

    public String getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }
}
