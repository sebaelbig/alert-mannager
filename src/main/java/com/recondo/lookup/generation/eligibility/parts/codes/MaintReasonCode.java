package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.MaintReasonCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = MaintReasonCodeDeserializer.class)
public enum MaintReasonCode implements CodeEnum {
	// @formatter:off
	ChangeInIndentifyingDataElements("25", "Change in Indentifying Data Elements");
	// @formatter:on

	private static final Map<String, MaintReasonCode> lookup = new HashMap<String, MaintReasonCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 1203;

	static {
		for (MaintReasonCode maintReasonCode : EnumSet.allOf(MaintReasonCode.class))
			lookup.put(maintReasonCode.getCode(), maintReasonCode);
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

	private MaintReasonCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static MaintReasonCode get(String code) {
		return lookup.get(code);
	}
}
