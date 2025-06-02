package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.ContactNumQlfrDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = ContactNumQlfrDeserializer.class)
public enum ContactNumQlfr implements CodeEnum {
	// @formatter:off
	HomePhoneNumber("HP", "Home Phone Number"),
	Facsimile("FX", "Facsimile"),
	Telephone("TE", "Telephone"),
	WorkPhoneNumber("WP", "Work Phone Number"),
	ElectronicDataInterchangeAccessNumber("ED", "Electronic Data Interchange Access Number"),
	TelephoneExtension("EX", "Telephone Extension"),
	ElectronicMail("EM", "Electronic Mail"),
	UniformResourceLocator("UR", "Uniform Resource Locator");
	// @formatter:on

	private static final Map<String, ContactNumQlfr> lookup = new HashMap<String, ContactNumQlfr>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 365;

	static {
		for (ContactNumQlfr contactNumQlfr : EnumSet.allOf(ContactNumQlfr.class))
			lookup.put(contactNumQlfr.getCode(), contactNumQlfr);
	}

	/* (non-Javadoc)
	 * @see com.recondo.lookup.eligibility.parts.codes.CodeEnum#getDataElementNumber()
	 */
	@Override
	public int getDataElementNumber() {
		return dataElementNumber;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getDescription() {
		return description;
	}

	private ContactNumQlfr(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static ContactNumQlfr get(String code) {
		return lookup.get(code);
	}
}
