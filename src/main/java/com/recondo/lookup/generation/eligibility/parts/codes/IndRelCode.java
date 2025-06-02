package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.IndRelCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = IndRelCodeDeserializer.class)
public enum IndRelCode implements CodeEnum {
	// @formatter:off
	Spouse("01", "Spouse"),
	Self("18", "Self"),
	Child("19", "Child"),
	Employee("20", "Employee"),
	Unknown("21", "Unknown"),
	OtherAdult("34", "Other Adult"),
	OrganDonor("39", "Organ Donor"),
	CadaverDonor("40", "Cadaver Donor"),
	LifePartner("53", "Life Partner"),
	OtherRelationship("G8", "Other Relationship");
	// @formatter:on

	private static final Map<String, IndRelCode> lookup = new HashMap<String, IndRelCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 1069;

	static {
		for (IndRelCode indRelCode : EnumSet.allOf(IndRelCode.class))
			lookup.put(indRelCode.getCode(), indRelCode);
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

	private IndRelCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static IndRelCode get(String code) {
		return lookup.get(code);
	}
}
