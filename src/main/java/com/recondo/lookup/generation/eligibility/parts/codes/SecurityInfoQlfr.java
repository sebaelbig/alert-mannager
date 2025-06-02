package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.SecurityInfoQlfrDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = SecurityInfoQlfrDeserializer.class)
public enum SecurityInfoQlfr implements CodeEnum {
	// @formatter:off
	NoSecurityInfoPresent("00", "No Security Info Present"),
	Password("01", "Password");
	// @formatter:on

	private static final Map<String, SecurityInfoQlfr> lookup = new HashMap<String, SecurityInfoQlfr>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 3;

	static {
		for (SecurityInfoQlfr securityInfoQlfr : EnumSet.allOf(SecurityInfoQlfr.class))
			lookup.put(securityInfoQlfr.getCode(), securityInfoQlfr);
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

	private SecurityInfoQlfr(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static SecurityInfoQlfr get(String code) {
		return lookup.get(code);
	}
}
