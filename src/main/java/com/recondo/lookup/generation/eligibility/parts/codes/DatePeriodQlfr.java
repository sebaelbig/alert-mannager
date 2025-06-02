package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.DatePeriodQlfrDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = DatePeriodQlfrDeserializer.class)
public enum DatePeriodQlfr implements CodeEnum {
	// @formatter:off
	Discharge("096", "Discharge"),
	Issue("102", "Issue"),
	EffectiveDateOfChange("152", "Effective Date of Change"),
	PeriodStart("193", "Period Start"),
	PeriodEnd("194", "Period End"),
	Completion("198", "Completion"),
	CoordinationOfBenefits("290", "Coordination of Benefits"),
	Plan("291", "Plan"),
	Benefit("292", "Benefit"),
	PrimaryCareProvider("295", "Primary Care Provider"),
	LatestVisitOrConsultation("304", "Latest Visit or Consultation"),
	Eligibility("307", "Eligibility"),
	Added("318", "Added"),
	ConsolidatedOmnibusBudgetReconciliationActBegin("340", "Consolidated Omnibus Budget Reconciliation Act Begin"),
	ConsolidatedOmnibusBudgetReconciliationActEnd("341", "Consolidated Omnibus Budget Reconciliation Act End"),
	PremiumPaidToDateBegin("342", "Premium Paid to Date Begin"),
	PremiumPaidToDateEnd("343", "Premium Paid to Date End"),
	PlanBegin("346", "Plan Begin"),
	PlanEnd("347", "Plan End"),
	BenefitBegin("348", "Benefit Begin"),
	BenefitEnd("349", "Benefit End"),
	EligibilityBegin("356", "Eligibility Begin"),
	EligibilityEnd("357", "Eligibility End"),
	Enrollment("382", "Enrollment"),
	Admission("435", "Admission"),
	DateOfDeath("442", "Date of Death"),
	Certification("458", "Certification"),
	Service("472", "Service"),
	PolicyEffective("539", "Policy Effective"),
	PolicyExpiration("540", "Policy Expiration"),
	DateOfLastUpdate("636", "Date of Last Update"),
	Status("771", "Status");
	// @formatter:on

	private static final Map<String, DatePeriodQlfr> lookup = new HashMap<String, DatePeriodQlfr>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 374;

	static {
		for (DatePeriodQlfr datePeriodQlfr : EnumSet.allOf(DatePeriodQlfr.class))
			lookup.put(datePeriodQlfr.getCode(), datePeriodQlfr);
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

	private DatePeriodQlfr(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static DatePeriodQlfr get(String code) {
		return lookup.get(code);
	}
}
