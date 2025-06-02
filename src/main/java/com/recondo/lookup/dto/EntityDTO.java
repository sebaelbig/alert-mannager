package com.recondo.lookup.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.recondo.lookup.generation.eligibility.parts.Contact;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EntityDTO {
    private String entityIdCode;
    private String entityTypeQlfr;
    private String firstName;
    private String middleName;
    private String lastName;
    private String idCodeQlfr;
    private String idCode;
    private String genderCode;
    private Long dateOfBirth;
    private String indRelCode;
    private String maintTypeCode;
    private String maintReasonCode;
    private List<ReferenceDTO> refs;
    private List<DateDTO> dates;
    private List<Contact> contacts;
    private List<String> diagnosisCodes;
    
    // Add address-related fields
    private String addressLine1;
    private String city;
    private String state;
    private String zipcode;
    private Date dateOfBirthDate;

    // Add getters and setters for new fields
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getEntityIdCode() {
        return entityIdCode;
    }

    public void setEntityIdCode(String entityIdCode) {
        this.entityIdCode = entityIdCode;
    }

    public String getEntityTypeQlfr() {
        return entityTypeQlfr;
    }

    public void setEntityTypeQlfr(String entityTypeQlfr) {
        this.entityTypeQlfr = entityTypeQlfr;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGenderCode() {
        return genderCode;
    }

    public void setGenderCode(String genderCode) {
        this.genderCode = genderCode;
    }

    public Long getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        if (dateOfBirth != null) {
            this.dateOfBirthDate = new Date(dateOfBirth);
        }
    }

    public Date getDateOfBirthDate() {
        return dateOfBirthDate;
    }

    public void setDateOfBirthDate(Date dateOfBirthDate) {
        this.dateOfBirthDate = dateOfBirthDate;
    }

    public String getIdCodeQlfr() {
        return idCodeQlfr;
    }

    public void setIdCodeQlfr(String idCodeQlfr) {
        this.idCodeQlfr = idCodeQlfr;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getIndRelCode() {
        return indRelCode;
    }

    public void setIndRelCode(String indRelCode) {
        this.indRelCode = indRelCode;
    }

    public String getMaintTypeCode() {
        return maintTypeCode;
    }

    public void setMaintTypeCode(String maintTypeCode) {
        this.maintTypeCode = maintTypeCode;
    }

    public String getMaintReasonCode() {
        return maintReasonCode;
    }

    public void setMaintReasonCode(String maintReasonCode) {
        this.maintReasonCode = maintReasonCode;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<ReferenceDTO> getRefs() {
        return refs;
    }

    public void setRefs(List<ReferenceDTO> refs) {
        this.refs = refs;
    }

    public List<DateDTO> getDates() {
        return dates;
    }

    public void setDates(List<DateDTO> dates) {
        this.dates = dates;
    }

    public List<String> getDiagnosisCodes() {
        return diagnosisCodes;
    }

    public void setDiagnosisCodes(List<String> diagnosisCodes) {
        this.diagnosisCodes = diagnosisCodes;
    }
}