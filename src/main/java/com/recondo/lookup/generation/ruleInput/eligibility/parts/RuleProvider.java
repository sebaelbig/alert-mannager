package com.recondo.lookup.generation.ruleInput.eligibility.parts;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the 2100B loop of a X12 270/271 EDI
 */
public class RuleProvider {
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

	// REF
	private List<RuleRef> refs = new ArrayList<>();

	// PRV
	private String provCode;
	private String provCodeDesc;

	private String refIdQlfr;
	private String refIdQlfrDesc;

	private String taxonomyId;


	public RuleProvider() {
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
