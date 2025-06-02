package com.recondo.lookup.generation.eligibility.parts;

import com.recondo.lookup.generation.eligibility.constraints.ContactConsistency;
import com.recondo.lookup.generation.eligibility.parts.codes.ContactFunctionCode;
import com.recondo.lookup.generation.eligibility.parts.codes.ContactNumQlfr;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Represents the PER segment of a X12 270/271 EDI
 * 
 * @author Robert.Larivee
 */
@ContactConsistency
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private ContactFunctionCode contactFunctionCode;
	private String contactFunctionCodeDesc;

	@Size(min = 1, max = 60)
	private String name;

	private ContactNumQlfr contactNumQlfr1;
	private String contactNumQlfrDesc1;
	@Size(min = 1, max = 256)
	private String contactNum1;

	private ContactNumQlfr contactNumQlfr2;
	private String contactNumQlfrDesc2;
	@Size(min = 1, max = 256)
	private String contactNum2;

	private ContactNumQlfr contactNumQlfr3;
	private String contactNumQlfrDesc3;
	@Size(min = 1, max = 256)
	private String contactNum3;


	// Must have a default constructor for Jackson to use when parsing JSON
	public Contact() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


	public ContactFunctionCode getContactFunctionCode() {
		return contactFunctionCode;
	}
	public void setContactFunctionCode(ContactFunctionCode contactFunctionCode) {
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

	public ContactNumQlfr getContactNumQlfr1() {
		return contactNumQlfr1;
	}
	public void setContactNumQlfr1(ContactNumQlfr contactNumQlfr1) {
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

	public ContactNumQlfr getContactNumQlfr2() {
		return contactNumQlfr2;
	}
	public void setContactNumQlfr2(ContactNumQlfr contactNumQlfr2) {
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

	public ContactNumQlfr getContactNumQlfr3() {
		return contactNumQlfr3;
	}
	public void setContactNumQlfr3(ContactNumQlfr contactNumQlfr3) {
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
