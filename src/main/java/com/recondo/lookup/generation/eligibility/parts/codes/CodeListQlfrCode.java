package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.CodeListQlfrCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = CodeListQlfrCodeDeserializer.class)
public enum CodeListQlfrCode implements CodeEnum {
	// @formatter:off
	InternationalClassificationOfDiseasesClinicalModificationICD10CMDiagnosis("ABF", "International Classification of Diseases Clinical Modification (ICD-10-CM) Diagnosis"),
	InternationalClassificationOfDiseasesClinicalModificationICD10CMPrincipalDiagnosis("ABK", "International Classification of Diseases Clinical Modification (ICD-10-CM) Principal Diagnosis"),
	InternationalClassificationOfDiseasesClinicalModificationICD9CMDiagnosis("BF", "International Classification of Diseases Clinical Modification (ICD-9-CM) Diagnosis"),
	InternationalClassificationOfDiseasesClinicalModificationICD9CMPrincipalDiagnosis("BK", "International Classification of Diseases Clinical Modification (ICD-9-CM) Principal Diagnosis"),
	NationalCouncilOnCompensationInsuranceNCCINatureOfInjuryCode("GR", "National Council on Compensation Insurance (NCCI) Nature of Injury Code"),
	NatureOfInjuryCode("NI", "Nature of Injury Code"),
	MutuallyDefined("ZZ", "Mutually Defined");
	// @formatter:on

	private static final Map<String, CodeListQlfrCode> lookup = new HashMap<String, CodeListQlfrCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 1270;

	static {
		for (CodeListQlfrCode codeListQlfrCode : EnumSet.allOf(CodeListQlfrCode.class))
			lookup.put(codeListQlfrCode.getCode(), codeListQlfrCode);
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

	private CodeListQlfrCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static CodeListQlfrCode get(String code) {
		return lookup.get(code);
	}
}
