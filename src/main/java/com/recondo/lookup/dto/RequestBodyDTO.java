package com.recondo.lookup.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestBodyDTO {
    private Long realmId;
    private Long customerId;
    private String encounterRid;
    private String providerCode;
    private String recoPayerId;
    private String memberNumber;
    private String groupNumber;
    private Long dateOfService;
    private Long dateOfBirth;
    private Object providerInterface;
    private EligibilityResponseDTO eligibilityResponse;
    private Boolean outOfNetwork;
    private Boolean medicaid;
    private Boolean medicare;
    private Boolean spv;
    private Boolean isSpv;

    public Boolean getSpv() {
        return spv;
    }

    public void setSpv(Boolean spv) {
        this.spv = spv;
    }

    public Boolean getOutOfNetwork() {
        return outOfNetwork;
    }

    public void setOutOfNetwork(Boolean outOfNetwork) {
        this.outOfNetwork = outOfNetwork;
    }

    public Boolean getMedicaid() {
        return medicaid;
    }

    public void setMedicaid(Boolean medicaid) {
        this.medicaid = medicaid;
    }

    public Boolean getMedicare() {
        return medicare;
    }

    public void setMedicare(Boolean medicare) {
        this.medicare = medicare;
    }
    public Boolean getIsSpv() {
        return isSpv;
    }

    public void setIsSpv(Boolean isSpv) {
        this.isSpv = isSpv;
    }

    // Getters and Setters
    public Long getRealmId() {
        return realmId;
    }

    public void setRealmId(Long realmId) {
        this.realmId = realmId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getEncounterRid() {
        return encounterRid;
    }

    public void setEncounterRid(String encounterRid) {
        this.encounterRid = encounterRid;
    }

    public String getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }

    public String getRecoPayerId() {
        return recoPayerId;
    }

    public void setRecoPayerId(String recoPayerId) {
        this.recoPayerId = recoPayerId;
    }

    public String getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Long getDateOfService() {
        return dateOfService;
    }

    public void setDateOfService(Long dateOfService) {
        this.dateOfService = dateOfService;
    }

    public Long getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Object getProviderInterface() {
        return providerInterface;
    }

    public void setProviderInterface(Object providerInterface) {
        this.providerInterface = providerInterface;
    }

    public EligibilityResponseDTO getEligibilityResponse() {
        return eligibilityResponse;
    }

    public void setEligibilityResponse(EligibilityResponseDTO eligibilityResponse) {
        this.eligibilityResponse = eligibilityResponse;
    }
}