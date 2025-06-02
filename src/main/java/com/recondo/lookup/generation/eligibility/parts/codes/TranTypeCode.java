package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.TranTypeCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = TranTypeCodeDeserializer.class)
public enum TranTypeCode implements CodeEnum {
	// @formatter:off
	SpendDown("RT", "Spend Down");
	// @formatter:on

	private static final Map<String, TranTypeCode> lookup = new HashMap<String, TranTypeCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 640;

	static {
		for (TranTypeCode tranTypeCode : EnumSet.allOf(TranTypeCode.class))
			lookup.put(tranTypeCode.getCode(), tranTypeCode);
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

	private TranTypeCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static TranTypeCode get(String code) {
		return lookup.get(code);
	}
}
