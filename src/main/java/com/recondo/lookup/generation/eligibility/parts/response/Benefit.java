package com.recondo.lookup.generation.eligibility.parts.response;

import com.recondo.lookup.generation.eligibility.parts.DiagnosisCode;
import com.recondo.lookup.generation.eligibility.parts.EligibilityDate;
import com.recondo.lookup.generation.eligibility.parts.Ref;
import com.recondo.lookup.generation.eligibility.parts.codes.BenefitTypeCode;
import com.recondo.lookup.generation.eligibility.parts.codes.CvgeLevelCode;
import com.recondo.lookup.generation.eligibility.parts.codes.InsurTypeCode;
import com.recondo.lookup.generation.eligibility.parts.codes.QtyQlfr;
import com.recondo.lookup.generation.eligibility.parts.codes.ServiceTypeCode;
import com.recondo.lookup.generation.eligibility.parts.codes.SvcIdQlfr;
import com.recondo.lookup.generation.eligibility.parts.codes.TimePeriodQlfr;
import com.recondo.lookup.generation.eligibility.parts.codes.YesNoIndicator;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the EB segment of a X12 270/271 EDI
 * 
 * @author Robert.Larivee
 */
public class Benefit implements Serializable {
	private static final long serialVersionUID = 1L;

	private BenefitTypeCode benefitType;
	private String benefitTypeDesc;

	private CvgeLevelCode coverageLevel;
	private String coverageLevelDesc;

	@Size(max = 99)
	private List<ServiceTypeCode> serviceTypes = new ArrayList<>();

	private InsurTypeCode insurTypeCode;
	private String insurTypeCodeDesc;

	@Size(min = 1, max = 50)
	private String planDescription;

	private TimePeriodQlfr timePeriodQlfr;
	private String timePeriodQlfrDesc;

	private Double amount;
	private Double percentage;

	private QtyQlfr quantityQlfr;
	private String quantityQlfrDesc;
	private Double quantity;

	private YesNoIndicator authRequired;
	private String authRequiredDesc;

	private YesNoIndicator planNetwork;
	private String planNetworkDesc;

	private List<String> sources = new ArrayList<>();

	// EB14
	private DiagnosisCode diagnosisCode1;
	private DiagnosisCode diagnosisCode2;
	private DiagnosisCode diagnosisCode3;
	private DiagnosisCode diagnosisCode4;

	// EB13
	private SvcIdQlfr svcIdQlfr;
	private String svcIdQlfrDesc;

	@Size(min = 1, max = 48)
	private String svcIdStart;
	@Size(min = 1, max = 48)
	private String svcIdEnd;

	@Size(min = 2, max = 2)
	private String procModifier1;
	@Size(min = 2, max = 2)
	private String procModifier2;
	@Size(min = 2, max = 2)
	private String procModifier3;
	@Size(min = 2, max = 2)
	private String procModifier4;

	@Size(max = 9)
	private List<HealthcareServiceDelivery> hsds = new ArrayList<>();

	@Size(max = 10)
	private List<String> msgs = new ArrayList<>();

	@Size(max = 9)
	private List<Ref> refs = new ArrayList<>();

	@Size(max = 20)
	private List<EligibilityDate> dates = new ArrayList<>();

	@Size(max = 10)
	private List<AdditionalInfo> additionalInfos = new ArrayList<>();

	@Size(max = 23)
	private List<BenefitRelatedEntity> relatedEntities = new ArrayList<>();

	@Size(max = 9)
	private List<BenefitError> benefitErrors = new ArrayList<>();

	private Boolean filtered = false;

	private List<BenefitRevision> benefitRevisions =  new ArrayList<>();

	private String instanceId;


	// Must have a default constructor for Jackson to use when parsing JSON
	public Benefit() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


	public BenefitTypeCode getBenefitType() {
		return benefitType;
	}
	public void setBenefitType(BenefitTypeCode benefitType) {
		this.benefitType = benefitType;
	}

	public String getBenefitTypeDesc() {
		return benefitTypeDesc;
	}
	public void setBenefitTypeDesc(String benefitTypeDesc) {
		this.benefitTypeDesc = benefitTypeDesc;
	}

	public CvgeLevelCode getCoverageLevel() {
		return coverageLevel;
	}
	public void setCoverageLevel(CvgeLevelCode coverageLevel) {
		this.coverageLevel = coverageLevel;
	}

	public String getCoverageLevelDesc() {
		return coverageLevelDesc;
	}
	public void setCoverageLevelDesc(String coverageLevelDesc) {
		this.coverageLevelDesc = coverageLevelDesc;
	}

	public List<ServiceTypeCode> getServiceTypes() {
		return serviceTypes;
	}
	public void setServiceTypes(List<ServiceTypeCode> serviceTypes) {
		this.serviceTypes = serviceTypes;
	}
	public void addServiceType(ServiceTypeCode serviceType) {
		serviceTypes.add(serviceType);
	}

	public InsurTypeCode getInsurTypeCode() {
		return insurTypeCode;
	}
	public void setInsurTypeCode(InsurTypeCode insurTypeCode) {
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

	public TimePeriodQlfr getTimePeriodQlfr() {
		return timePeriodQlfr;
	}
	public void setTimePeriodQlfr(TimePeriodQlfr timePeriodQlfr) {
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

	public QtyQlfr getQuantityQlfr() {
		return quantityQlfr;
	}
	public void setQuantityQlfr(QtyQlfr quantityQlfr) {
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

	public YesNoIndicator getAuthRequired() {
		return authRequired;
	}
	public void setAuthRequired(YesNoIndicator authRequired) {
		this.authRequired = authRequired;
	}

	public String getAuthRequiredDesc() {
		return authRequiredDesc;
	}
	public void setAuthRequiredDesc(String authRequiredDesc) {
		this.authRequiredDesc = authRequiredDesc;
	}

	public YesNoIndicator getPlanNetwork() {
		return planNetwork;
	}
	public void setPlanNetwork(YesNoIndicator planNetwork) {
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
	public DiagnosisCode getDiagnosisCode1() {
		return diagnosisCode1;
	}
	public void setDiagnosisCode1(DiagnosisCode diagnosisCode1) {
		this.diagnosisCode1 = diagnosisCode1;
	}

	public DiagnosisCode getDiagnosisCode2() {
		return diagnosisCode2;
	}
	public void setDiagnosisCode2(DiagnosisCode diagnosisCode2) {
		this.diagnosisCode2 = diagnosisCode2;
	}

	public DiagnosisCode getDiagnosisCode3() {
		return diagnosisCode3;
	}
	public void setDiagnosisCode3(DiagnosisCode diagnosisCode3) {
		this.diagnosisCode3 = diagnosisCode3;
	}

	public DiagnosisCode getDiagnosisCode4() {
		return diagnosisCode4;
	}
	public void setDiagnosisCode4(DiagnosisCode diagnosisCode4) {
		this.diagnosisCode4 = diagnosisCode4;
	}

	// EB13
	public SvcIdQlfr getSvcIdQlfr() {
		return svcIdQlfr;
	}
	public void setSvcIdQlfr(SvcIdQlfr svcIdQlfr) {
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

	public List<HealthcareServiceDelivery> getHsds() {
		return hsds;
	}
	public void setHsds(List<HealthcareServiceDelivery> hsds) {
		this.hsds = hsds;
	}
	public void addHsd(HealthcareServiceDelivery hsd) {
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

	public List<Ref> getRefs() {
		return refs;
	}
	public void setRefs(List<Ref> refs) {
		this.refs = refs;
	}
	public void addRef(Ref ref) {
		refs.add(ref);
	}

	public List<EligibilityDate> getDates() {
		return dates;
	}
	public void setDates(List<EligibilityDate> dates) {
		this.dates = dates;
	}
	public void addDate(EligibilityDate date) {
		dates.add(date);
	}

	public List<AdditionalInfo> getAdditionalInfos() {
		return additionalInfos;
	}
	public void setAdditionalInfos(List<AdditionalInfo> additionalInfos) {
		this.additionalInfos = additionalInfos;
	}
	public void addAdditionalInfo(AdditionalInfo additionalInfo) {
		additionalInfos.add(additionalInfo);
	}

	public List<BenefitRelatedEntity> getRelatedEntities() {
		return relatedEntities;
	}
	public void setRelatedEntities(List<BenefitRelatedEntity> relatedEntities) {
		this.relatedEntities = relatedEntities;
	}
	public void addRelatedEntity(BenefitRelatedEntity relatedEntity) {
		relatedEntities.add(relatedEntity);
	}

	public List<BenefitError> getBenefitErrors() {
		return benefitErrors;
	}
	public void setBenefitErrors(List<BenefitError> benefitErrors) {
		this.benefitErrors = benefitErrors;
	}
	public void addBenefitError(BenefitError benefitError) {
		benefitErrors.add(benefitError);
	}

	public Boolean getFiltered() {
		return filtered;
	}
	public void setFiltered(Boolean filtered) {
		this.filtered = filtered;
	}

	public List<BenefitRevision> getBenefitRevisions() {
		return benefitRevisions;
	}
	public void setBenefitRevisions(List<BenefitRevision> benefitRevisions) {
		this.benefitRevisions = benefitRevisions;
	}
	public void addBenefitRevision(BenefitRevision benefitRevision){
		this.benefitRevisions.add(benefitRevision);
	}

	public String getInstanceId() {
		return instanceId;
	}
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
}
