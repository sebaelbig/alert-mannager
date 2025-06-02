package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.TransSetIdCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = TransSetIdCodeDeserializer.class)
public enum TransSetIdCode implements CodeEnum {
	// @formatter:off
	EligibilityCoverageOrBenefitInquiry("270", "Eligibility Coverage or Benefit Inquiry"),
	EligibilityCoverageOrBenefitInformation("271", "Eligibility Coverage or Benefit Information");
	// @formatter:on

	private static final Map<String, TransSetIdCode> lookup = new HashMap<String, TransSetIdCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 143;

	static {
		for (TransSetIdCode transSetIdCode : EnumSet.allOf(TransSetIdCode.class))
			lookup.put(transSetIdCode.getCode(), transSetIdCode);
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

	private TransSetIdCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static TransSetIdCode get(String code) {
		return lookup.get(code);
	}
}
