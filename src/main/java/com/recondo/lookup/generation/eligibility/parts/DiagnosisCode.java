package com.recondo.lookup.generation.eligibility.parts;

import com.recondo.lookup.generation.eligibility.parts.codes.CodeListQlfrCode;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Represents a component of the HI segment of a X12 270/271 EDI
 * 
 * @author Robert.Larivee
 */
public class DiagnosisCode implements Serializable {
	private static final long serialVersionUID = 1L;

	private CodeListQlfrCode diagnosisCodeQlfr;
	private String diagnosisCodeQlfrDesc;
	@Size(min = 1, max = 30)
	private String diagnosisCode;


	// Must have a default constructor for Jackson to use when parsing JSON
	public DiagnosisCode() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


	public CodeListQlfrCode getDiagnosisCodeQlfr() {
		return diagnosisCodeQlfr;
	}
	public void setDiagnosisCodeQlfr(CodeListQlfrCode diagnosisCodeQlfr) {
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
