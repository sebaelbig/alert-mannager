package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.ImplConRefDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = ImplConRefDeserializer.class)
public enum ImplConRef implements CodeEnum {
	// @formatter:off
	ImplementationVersion5010("005010X279", "Implementation Version 5010");
	// @formatter:on

	private static final Map<String, ImplConRef> lookup = new HashMap<String, ImplConRef>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 1705;

	static {
		for (ImplConRef implConRef : EnumSet.allOf(ImplConRef.class))
			lookup.put(implConRef.getCode(), implConRef);
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

	private ImplConRef(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static ImplConRef get(String code) {
		return lookup.get(code);
	}
}
