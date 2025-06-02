package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.RespAgencyCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = RespAgencyCodeDeserializer.class)
public enum RespAgencyCode implements CodeEnum {
	// @formatter:off
	AccreditedStandardsCommitteeX12("X", "Accredited Standards Committee X12");
	// @formatter:on

	private static final Map<String, RespAgencyCode> lookup = new HashMap<String, RespAgencyCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 455;

	static {
		for (RespAgencyCode respAgencyCode : EnumSet.allOf(RespAgencyCode.class))
			lookup.put(respAgencyCode.getCode(), respAgencyCode);
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

	private RespAgencyCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static RespAgencyCode get(String code) {
		return lookup.get(code);
	}
}
