package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.ProvCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = ProvCodeDeserializer.class)
public enum ProvCode implements CodeEnum {
	// @formatter:off
	Admitting("AD", "Admitting"),
	Attending("AT", "Attending"),
	Billing("BI", "Billing"),
	Consulting("CO", "Consulting"),
	Covering("CV", "Covering"),
	Hospital("H", "Hospital"),
	HomeHealthCare("HH", "Home Health Care"),
	Laboratory("LA", "Laboratory"),
	OtherPhysician("OT", "Other Physician"),
	Pharmacist("P1", "Pharmacist"),
	Pharmacy("P2", "Pharmacy"),
	PrimaryCarePhysician("PC", "Primary Care Physician"),
	Performing("PE", "Performing"),
	RuralHealthClinic("R", "Rural Health Clinic"),
	Referring("RF", "Referring"),
	Submitting("SB", "Submitting"),
	SkilledNursingFacility("SK", "Skilled Nursing Facility"),
	Supervising("SU", "Supervising");
	// @formatter:on

	private static final Map<String, ProvCode> lookup = new HashMap<String, ProvCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 1221;

	static {
		for (ProvCode provCode : EnumSet.allOf(ProvCode.class))
			lookup.put(provCode.getCode(), provCode);
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

	private ProvCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static ProvCode get(String code) {
		return lookup.get(code);
	}
}
