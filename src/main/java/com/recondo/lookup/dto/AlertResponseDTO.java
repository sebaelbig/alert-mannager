package com.recondo.lookup.dto;

import java.util.List;

public class AlertResponseDTO {
    private List<GeneratedAlertDTO> generatedAlerts;
    private String transactionId;
    private String encounterRid;

    // Getters and Setters
    public List<GeneratedAlertDTO> getGeneratedAlerts() {
        return generatedAlerts;
    }

    public void setGeneratedAlerts(List<GeneratedAlertDTO> generatedAlerts) {
        this.generatedAlerts = generatedAlerts;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getEncounterRid() {
        return encounterRid;
    }

    public void setEncounterRid(String encounterRid) {
        this.encounterRid = encounterRid;
    }
}