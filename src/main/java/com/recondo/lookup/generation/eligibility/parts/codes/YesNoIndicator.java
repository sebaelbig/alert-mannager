package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.YesNoIndicatorDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = YesNoIndicatorDeserializer.class)
public enum YesNoIndicator implements CodeEnum {
	// @formatter:off
	Unknown("U", "Unknown"),
	Yes("Y", "Yes"),
	No("N", "No"),
	NotApplicable("W", "Not Applicable");
	// @formatter:on

	private static final Map<String, YesNoIndicator> lookup = new HashMap<String, YesNoIndicator>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 1073;

	static {
		for (YesNoIndicator yesNoIndicator : EnumSet.allOf(YesNoIndicator.class))
			lookup.put(yesNoIndicator.getCode(), yesNoIndicator);
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

	private YesNoIndicator(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static YesNoIndicator get(String code) {
		return lookup.get(code);
	}
}
