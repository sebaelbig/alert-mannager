package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.InterchangeCtrlVerNumDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = InterchangeCtrlVerNumDeserializer.class)
public enum InterchangeCtrlVerNum implements CodeEnum {
	// @formatter:off
	VersionX124010("00401", "Version X12 4010"),
	VersionX125010("00501", "Version X12 5010");
	// @formatter:on

	private static final Map<String, InterchangeCtrlVerNum> lookup = new HashMap<String, InterchangeCtrlVerNum>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 11;

	static {
		for (InterchangeCtrlVerNum interchangeCtrlVerNum : EnumSet.allOf(InterchangeCtrlVerNum.class))
			lookup.put(interchangeCtrlVerNum.getCode(), interchangeCtrlVerNum);
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

	private InterchangeCtrlVerNum(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static InterchangeCtrlVerNum get(String code) {
		return lookup.get(code);
	}
}
