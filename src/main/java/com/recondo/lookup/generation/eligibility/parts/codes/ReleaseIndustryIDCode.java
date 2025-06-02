package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.ReleaseIndustryIDCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = ReleaseIndustryIDCodeDeserializer.class)
public enum ReleaseIndustryIDCode implements CodeEnum {
	// @formatter:off
	X125010("005010X279", "X12 5010"),
	X125010A1("005010X279A1", "X12 5010A1");
	// @formatter:on

	private static final Map<String, ReleaseIndustryIDCode> lookup = new HashMap<String, ReleaseIndustryIDCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 480;

	static {
		for (ReleaseIndustryIDCode releaseIndustryIDCode : EnumSet.allOf(ReleaseIndustryIDCode.class))
			lookup.put(releaseIndustryIDCode.getCode(), releaseIndustryIDCode);
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

	private ReleaseIndustryIDCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static ReleaseIndustryIDCode get(String code) {
		return lookup.get(code);
	}
}
