package com.recondo.lookup.dto;

public class ContactDTO {
    private String contactFunctionCode;
    private String name;
    private String contactNumQlfr1;
    private String contactNum1;

    // Getters and Setters (omitted for brevity but should be implemented)
    public String getContactFunctionCode() {
        return contactFunctionCode;
    }

    public void setContactFunctionCode(String contactFunctionCode) {
        this.contactFunctionCode = contactFunctionCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumQlfr1() {
        return contactNumQlfr1;
    }

    public void setContactNumQlfr1(String contactNumQlfr1) {
        this.contactNumQlfr1 = contactNumQlfr1;
    }

    public String getContactNum1() {
        return contactNum1;
    }

    public void setContactNum1(String contactNum1) {
        this.contactNum1 = contactNum1;
    }
}