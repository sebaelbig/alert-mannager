package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.CodeCategoryDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = CodeCategoryDeserializer.class)
public enum CodeCategory implements CodeEnum {
	// @formatter:off
	NatureOfInjury("44", "Nature of Injury");
	// @formatter:on

	private static final Map<String, CodeCategory> lookup = new HashMap<String, CodeCategory>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 1136;

	static {
		for (CodeCategory codeCategory : EnumSet.allOf(CodeCategory.class))
			lookup.put(codeCategory.getCode(), codeCategory);
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

	private CodeCategory(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static CodeCategory get(String code) {
		return lookup.get(code);
	}
}
