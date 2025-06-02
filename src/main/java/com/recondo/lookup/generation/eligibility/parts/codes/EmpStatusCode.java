package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.EmpStatusCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = EmpStatusCodeDeserializer.class)
public enum EmpStatusCode implements CodeEnum {
	// @formatter:off
	ActiveReserve("AE", "Active Reserve"),
	ActiveMilitaryOverseas("AO", "Active Military - Overseas"),
	AcademyStudent("AS", "Academy Student"),
	PresidentialAppointee("AT", "Presidential Appointee"),
	ActiveMilitaryUSA("AU", "Active Military - USA"),
	Contractor("CC", "Contractor"),
	DishonorablyDischarged("DD", "Dishonorably Discharged"),
	HonorablyDischarged("HD", "Honorably Discharged"),
	InactiveReserves("IR", "Inactive Reserves"),
	LeaveOfAbsenceMilitary("LX", "Leave of Absence: Military"),
	PlanToEnlist("PE", "Plan to Enlist"),
	Recommissioned("RE", "Recommissioned"),
	RetiredMilitaryOverseas("RM", "Retired Military - Overseas"),
	RetiredWithoutRecall("RR", "Retired Without Recall"),
	RetiredMilitaryUSA("RU", "Retired Military - USA");
	// @formatter:on

	private static final Map<String, EmpStatusCode> lookup = new HashMap<String, EmpStatusCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 584;

	static {
		for (EmpStatusCode empStatusCode : EnumSet.allOf(EmpStatusCode.class))
			lookup.put(empStatusCode.getCode(), empStatusCode);
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

	private EmpStatusCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static EmpStatusCode get(String code) {
		return lookup.get(code);
	}
}
