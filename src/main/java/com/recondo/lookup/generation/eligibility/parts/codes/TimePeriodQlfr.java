package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.TimePeriodQlfrDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = TimePeriodQlfrDeserializer.class)
public enum TimePeriodQlfr implements CodeEnum {
	// @formatter:off
	Hours24("13", "Hours 24"),
	Years("21", "Years"),
	ServiceYear("22", "Service Year"),
	CalendarYear("23", "Calendar Year"),
	YearToDate("24", "Year to Date"),
	Contract("25", "Contract"),
	Episode("26", "Episode"),
	Visit("27", "Visit"),
	Outlier("28", "Outlier"),
	Remaining("29", "Remaining"),
	Exceeded("30", "Exceeded"),
	NotExceeded("31", "Not Exceeded"),
	Lifetime("32", "Lifetime"),
	LifetimeRemaining("33", "Lifetime Remaining"),
	Month("34", "Month"),
	Week("35", "Week"),
	Admisson("36", "Admisson"),
	Hour("6", "Hour"),
	Day("7", "Day");
	// @formatter:on

	private static final Map<String, TimePeriodQlfr> lookup = new HashMap<String, TimePeriodQlfr>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 615;

	static {
		for (TimePeriodQlfr timePeriodQlfr : EnumSet.allOf(TimePeriodQlfr.class))
			lookup.put(timePeriodQlfr.getCode(), timePeriodQlfr);
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

	private TimePeriodQlfr(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static TimePeriodQlfr get(String code) {
		return lookup.get(code);
	}
}
