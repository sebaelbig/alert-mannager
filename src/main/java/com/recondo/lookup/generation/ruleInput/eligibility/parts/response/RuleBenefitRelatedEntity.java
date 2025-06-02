package com.recondo.lookup.generation.ruleInput.eligibility.parts.response;

import com.recondo.lookup.generation.ruleInput.eligibility.parts.RuleContact;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the 2120C/D loops segments of a X12 270/271 EDI
 */
public class RuleBenefitRelatedEntity {
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

	private String relationshipCode;
	private String relationshipCodeDesc;

	// N3/N4
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zipcode;
	private String countryCode;
	private String countrySubdivisionCode;

	private String locQlfr;
	private String locQlfrDesc;
	private String locId;

	// PER
	private List<RuleContact> contacts = new ArrayList<>();

	// PRV
	private String provCode;
	private String provCodeDesc;

	private String refIdQlfr;
	private String refIdQlfrDesc;

	private String taxonomyId;


	public RuleBenefitRelatedEntity() {
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

	public String getRelationshipCode() {
		return relationshipCode;
	}
	public void setRelationshipCode(String relationshipCode) {
		this.relationshipCode = relationshipCode;
	}

	public String getRelationshipCodeDesc() {
		return relationshipCodeDesc;
	}
	public void setRelationshipCodeDesc(String relationshipCodeDesc) {
		this.relationshipCodeDesc = relationshipCodeDesc;
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
}
