package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.PatternTimeCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = PatternTimeCodeDeserializer.class)
public enum PatternTimeCode implements CodeEnum {
	// @formatter:off
	AM("D", "A.M."),
	FirstShiftNormalWorkingHours("A", "First Shift (Normal Working Hours)"),
	AsDirected("F", "As Directed"),
	NoneAlsoUsedToCancelOrOverrideAPrevious("Y", "None (Also Used to Cancel or Override a Previous"),
	ThirdShift("C", "Third Shift"),
	SecondShift("B", "Second Shift"),
	AnyShift("G", "Any Shift"),
	PM("E", "P.M.");
	// @formatter:on

	private static final Map<String, PatternTimeCode> lookup = new HashMap<String, PatternTimeCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 679;

	static {
		for (PatternTimeCode patternTimeCode : EnumSet.allOf(PatternTimeCode.class))
			lookup.put(patternTimeCode.getCode(), patternTimeCode);
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

	private PatternTimeCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static PatternTimeCode get(String code) {
		return lookup.get(code);
	}
}
