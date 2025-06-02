package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.LoopIdCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = LoopIdCodeDeserializer.class)
public enum LoopIdCode implements CodeEnum {
	// @formatter:off
	LoopIdCode("2120", "Loop Id Code");
	// @formatter:on

	private static final Map<String, LoopIdCode> lookup = new HashMap<String, LoopIdCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 447;

	static {
		for (LoopIdCode loopIdCode : EnumSet.allOf(LoopIdCode.class))
			lookup.put(loopIdCode.getCode(), loopIdCode);
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

	private LoopIdCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static LoopIdCode get(String code) {
		return lookup.get(code);
	}
}
