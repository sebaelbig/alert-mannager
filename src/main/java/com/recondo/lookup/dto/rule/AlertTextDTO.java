package com.recondo.lookup.dto.rule;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.ZonedDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlertTextDTO {
    
    @JsonProperty("alert_text_ref_id")
    private Integer alertTextRefId;
    
    @JsonProperty("alert_text")
    private String alertText;
    
    @JsonProperty("desc")
    private String description;
    
    @JsonProperty("valid_until")
    private ZonedDateTime validUntil;
    
    @JsonProperty("xact_username")
    private String xactUsername;
    
    @JsonProperty("xact_timestamp")
    private ZonedDateTime xactTimestamp;

    // Default constructor
    public AlertTextDTO() {}

    // Getters and Setters
    public Integer getAlertTextRefId() {
        return alertTextRefId;
    }

    public void setAlertTextRefId(Integer alertTextRefId) {
        this.alertTextRefId = alertTextRefId;
    }

    public String getAlertText() {
        return alertText;
    }

    public void setAlertText(String alertText) {
        this.alertText = alertText;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(ZonedDateTime validUntil) {
        this.validUntil = validUntil;
    }

    public String getXactUsername() {
        return xactUsername;
    }

    public void setXactUsername(String xactUsername) {
        this.xactUsername = xactUsername;
    }

    public ZonedDateTime getXactTimestamp() {
        return xactTimestamp;
    }

    public void setXactTimestamp(ZonedDateTime xactTimestamp) {
        this.xactTimestamp = xactTimestamp;
    }
}