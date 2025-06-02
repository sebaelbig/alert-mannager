package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.InfStatusCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = InfStatusCodeDeserializer.class)
public enum InfStatusCode implements CodeEnum {
	// @formatter:off
	Partial("A", "Partial"),
	Current("C", "Current"),
	Latest("L", "Latest"),
	Oldest("O", "Oldest"),
	Prior("P", "Prior"),
	SecondMostCurrent("S", "Second Most Current"),
	ThirdMostCurrent("T", "Third Most Current");
	// @formatter:on

	private static final Map<String, InfStatusCode> lookup = new HashMap<String, InfStatusCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 1201;

	static {
		for (InfStatusCode infStatusCode : EnumSet.allOf(InfStatusCode.class))
			lookup.put(infStatusCode.getCode(), infStatusCode);
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

	private InfStatusCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static InfStatusCode get(String code) {
		return lookup.get(code);
	}
}
