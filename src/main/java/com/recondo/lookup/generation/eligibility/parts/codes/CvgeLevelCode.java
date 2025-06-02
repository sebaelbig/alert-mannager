package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.CvgeLevelCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = CvgeLevelCodeDeserializer.class)
public enum CvgeLevelCode implements CodeEnum {
	// @formatter:off
	ChildrenOnly("CHD", "Children Only"),
	DependentsOnly("DEP", "Dependents Only"),
	EmployeeAndChildren("ECH", "Employee and Children"),
	EmployeeOnly("EMP", "Employee Only"),
	EmployeeAndSpouse("ESP", "Employee and Spouse"),
	Family("FAM", "Family"),
	Individual("IND", "Individual"),
	SpouseAndChildren("SPC", "Spouse and Children"),
	SpouseOnly("SPO", "Spouse Only");
	// @formatter:on

	private static final Map<String, CvgeLevelCode> lookup = new HashMap<String, CvgeLevelCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 1207;

	static {
		for (CvgeLevelCode cvgeLevelCode : EnumSet.allOf(CvgeLevelCode.class))
			lookup.put(cvgeLevelCode.getCode(), cvgeLevelCode);
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

	private CvgeLevelCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static CvgeLevelCode get(String code) {
		return lookup.get(code);
	}
}
