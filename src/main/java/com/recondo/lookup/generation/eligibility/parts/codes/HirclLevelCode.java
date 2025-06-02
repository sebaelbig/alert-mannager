package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.HirclLevelCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = HirclLevelCodeDeserializer.class)
public enum HirclLevelCode implements CodeEnum {
	// @formatter:off
	InformationReceiver("21", "Information Receiver"),
	Subscriber("22", "Subscriber"),
	InformationSource("20", "Information Source"),
	Dependent("23", "Dependent");
	// @formatter:on

	private static final Map<String, HirclLevelCode> lookup = new HashMap<String, HirclLevelCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 735;

	static {
		for (HirclLevelCode hirclLevelCode : EnumSet.allOf(HirclLevelCode.class))
			lookup.put(hirclLevelCode.getCode(), hirclLevelCode);
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

	private HirclLevelCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static HirclLevelCode get(String code) {
		return lookup.get(code);
	}
}
