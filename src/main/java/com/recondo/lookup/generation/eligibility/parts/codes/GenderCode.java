package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.GenderCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = GenderCodeDeserializer.class)
public enum GenderCode implements CodeEnum {
	// @formatter:off
	Male("M", "Male"),
	Female("F", "Female"),
	Unknown("U", "Unknown");
	// @formatter:on

	private static final Map<String, GenderCode> lookup = new HashMap<String, GenderCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 1068;

	static {
		for (GenderCode genderCode : EnumSet.allOf(GenderCode.class))
			lookup.put(genderCode.getCode(), genderCode);
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

	private GenderCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static GenderCode get(String code) {
		return lookup.get(code);
	}
}
