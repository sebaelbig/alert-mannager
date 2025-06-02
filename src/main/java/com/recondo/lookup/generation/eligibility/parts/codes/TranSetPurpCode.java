package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.TranSetPurpCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = TranSetPurpCodeDeserializer.class)
public enum TranSetPurpCode implements CodeEnum {
	// @formatter:off
	Response("11", "Response"),
	Cancellation("01", "Cancellation"),
	Request("13", "Request"),
	Confirmation("06", "Confirmation");
	// @formatter:on

	private static final Map<String, TranSetPurpCode> lookup = new HashMap<String, TranSetPurpCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 353;

	static {
		for (TranSetPurpCode tranSetPurpCode : EnumSet.allOf(TranSetPurpCode.class))
			lookup.put(tranSetPurpCode.getCode(), tranSetPurpCode);
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

	private TranSetPurpCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static TranSetPurpCode get(String code) {
		return lookup.get(code);
	}
}
