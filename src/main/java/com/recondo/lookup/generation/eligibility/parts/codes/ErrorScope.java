package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.ErrorScopeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = ErrorScopeDeserializer.class)
public enum ErrorScope implements CodeEnum {
	// @formatter:off
	Internal("1", "Internal"),
	Header("2", "Header"),
	Payer("3", "Payer"),
	Provider("4", "Provider"),
	Patient("5", "Patient");
	// @formatter:on

	private static final Map<String, ErrorScope> lookup = new HashMap<String, ErrorScope>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 99999;

	static {
		for (ErrorScope errorScope : EnumSet.allOf(ErrorScope.class))
			lookup.put(errorScope.getCode(), errorScope);
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

	private ErrorScope(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static ErrorScope get(String code) {
		return lookup.get(code);
	}
}
