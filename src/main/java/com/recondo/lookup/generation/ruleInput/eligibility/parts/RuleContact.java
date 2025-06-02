package com.recondo.lookup.generation.ruleInput.eligibility.parts;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Represents the PER segment of a X12 270/271 EDI
 */
public class RuleContact {
	private String contactFunctionCode;
	private String contactFunctionCodeDesc;

	private String name;

	private String contactNumQlfr1;
	private String contactNumQlfrDesc1;
	private String contactNum1;

	private String contactNumQlfr2;
	private String contactNumQlfrDesc2;
	private String contactNum2;

	private String contactNumQlfr3;
	private String contactNumQlfrDesc3;
	private String contactNum3;


	public RuleContact() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


	public String getContactFunctionCode() {
		return contactFunctionCode;
	}
	public void setContactFunctionCode(String contactFunctionCode) {
		this.contactFunctionCode = contactFunctionCode;
	}

	public String getContactFunctionCodeDesc() {
		return contactFunctionCodeDesc;
	}
	public void setContactFunctionCodeDesc(String contactFunctionCodeDesc) {
		this.contactFunctionCodeDesc = contactFunctionCodeDesc;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumQlfr1() {
		return contactNumQlfr1;
	}
	public void setContactNumQlfr1(String contactNumQlfr1) {
		this.contactNumQlfr1 = contactNumQlfr1;
	}

	public String getContactNumQlfrDesc1() {
		return contactNumQlfrDesc1;
	}
	public void setContactNumQlfrDesc1(String contactNumQlfrDesc1) {
		this.contactNumQlfrDesc1 = contactNumQlfrDesc1;
	}

	public String getContactNum1() {
		return contactNum1;
	}
	public void setContactNum1(String contactNum1) {
		this.contactNum1 = contactNum1;
	}

	public String getContactNumQlfr2() {
		return contactNumQlfr2;
	}
	public void setContactNumQlfr2(String contactNumQlfr2) {
		this.contactNumQlfr2 = contactNumQlfr2;
	}

	public String getContactNumQlfrDesc2() {
		return contactNumQlfrDesc2;
	}
	public void setContactNumQlfrDesc2(String contactNumQlfrDesc2) {
		this.contactNumQlfrDesc2 = contactNumQlfrDesc2;
	}

	public String getContactNum2() {
		return contactNum2;
	}
	public void setContactNum2(String contactNum2) {
		this.contactNum2 = contactNum2;
	}

	public String getContactNumQlfr3() {
		return contactNumQlfr3;
	}
	public void setContactNumQlfr3(String contactNumQlfr3) {
		this.contactNumQlfr3 = contactNumQlfr3;
	}

	public String getContactNumQlfrDesc3() {
		return contactNumQlfrDesc3;
	}
	public void setContactNumQlfrDesc3(String contactNumQlfrDesc3) {
		this.contactNumQlfrDesc3 = contactNumQlfrDesc3;
	}

	public String getContactNum3() {
		return contactNum3;
	}
	public void setContactNum3(String contactNum3) {
		this.contactNum3 = contactNum3;
	}
}
