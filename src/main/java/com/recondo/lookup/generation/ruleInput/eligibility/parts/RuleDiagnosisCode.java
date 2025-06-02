package com.recondo.lookup.generation.ruleInput.eligibility.parts;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Represents a component of the HI segment of a X12 270/271 EDI
 */
public class RuleDiagnosisCode {
	private String diagnosisCodeQlfr;
	private String diagnosisCodeQlfrDesc;
	private String diagnosisCode;


	public RuleDiagnosisCode() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


	public String getDiagnosisCodeQlfr() {
		return diagnosisCodeQlfr;
	}
	public void setDiagnosisCodeQlfr(String diagnosisCodeQlfr) {
		this.diagnosisCodeQlfr = diagnosisCodeQlfr;
	}

	public String getDiagnosisCodeQlfrDesc() {
		return diagnosisCodeQlfrDesc;
	}
	public void setDiagnosisCodeQlfrDesc(String diagnosisCodeQlfrDesc) {
		this.diagnosisCodeQlfrDesc = diagnosisCodeQlfrDesc;
	}

	public String getDiagnosisCode() {
		return diagnosisCode;
	}
	public void setDiagnosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}
}
