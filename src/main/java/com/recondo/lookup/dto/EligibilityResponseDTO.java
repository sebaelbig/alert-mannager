package com.recondo.lookup.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EligibilityResponseDTO {
    private HeaderDTO header;
    private EntityDTO payer;
    private EntityDTO provider;
    private EntityDTO subscriber;
    private EntityDTO dependent;
    private List<BenefitDTO> benefits;
    private List<ReferenceDTO> refSegments;

    public List<ReferenceDTO> getRefSegments() {
        return refSegments;
    }

    public void setRefSegments(List<ReferenceDTO> refSegments) {
        this.refSegments = refSegments;
    }

    public HeaderDTO getHeader() {
        return header;
    }

    public void setHeader(HeaderDTO header) {
        this.header = header;
    }

    public EntityDTO getPayer() {
        return payer;
    }

    public void setPayer(EntityDTO payer) {
        this.payer = payer;
    }

    public EntityDTO getProvider() {
        return provider;
    }

    public void setProvider(EntityDTO provider) {
        this.provider = provider;
    }

    public EntityDTO getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(EntityDTO subscriber) {
        this.subscriber = subscriber;
    }

    public EntityDTO getDependent() {
        return dependent;
    }

    public void setDependent(EntityDTO dependent) {
        this.dependent = dependent;
    }

    public List<BenefitDTO> getBenefits() {
        return benefits;
    }

    public void setBenefits(List<BenefitDTO> benefits) {
        this.benefits = benefits;
    }
}