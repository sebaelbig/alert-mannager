package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.StudentStatusCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = StudentStatusCodeDeserializer.class)
public enum StudentStatusCode implements CodeEnum {
	// @formatter:off
	Fulltime("F", "Full-time"),
	NotAStudent("N", "Not a Student"),
	Parttime("P", "Part-time");
	// @formatter:on

	private static final Map<String, StudentStatusCode> lookup = new HashMap<String, StudentStatusCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 1220;

	static {
		for (StudentStatusCode studentStatusCode : EnumSet.allOf(StudentStatusCode.class))
			lookup.put(studentStatusCode.getCode(), studentStatusCode);
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

	private StudentStatusCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static StudentStatusCode get(String code) {
		return lookup.get(code);
	}
}
