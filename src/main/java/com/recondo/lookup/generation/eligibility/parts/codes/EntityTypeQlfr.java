package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.EntityTypeQlfrDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = EntityTypeQlfrDeserializer.class)
public enum EntityTypeQlfr implements CodeEnum {
	// @formatter:off
	NonPersonEntity("2", "Non-Person Entity"),
	Person("1", "Person");
	// @formatter:on

	private static final Map<String, EntityTypeQlfr> lookup = new HashMap<String, EntityTypeQlfr>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 1065;

	static {
		for (EntityTypeQlfr entityTypeQlfr : EnumSet.allOf(EntityTypeQlfr.class))
			lookup.put(entityTypeQlfr.getCode(), entityTypeQlfr);
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

	private EntityTypeQlfr(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static EntityTypeQlfr get(String code) {
		return lookup.get(code);
	}
}
