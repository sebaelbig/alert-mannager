package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.PatternCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = PatternCodeDeserializer.class)
public enum PatternCode implements CodeEnum {
	// @formatter:off
	FirstWeekOfTheMonth("1", "First Week of the Month"),
	SecondWeekOfTheMonth("2", "Second Week of the Month"),
	ThirdWeekOfTheMonth("3", "Third Week of the Month"),
	FourthWeekOfTheMonth("4", "Fourth Week of the Month"),
	FifthWeekOfTheMonth("5", "Fifth Week of the Month"),
	FirstAndThirdWeeksOfTheMonth("6", "First & Third Weeks of the Month"),
	SecondAndFourthWeeksOfTheMonth("7", "Second & Fourth Weeks of the Month"),
	FirstWorkingDayOfPeriod("8", "First Working Day of Period"),
	LastWorkingDayOfPeriod("9", "Last Working Day of Period"),
	MondayThroughFriday("A", "Monday through Friday"),
	MondayThroughSaturday("B", "Monday through Saturday"),
	MondayThroughSunday("C", "Monday through Sunday"),
	Monday("D", "Monday"),
	Tuesday("E", "Tuesday"),
	Wednesday("F", "Wednesday"),
	Thursday("G", "Thursday"),
	Friday("H", "Friday"),
	Saturday("J", "Saturday"),
	Sunday("K", "Sunday"),
	MondayThroughThursday("L", "Monday through Thursday"),
	Immediately("M", "Immediately"),
	AsDirected("N", "As Directed"),
	DailyMonThroughFri("O", "Daily Mon. through Fri."),
	SplitHalfMonAndHalfThurs("P", "Split Half Mon. & Half Thurs."),
	HalfTuesAndHalfThurs("Q", "Half Tues. & Half Thurs."),
	HalfWedAndHalfFri("R", "Half Wed. & Half Fri."),
	OnceAnytimeMonThroughFri("S", "Once Anytime Mon. through Fri."),
	TuesdayThroughFriday("SG", "Tuesday through Friday"),
	MondayTuesdayAndThursday("SL", "Monday~~~ Tuesday and Thursday"),
	MondayTuesdayAndFriday("SP", "Monday~~~ Tuesday and Friday"),
	WednesdayAndThursday("SX", "Wednesday and Thursday"),
	MondayWednesdayAndThursday("SY", "Monday~~~ Wednesday and Thursday"),
	TuesdayThursdayAndFriday("SZ", "Tuesday~~~ Thursday and Friday"),
	HalfTueAndHalfFri("T", "Half Tue. & Half Fri."),
	HalfMonAndHalfWed("U", "Half Mon. & Half Wed."),
	ThirdMonThirdWedThirdFri("V", "Third Mon.~~~ Third Wed.~~~ Third Fri."),
	WheneverNecessary("W", "Whenever Necessary"),
	HalfByWedBalByFri("X", "Half By Wed.~~~ Bal. By Fri."),
	NoneAlsoUsedToCancelOrOverrideAPrevious("Y", "None (Also Used to Cancel or Override a Previous)");
	// @formatter:on

	private static final Map<String, PatternCode> lookup = new HashMap<String, PatternCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 678;

	static {
		for (PatternCode patternCode : EnumSet.allOf(PatternCode.class))
			lookup.put(patternCode.getCode(), patternCode);
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

	private PatternCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static PatternCode get(String code) {
		return lookup.get(code);
	}
}
