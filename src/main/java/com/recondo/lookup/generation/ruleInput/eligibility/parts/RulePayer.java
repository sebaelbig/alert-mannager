package com.recondo.lookup.generation.ruleInput.eligibility.parts;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the 2100A loop of a X12 270/271 EDI
 */
public class RulePayer {
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

	private List<com.recondo.lookup.generation.ruleInput.eligibility.parts.RuleContact> contacts = new ArrayList<>();

	// REF
	private List<com.recondo.lookup.generation.ruleInput.eligibility.parts.RuleRef> refs = new ArrayList<>();


	public RulePayer() {
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

	public List<RuleContact> getContacts() {
		return contacts;
	}
	public void setContacts(List<com.recondo.lookup.generation.ruleInput.eligibility.parts.RuleContact> contacts) {
		this.contacts = contacts;
	}
	public void addContact(RuleContact contact) {
		contacts.add(contact);
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
}
