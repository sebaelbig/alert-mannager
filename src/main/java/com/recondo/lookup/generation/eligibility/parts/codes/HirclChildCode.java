package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.HirclChildCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = HirclChildCodeDeserializer.class)
public enum HirclChildCode implements CodeEnum {
	// @formatter:off
	NoSubordinateHLSegmentInThisHierarchical("0", "No Subordinate HL Segment in This Hierarchical"),
	AdditionalSubordinateHLDataSegmentInThis("1", "Additional Subordinate HL Data Segment in This");
	// @formatter:on

	private static final Map<String, HirclChildCode> lookup = new HashMap<String, HirclChildCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 736;

	static {
		for (HirclChildCode hirclChildCode : EnumSet.allOf(HirclChildCode.class))
			lookup.put(hirclChildCode.getCode(), hirclChildCode);
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

	private HirclChildCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static HirclChildCode get(String code) {
		return lookup.get(code);
	}
}
