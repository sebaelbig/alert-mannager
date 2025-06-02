package com.recondo.lookup.generation.eligibility.parts;

import com.recondo.lookup.generation.eligibility.parts.codes.DatePeriodQlfr;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * Represents the DTP segment of a X12 270/271 EDI
 * 
 * @author Robert.Larivee
 */
public class EligibilityDate implements Serializable {
	private static final long serialVersionUID = 1L;

	private DatePeriodQlfr datePeriodQlfr;
	private String datePeriodQlfrDesc;

	private Date startDate;
	private Date endDate;


	// Must have a default constructor for Jackson to use when parsing JSON
	public EligibilityDate() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


	public DatePeriodQlfr getDatePeriodQlfr() {
		return datePeriodQlfr;
	}
	public void setDatePeriodQlfr(DatePeriodQlfr datePeriodQlfr) {
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
