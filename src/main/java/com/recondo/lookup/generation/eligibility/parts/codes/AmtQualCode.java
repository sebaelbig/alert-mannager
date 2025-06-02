package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.AmtQualCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = AmtQualCodeDeserializer.class)
public enum AmtQualCode implements CodeEnum {
	// @formatter:off
	SpendDown("R", "Spend Down"),
	BilledAmount("PB", "Billed Amount");
	// @formatter:on

	private static final Map<String, AmtQualCode> lookup = new HashMap<String, AmtQualCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 522;

	static {
		for (AmtQualCode amtQualCode : EnumSet.allOf(AmtQualCode.class))
			lookup.put(amtQualCode.getCode(), amtQualCode);
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

	private AmtQualCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static AmtQualCode get(String code) {
		return lookup.get(code);
	}
}
