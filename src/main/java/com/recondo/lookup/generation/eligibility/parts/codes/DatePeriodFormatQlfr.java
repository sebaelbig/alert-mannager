package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.DatePeriodFormatQlfrDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = DatePeriodFormatQlfrDeserializer.class)
public enum DatePeriodFormatQlfr implements CodeEnum {
	// @formatter:off
	RangeOfDatesExpressedInFormatCCYYMMDDCCYYMMDD("RD8", "Range of Dates Expressed in Format CCYYMMDDCCYYMMDD"),
	DateExpressedInFormatCCYYMMDD("D8", "Date Expressed in Format CCYYMMDD");
	// @formatter:on

	private static final Map<String, DatePeriodFormatQlfr> lookup = new HashMap<String, DatePeriodFormatQlfr>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 1250;

	static {
		for (DatePeriodFormatQlfr datePeriodFormatQlfr : EnumSet.allOf(DatePeriodFormatQlfr.class))
			lookup.put(datePeriodFormatQlfr.getCode(), datePeriodFormatQlfr);
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

	private DatePeriodFormatQlfr(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static DatePeriodFormatQlfr get(String code) {
		return lookup.get(code);
	}
}
