package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.MaintTypeCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = MaintTypeCodeDeserializer.class)
public enum MaintTypeCode implements CodeEnum {
	// @formatter:off
	Change("001", "Change");
	// @formatter:on

	private static final Map<String, MaintTypeCode> lookup = new HashMap<String, MaintTypeCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 875;

	static {
		for (MaintTypeCode maintTypeCode : EnumSet.allOf(MaintTypeCode.class))
			lookup.put(maintTypeCode.getCode(), maintTypeCode);
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

	private MaintTypeCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static MaintTypeCode get(String code) {
		return lookup.get(code);
	}
}
