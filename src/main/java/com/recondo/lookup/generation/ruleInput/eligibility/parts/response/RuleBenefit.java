package com.recondo.lookup.generation.ruleInput.eligibility.parts.response;

import com.recondo.lookup.generation.ruleInput.eligibility.parts.RuleDiagnosisCode;
import com.recondo.lookup.generation.ruleInput.eligibility.parts.RuleEligibilityDate;
import com.recondo.lookup.generation.ruleInput.eligibility.parts.RuleRef;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents the EB segment of a X12 270/271 EDI
 */
public class RuleBenefit {
	private String benefitType;
	private String benefitTypeDesc;

	private String coverageLevel;
	private String coverageLevelDesc;

	private List<String> serviceTypes = new ArrayList<>();

	private String insurTypeCode;
	private String insurTypeCodeDesc;

	private String planDescription;

	private String timePeriodQlfr;
	private String timePeriodQlfrDesc;

	private Double amount;
	private Double percentage;

	private String quantityQlfr;
	private String quantityQlfrDesc;
	private Double quantity;

	private String authRequired;
	private String authRequiredDesc;

	private String planNetwork;
	private String planNetworkDesc;

	private List<String> sources = new ArrayList<>();

	// EB14
	private RuleDiagnosisCode diagnosisCode1;
	private RuleDiagnosisCode diagnosisCode2;
	private RuleDiagnosisCode diagnosisCode3;
	private RuleDiagnosisCode diagnosisCode4;

	// EB13
	private String svcIdQlfr;
	private String svcIdQlfrDesc;

	private String svcIdStart;
	private String svcIdEnd;

	private String procModifier1;
	private String procModifier2;
	private String procModifier3;
	private String procModifier4;

	private List<RuleHealthcareServiceDelivery> hsds = new ArrayList<>();

	private List<String> msgs = new ArrayList<>();

	private List<RuleRef> refs = new ArrayList<>();

	private List<RuleEligibilityDate> dates = new ArrayList<>();

	private List<RuleAdditionalInfo> additionalInfos = new ArrayList<>();

	private List<RuleBenefitRelatedEntity> relatedEntities = new ArrayList<>();

	private List<RuleBenefitError> benefitErrors = new ArrayList<>();

	private Boolean filtered = false;

	private String instanceId;


	public RuleBenefit() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


	public String getBenefitType() {
		return benefitType;
	}
	public void setBenefitType(String benefitType) {
		this.benefitType = benefitType;
	}

	public String getBenefitTypeDesc() {
		return benefitTypeDesc;
	}
	public void setBenefitTypeDesc(String benefitTypeDesc) {
		this.benefitTypeDesc = benefitTypeDesc;
	}

	public String getCoverageLevel() {
		return coverageLevel;
	}
	public void setCoverageLevel(String coverageLevel) {
		this.coverageLevel = coverageLevel;
	}

	public String getCoverageLevelDesc() {
		return coverageLevelDesc;
	}
	public void setCoverageLevelDesc(String coverageLevelDesc) {
		this.coverageLevelDesc = coverageLevelDesc;
	}

	public List<String> getServiceTypes() {
		return serviceTypes;
	}
	public void setServiceTypes(List<String> serviceTypes) {
		this.serviceTypes = serviceTypes;
	}
	public void addServiceType(String serviceType) {
		serviceTypes.add(serviceType);
	}

	public String getInsurTypeCode() {
		return insurTypeCode;
	}
	public void setInsurTypeCode(String insurTypeCode) {
		this.insurTypeCode = insurTypeCode;
	}

	public String getInsurTypeCodeDesc() {
		return insurTypeCodeDesc;
	}
	public void setInsurTypeCodeDesc(String insurTypeCodeDesc) {
		this.insurTypeCodeDesc = insurTypeCodeDesc;
	}

	public String getPlanDescription() {
		return planDescription;
	}
	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}

	public String getTimePeriodQlfr() {
		return timePeriodQlfr;
	}
	public void setTimePeriodQlfr(String timePeriodQlfr) {
		this.timePeriodQlfr = timePeriodQlfr;
	}

	public String getTimePeriodQlfrDesc() {
		return timePeriodQlfrDesc;
	}
	public void setTimePeriodQlfrDesc(String timePeriodQlfrDesc) {
		this.timePeriodQlfrDesc = timePeriodQlfrDesc;
	}

	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getPercentage() {
		return percentage;
	}
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public String getQuantityQlfr() {
		return quantityQlfr;
	}
	public void setQuantityQlfr(String quantityQlfr) {
		this.quantityQlfr = quantityQlfr;
	}

	public String getQuantityQlfrDesc() {
		return quantityQlfrDesc;
	}
	public void setQuantityQlfrDesc(String quantityQlfrDesc) {
		this.quantityQlfrDesc = quantityQlfrDesc;
	}

	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getAuthRequired() {
		return authRequired;
	}
	public void setAuthRequired(String authRequired) {
		this.authRequired = authRequired;
	}

	public String getAuthRequiredDesc() {
		return authRequiredDesc;
	}
	public void setAuthRequiredDesc(String authRequiredDesc) {
		this.authRequiredDesc = authRequiredDesc;
	}

	public String getPlanNetwork() {
		return planNetwork;
	}
	public void setPlanNetwork(String planNetwork) {
		this.planNetwork = planNetwork;
	}

	public String getPlanNetworkDesc() {
		return planNetworkDesc;
	}
	public void setPlanNetworkDesc(String planNetworkDesc) {
		this.planNetworkDesc = planNetworkDesc;
	}

	public List<String> getSources() {
		return sources;
	}
	public void setSources(List<String> sources) {
		this.sources = sources;
	}
	public void addSource(String source) {
		sources.add(source);
	}

	// EB14
	public RuleDiagnosisCode getDiagnosisCode1() {
		return diagnosisCode1;
	}
	public void setDiagnosisCode1(RuleDiagnosisCode diagnosisCode1) {
		this.diagnosisCode1 = diagnosisCode1;
	}

	public RuleDiagnosisCode getDiagnosisCode2() {
		return diagnosisCode2;
	}
	public void setDiagnosisCode2(RuleDiagnosisCode diagnosisCode2) {
		this.diagnosisCode2 = diagnosisCode2;
	}

	public RuleDiagnosisCode getDiagnosisCode3() {
		return diagnosisCode3;
	}
	public void setDiagnosisCode3(RuleDiagnosisCode diagnosisCode3) {
		this.diagnosisCode3 = diagnosisCode3;
	}

	public RuleDiagnosisCode getDiagnosisCode4() {
		return diagnosisCode4;
	}
	public void setDiagnosisCode4(RuleDiagnosisCode diagnosisCode4) {
		this.diagnosisCode4 = diagnosisCode4;
	}

	// EB13
	public String getSvcIdQlfr() {
		return svcIdQlfr;
	}
	public void setSvcIdQlfr(String svcIdQlfr) {
		this.svcIdQlfr = svcIdQlfr;
	}

	public String getSvcIdQlfrDesc() {
		return svcIdQlfrDesc;
	}
	public void setSvcIdQlfrDesc(String svcIdQlfrDesc) {
		this.svcIdQlfrDesc = svcIdQlfrDesc;
	}

	public String getSvcIdStart() {
		return svcIdStart;
	}
	public void setSvcIdStart(String svcIdStart) {
		this.svcIdStart = svcIdStart;
	}

	public String getSvcIdEnd() {
		return svcIdEnd;
	}
	public void setSvcIdEnd(String svcIdEnd) {
		this.svcIdEnd = svcIdEnd;
	}

	public String getProcModifier1() {
		return procModifier1;
	}
	public void setProcModifier1(String procModifier1) {
		this.procModifier1 = procModifier1;
	}

	public String getProcModifier2() {
		return procModifier2;
	}
	public void setProcModifier2(String procModifier2) {
		this.procModifier2 = procModifier2;
	}

	public String getProcModifier3() {
		return procModifier3;
	}
	public void setProcModifier3(String procModifier3) {
		this.procModifier3 = procModifier3;
	}

	public String getProcModifier4() {
		return procModifier4;
	}
	public void setProcModifier4(String procModifier4) {
		this.procModifier4 = procModifier4;
	}

	public List<RuleHealthcareServiceDelivery> getHsds() {
		return hsds;
	}
	public void setHsds(List<RuleHealthcareServiceDelivery> hsds) {
		this.hsds = hsds;
	}
	public void addHsd(RuleHealthcareServiceDelivery hsd) {
		hsds.add(hsd);
	}

	public List<String> getMsgs() {
		return msgs;
	}
	public void setMsgs(List<String> msgs) {
		this.msgs = msgs;
	}
	public void addMsg(String msg) {
		msgs.add(msg);
	}

	public List<RuleRef> getRefs() {
		return refs;
	}
	public List<RuleRef> getRefsOrBlankRef() {
		List<RuleRef> returnable;
		if (refs.size() > 0) {
			returnable = refs;
		} else {
			returnable = Collections.singletonList(new RuleRef());
		}
		return returnable;
	}
	public void setRefs(List<RuleRef> refs) {
		this.refs = refs;
	}
	public void addRef(RuleRef ref) {
		refs.add(ref);
	}

	public List<RuleEligibilityDate> getDates() {
		return dates;
	}
	public void setDates(List<RuleEligibilityDate> dates) {
		this.dates = dates;
	}
	public void addDate(RuleEligibilityDate date) {
		dates.add(date);
	}

	public List<RuleAdditionalInfo> getAdditionalInfos() {
		return additionalInfos;
	}
	public void setAdditionalInfos(List<RuleAdditionalInfo> additionalInfos) {
		this.additionalInfos = additionalInfos;
	}
	public void addAdditionalInfo(RuleAdditionalInfo additionalInfo) {
		additionalInfos.add(additionalInfo);
	}

	public List<RuleBenefitRelatedEntity> getRelatedEntities() {
		return relatedEntities;
	}
	public List<RuleBenefitRelatedEntity> getRelatedEntitiesOrBlankRelatedEntity() {
		List<RuleBenefitRelatedEntity> returnable;
		if (relatedEntities.size() > 0) {
			returnable = relatedEntities;
		} else {
			returnable = Collections.singletonList(new RuleBenefitRelatedEntity());
		}
		return returnable;
	}
	public void setRelatedEntities(List<RuleBenefitRelatedEntity> relatedEntities) {
		this.relatedEntities = relatedEntities;
	}
	public void addRelatedEntity(RuleBenefitRelatedEntity relatedEntity) {
		relatedEntities.add(relatedEntity);
	}

	public List<RuleBenefitError> getBenefitErrors() {
		return benefitErrors;
	}
	public void setBenefitErrors(List<RuleBenefitError> benefitErrors) {
		this.benefitErrors = benefitErrors;
	}
	public void addBenefitError(RuleBenefitError benefitError) {
		benefitErrors.add(benefitError);
	}

	public Boolean getFiltered() {
		return filtered;
	}
	public void setFiltered(Boolean filtered) {
		this.filtered = filtered;
	}

	public String getInstanceId() {
		return instanceId;
	}
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
}
