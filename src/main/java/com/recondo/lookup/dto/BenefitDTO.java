package com.recondo.lookup.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BenefitDTO {
    private String benefitType;
    private String coverageLevel;
    private List<String> serviceTypes;
    private String insurTypeCode;
    private String planDescription;
    private List<String> sources;
    private List<String> hsds;
    private List<String> msgs;
    private List<ReferenceDTO> refs;
    private List<DateDTO> dates;
    private List<AdditionalInfoDTO> additionalInfos;
    private List<EntityDTO> relatedEntities;
    private List<String> benefitErrors;
    private Boolean filtered;
    private List<String> benefitRevisions;
    private String planNetwork;
    private Double percentage;
    private String timePeriodQlfr;
    private Double amount;
    private String authRequired;
    private String quantityQlfr;
    
    public String getQuantityQlfr() {
        return quantityQlfr;
    }

    public void setQuantityQlfr(String quantityQlfr) {
        this.quantityQlfr = quantityQlfr;
    }

    public String getBenefitType() {
        return benefitType;
    }

    public void setBenefitType(String benefitType) {
        this.benefitType = benefitType;
    }

    public String getCoverageLevel() {
        return coverageLevel;
    }

    public void setCoverageLevel(String coverageLevel) {
        this.coverageLevel = coverageLevel;
    }

    public List<String> getServiceTypes() {
        return serviceTypes;
    }

    public void setServiceTypes(List<String> serviceTypes) {
        this.serviceTypes = serviceTypes;
    }

    public String getInsurTypeCode() {
        return insurTypeCode;
    }

    public void setInsurTypeCode(String insurTypeCode) {
        this.insurTypeCode = insurTypeCode;
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription;
    }

    public List<String> getSources() {
        return sources;
    }

    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    public List<String> getHsds() {
        return hsds;
    }

    public void setHsds(List<String> hsds) {
        this.hsds = hsds;
    }

    public List<String> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<String> msgs) {
        this.msgs = msgs;
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

    public List<AdditionalInfoDTO> getAdditionalInfos() {
        return additionalInfos;
    }

    public void setAdditionalInfos(List<AdditionalInfoDTO> additionalInfos) {
        this.additionalInfos = additionalInfos;
    }

    public List<EntityDTO> getRelatedEntities() {
        return relatedEntities;
    }

    public void setRelatedEntities(List<EntityDTO> relatedEntities) {
        this.relatedEntities = relatedEntities;
    }

    public List<String> getBenefitErrors() {
        return benefitErrors;
    }

    public void setBenefitErrors(List<String> benefitErrors) {
        this.benefitErrors = benefitErrors;
    }

    public Boolean getFiltered() {
        return filtered;
    }

    public void setFiltered(Boolean filtered) {
        this.filtered = filtered;
    }

    public List<String> getBenefitRevisions() {
        return benefitRevisions;
    }

    public void setBenefitRevisions(List<String> benefitRevisions) {
        this.benefitRevisions = benefitRevisions;
    }

    public String getPlanNetwork() {
        return planNetwork;
    }

    public void setPlanNetwork(String planNetwork) {
        this.planNetwork = planNetwork;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public String getTimePeriodQlfr() {
        return timePeriodQlfr;
    }

    public void setTimePeriodQlfr(String timePeriodQlfr) {
        this.timePeriodQlfr = timePeriodQlfr;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getAuthRequired() {
        return authRequired;
    }

    public void setAuthRequired(String authRequired) {
        this.authRequired = authRequired;
    }

}