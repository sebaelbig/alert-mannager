package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.HirclStructCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = HirclStructCodeDeserializer.class)
public enum HirclStructCode implements CodeEnum {
	// @formatter:off
	InformationSourceInformationReceiverSubscriberDependent("0022", "Information Source~~~ Information Receiver~~~ Subscriber~~~ Dependent");
	// @formatter:on

	private static final Map<String, HirclStructCode> lookup = new HashMap<String, HirclStructCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 1005;

	static {
		for (HirclStructCode hirclStructCode : EnumSet.allOf(HirclStructCode.class))
			lookup.put(hirclStructCode.getCode(), hirclStructCode);
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

	private HirclStructCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static HirclStructCode get(String code) {
		return lookup.get(code);
	}
}
