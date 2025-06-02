package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.SvcUnitCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = SvcUnitCodeDeserializer.class)
public enum SvcUnitCode implements CodeEnum {
	// @formatter:off
	Visit("VS", "Visit"),
	Years("YR", "Years"),
	Week("WK", "Week"),
	Months("MO", "Months"),
	Days("DA", "Days");
	// @formatter:on

	private static final Map<String, SvcUnitCode> lookup = new HashMap<String, SvcUnitCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 355;

	static {
		for (SvcUnitCode svcUnitCode : EnumSet.allOf(SvcUnitCode.class))
			lookup.put(svcUnitCode.getCode(), svcUnitCode);
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

	private SvcUnitCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static SvcUnitCode get(String code) {
		return lookup.get(code);
	}
}
