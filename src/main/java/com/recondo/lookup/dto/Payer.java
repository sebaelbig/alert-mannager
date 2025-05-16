package com.recondo.lookup.dto;

public class Payer {
    private String name;
    private Integer prsRecoPayerId;
    private String recId;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrsRecoPayerId() {
        return prsRecoPayerId;
    }

    public void setPrsRecoPayerId(Integer prsRecoPayerId) {
        this.prsRecoPayerId = prsRecoPayerId;
    }

    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }
}