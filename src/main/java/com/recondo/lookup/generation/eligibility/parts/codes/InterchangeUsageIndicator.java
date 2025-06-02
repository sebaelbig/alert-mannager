package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.InterchangeUsageIndicatorDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = InterchangeUsageIndicatorDeserializer.class)
public enum InterchangeUsageIndicator implements CodeEnum {
	// @formatter:off
	TestData("T", "Test Data"),
	ProductionData("P", "Production Data");
	// @formatter:on

	private static final Map<String, InterchangeUsageIndicator> lookup = new HashMap<String, InterchangeUsageIndicator>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 14;

	static {
		for (InterchangeUsageIndicator interchangeUsageIndicator : EnumSet.allOf(InterchangeUsageIndicator.class))
			lookup.put(interchangeUsageIndicator.getCode(), interchangeUsageIndicator);
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

	private InterchangeUsageIndicator(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static InterchangeUsageIndicator get(String code) {
		return lookup.get(code);
	}
}
