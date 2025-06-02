package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.ContactFunctionCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = ContactFunctionCodeDeserializer.class)
public enum ContactFunctionCode implements CodeEnum {
	// @formatter:off
	InformationContact("IC", "Information Contact");
	// @formatter:on

	private static final Map<String, ContactFunctionCode> lookup = new HashMap<String, ContactFunctionCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 366;

	static {
		for (ContactFunctionCode contactFunctionCode : EnumSet.allOf(ContactFunctionCode.class))
			lookup.put(contactFunctionCode.getCode(), contactFunctionCode);
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

	private ContactFunctionCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static ContactFunctionCode get(String code) {
		return lookup.get(code);
	}
}
