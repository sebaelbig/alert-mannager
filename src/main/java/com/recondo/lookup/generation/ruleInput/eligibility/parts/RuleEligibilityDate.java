package com.recondo.lookup.generation.ruleInput.eligibility.parts;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Date;

/**
 * Represents the DTP segment of a X12 270/271 EDI
 */
public class RuleEligibilityDate {
	private String datePeriodQlfr;
	private String datePeriodQlfrDesc;

	private Date startDate;
	private Date endDate;


	public RuleEligibilityDate() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


	public String getDatePeriodQlfr() {
		return datePeriodQlfr;
	}
	public void setDatePeriodQlfr(String datePeriodQlfr) {
		this.datePeriodQlfr = datePeriodQlfr;
	}

	public String getDatePeriodQlfrDesc() {
		return datePeriodQlfrDesc;
	}
	public void setDatePeriodQlfrDesc(String datePeriodQlfrDesc) {
		this.datePeriodQlfrDesc = datePeriodQlfrDesc;
	}

	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
