package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.LocationQlfrDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = LocationQlfrDeserializer.class)
public enum LocationQlfr implements CodeEnum {
	// @formatter:off
	FederalInformationProcessingStandardsFIPS55("FI", "Federal Information Processing Standards (FIPS) 55"),
	Region("RJ", "Region"),
	CountyParish("CY", "County/Parish");
	// @formatter:on

	private static final Map<String, LocationQlfr> lookup = new HashMap<String, LocationQlfr>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 309;

	static {
		for (LocationQlfr locationQlfr : EnumSet.allOf(LocationQlfr.class))
			lookup.put(locationQlfr.getCode(), locationQlfr);
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

	private LocationQlfr(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static LocationQlfr get(String code) {
		return lookup.get(code);
	}
}
