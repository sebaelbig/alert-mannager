package com.recondo.lookup.generation.ruleInput.eligibility.parts;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents either the Subscriber or Dependent segment of a X12 270/271 EDI
 */
public class RuleInsured {
	// NM1
	private String entityIdCode;
	private String entityIdCodeDesc;

	private String entityTypeQlfr;
	private String entityTypeQlfrDesc;

	private String firstName;
	private String lastName;
	private String middleName;
	private String nameSuffix;

	private String idCodeQlfr;
	private String idCodeQlfrDesc;
	private String idCode;

	// DMG
	private String genderCode;
	private String genderCodeDesc;

	private Date dateOfBirth; 

	// N3/N4
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zipcode;
	private String countryCode;
	private String countrySubdivisionCode;

	// INS
	private String indRelCode;
	private String indRelCodeDesc;

	private String maintTypeCode;
	private String maintTypeCodeDesc;

	private String maintReasonCode;
	private String maintReasonCodeDesc;

	private Short birthSeqNumber;

	// REF
	private List<RuleRef> refs = new ArrayList<>();

	// DTP
	private List<RuleEligibilityDate> dates = new ArrayList<>();

	// MPI
	private String infStatusCode;
	private String infStatusCodeDesc;

	private String empStatusCode;
	private String empStatusCodeDesc;

	private String govServAffCode;
	private String govServAffCodeDesc;

	private String milServRankCode;
	private String milServRankCodeDesc;

	private String studentStatusCode;
	private String studentStatusCodeDesc;

	private String handicapIndicator;
	private String handicapIndicatorDesc;

	private Date mpiStartDate;
	private Date mpiEndDate;

	private String mpiDesc;

	// PRV
	private String provCode;
	private String provCodeDesc;

	private String refIdQlfr;
	private String refIdQlfrDesc;

	private String taxonomyId;

	private String locQlfr;
	private String locQlfrDesc;
	private String locId;

	// PER
	private List<RuleContact> contacts = new ArrayList<>();

	private List<RuleDiagnosisCode> diagnosisCodes = new ArrayList<>();


	public RuleInsured() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


	// NM1
	public String getEntityIdCode() {
		return entityIdCode;
	}
	public void setEntityIdCode(String entityIdCode) {
		this.entityIdCode = entityIdCode;
	}

	public String getEntityIdCodeDesc() {
		return entityIdCodeDesc;
	}
	public void setEntityIdCodeDesc(String entityIdCodeDesc) {
		this.entityIdCodeDesc = entityIdCodeDesc;
	}

	public String getEntityTypeQlfr() {
		return entityTypeQlfr;
	}
	public void setEntityTypeQlfr(String entityTypeQlfr) {
		this.entityTypeQlfr = entityTypeQlfr;
	}

	public String getEntityTypeQlfrDesc() {
		return entityTypeQlfrDesc;
	}
	public void setEntityTypeQlfrDesc(String entityTypeQlfrDesc) {
		this.entityTypeQlfrDesc = entityTypeQlfrDesc;
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

	public String getNameSuffix() {
		return nameSuffix;
	}
	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	public String getIdCodeQlfr() {
		return idCodeQlfr;
	}
	public void setIdCodeQlfr(String idCodeQlfr) {
		this.idCodeQlfr = idCodeQlfr;
	}

	public String getIdCodeQlfrDesc() {
		return idCodeQlfrDesc;
	}
	public void setIdCodeQlfrDesc(String idCodeQlfrDesc) {
		this.idCodeQlfrDesc = idCodeQlfrDesc;
	}

	public String getIdCode() {
		return idCode;
	}
	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}

	// DMG
	public String getGenderCode() {
		return genderCode;
	}
	public void setGenderCode(String genderCode) {
		this.genderCode = genderCode;
	}

	public String getGenderCodeDesc() {
		return genderCodeDesc;
	}
	public void setGenderCodeDesc(String genderCodeDesc) {
		this.genderCodeDesc = genderCodeDesc;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	// N3/N4
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
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

	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountrySubdivisionCode() {
		return countrySubdivisionCode;
	}
	public void setCountrySubdivisionCode(String countrySubdivisionCode) {
		this.countrySubdivisionCode = countrySubdivisionCode;
	}

	// INS
	public String getIndRelCode() {
		return indRelCode;
	}
	public void setIndRelCode(String indRelCode) {
		this.indRelCode = indRelCode;
	}

	public String getIndRelCodeDesc() {
		return indRelCodeDesc;
	}
	public void setIndRelCodeDesc(String indRelCodeDesc) {
		this.indRelCodeDesc = indRelCodeDesc;
	}

	public String getMaintTypeCode() {
		return maintTypeCode;
	}
	public void setMaintTypeCode(String maintTypeCode) {
		this.maintTypeCode = maintTypeCode;
	}

	public String getMaintTypeCodeDesc() {
		return maintTypeCodeDesc;
	}
	public void setMaintTypeCodeDesc(String maintTypeCodeDesc) {
		this.maintTypeCodeDesc = maintTypeCodeDesc;
	}

	public String getMaintReasonCode() {
		return maintReasonCode;
	}
	public void setMaintReasonCode(String maintReasonCode) {
		this.maintReasonCode = maintReasonCode;
	}

	public String getMaintReasonCodeDesc() {
		return maintReasonCodeDesc;
	}
	public void setMaintReasonCodeDesc(String maintReasonCodeDesc) {
		this.maintReasonCodeDesc = maintReasonCodeDesc;
	}

	public Short getBirthSeqNumber() {
		return birthSeqNumber;
	}
	public void setBirthSeqNumber(Short birthSeqNumber) {
		this.birthSeqNumber = birthSeqNumber;
	}

	// REF
	public List<RuleRef> getRefs() {
		return refs;
	}
	public void setRefs(List<RuleRef> refs) {
		this.refs = refs;
	}
	public void addRef(RuleRef ref) {
		refs.add(ref);
	}

	// DTP
	public List<RuleEligibilityDate> getDates() {
		return dates;
	}
	public void setDates(List<RuleEligibilityDate> dates) {
		this.dates = dates;
	}
	public void addDate(RuleEligibilityDate date) {
		dates.add(date);
	}

	// MPI
	public String getInfStatusCode() {
		return infStatusCode;
	}
	public void setInfStatusCode(String infStatusCode) {
		this.infStatusCode = infStatusCode;
	}

	public String getInfStatusCodeDesc() {
		return infStatusCodeDesc;
	}
	public void setInfStatusCodeDesc(String infStatusCodeDesc) {
		this.infStatusCodeDesc = infStatusCodeDesc;
	}

	public String getEmpStatusCode() {
		return empStatusCode;
	}
	public void setEmpStatusCode(String empStatusCode) {
		this.empStatusCode = empStatusCode;
	}

	public String getEmpStatusCodeDesc() {
		return empStatusCodeDesc;
	}
	public void setEmpStatusCodeDesc(String empStatusCodeDesc) {
		this.empStatusCodeDesc = empStatusCodeDesc;
	}

	public String getGovServAffCode() {
		return govServAffCode;
	}
	public void setGovServAffCode(String govServAffCode) {
		this.govServAffCode = govServAffCode;
	}

	public String getGovServAffCodeDesc() {
		return govServAffCodeDesc;
	}
	public void setGovServAffCodeDesc(String govServAffCodeDesc) {
		this.govServAffCodeDesc = govServAffCodeDesc;
	}

	public String getMilServRankCode() {
		return milServRankCode;
	}
	public void setMilServRankCode(String milServRankCode) {
		this.milServRankCode = milServRankCode;
	}

	public String getMilServRankCodeDesc() {
		return milServRankCodeDesc;
	}
	public void setMilServRankCodeDesc(String milServRankCodeDesc) {
		this.milServRankCodeDesc = milServRankCodeDesc;
	}

	public String getStudentStatusCode() {
		return studentStatusCode;
	}
	public void setStudentStatusCode(String studentStatusCode) {
		this.studentStatusCode = studentStatusCode;
	}

	public String getStudentStatusCodeDesc() {
		return studentStatusCodeDesc;
	}
	public void setStudentStatusCodeDesc(String studentStatusCodeDesc) {
		this.studentStatusCodeDesc = studentStatusCodeDesc;
	}

	public String getHandicapIndicator() {
		return handicapIndicator;
	}
	public void setHandicapIndicator(String handicapIndicator) {
		this.handicapIndicator = handicapIndicator;
	}

	public String getHandicapIndicatorDesc() {
		return handicapIndicatorDesc;
	}
	public void setHandicapIndicatorDesc(String handicapIndicatorDesc) {
		this.handicapIndicatorDesc = handicapIndicatorDesc;
	}

	public Date getMpiStartDate() {
		return mpiStartDate;
	}
	public void setMpiStartDate(Date mpiStartDate) {
		this.mpiStartDate = mpiStartDate;
	}

	public Date getMpiEndDate() {
		return mpiEndDate;
	}
	public void setMpiEndDate(Date mpiEndDate) {
		this.mpiEndDate = mpiEndDate;
	}

	public String getMpiDesc() {
		return mpiDesc;
	}
	public void setMpiDesc(String mpiDesc) {
		this.mpiDesc = mpiDesc;
	}

	// PRV
	public String getProvCode() {
		return provCode;
	}
	public void setProvCode(String provCode) {
		this.provCode = provCode;
	}

	public String getProvCodeDesc() {
		return provCodeDesc;
	}
	public void setProvCodeDesc(String provCodeDesc) {
		this.provCodeDesc = provCodeDesc;
	}

	public String getRefIdQlfr() {
		return refIdQlfr;
	}
	public void setRefIdQlfr(String refIdQlfr) {
		this.refIdQlfr = refIdQlfr;
	}

	public String getRefIdQlfrDesc() {
		return refIdQlfrDesc;
	}
	public void setRefIdQlfrDesc(String refIdQlfrDesc) {
		this.refIdQlfrDesc = refIdQlfrDesc;
	}

	public String getTaxonomyId() {
		return taxonomyId;
	}
	public void setTaxonomyId(String taxonomyId) {
		this.taxonomyId = taxonomyId;
	}

	public String getLocQlfr() {
		return locQlfr;
	}
	public void setLocQlfr(String locQlfr) {
		this.locQlfr = locQlfr;
	}

	public String getLocQlfrDesc() {
		return locQlfrDesc;
	}
	public void setLocQlfrDesc(String locQlfrDesc) {
		this.locQlfrDesc = locQlfrDesc;
	}

	public String getLocId() {
		return locId;
	}
	public void setLocId(String locId) {
		this.locId = locId;
	}

	// PER
	public List<RuleContact> getContacts() {
		return contacts;
	}
	public void setContacts(List<RuleContact> contacts) {
		this.contacts = contacts;
	}
	public void addContact(RuleContact contact) {
		contacts.add(contact);
	}

	public List<RuleDiagnosisCode> getDiagnosisCodes() {
		return diagnosisCodes;
	}
	public void setDiagnosisCodes(List<RuleDiagnosisCode> diagnosisCodes) {
		this.diagnosisCodes = diagnosisCodes;
	}
	public void addDiagnosisCode(RuleDiagnosisCode diagnosisCode) {
		diagnosisCodes.add(diagnosisCode);
	}
}
