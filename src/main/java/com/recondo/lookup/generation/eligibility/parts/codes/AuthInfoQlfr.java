package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.AuthInfoQlfrDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = AuthInfoQlfrDeserializer.class)
public enum AuthInfoQlfr implements CodeEnum {
	// @formatter:off
	NoAuthPresent("00", "No Auth Present"),
	AdditionalData("03", "Additional Data");
	// @formatter:on

	private static final Map<String, AuthInfoQlfr> lookup = new HashMap<String, AuthInfoQlfr>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 1;

	static {
		for (AuthInfoQlfr authInfoQlfr : EnumSet.allOf(AuthInfoQlfr.class))
			lookup.put(authInfoQlfr.getCode(), authInfoQlfr);
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

	private AuthInfoQlfr(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static AuthInfoQlfr get(String code) {
		return lookup.get(code);
	}
}
