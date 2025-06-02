package com.recondo.lookup.dto.scope;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Scope {
    private String description;
    private Boolean disabledByDefault;
    private Integer id;
    private String name;
    private int productId;
    private Boolean terminateAfterHit;
    private String username;
    private String validUntil;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Boolean getTerminateAfterHit() {
        return terminateAfterHit;
    }

    public void setTerminateAfterHit(Boolean terminateAfterHit) {
        this.terminateAfterHit = terminateAfterHit;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }
}