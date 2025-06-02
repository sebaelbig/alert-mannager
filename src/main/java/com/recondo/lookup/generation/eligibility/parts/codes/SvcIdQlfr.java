package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.SvcIdQlfrDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = SvcIdQlfrDeserializer.class)
public enum SvcIdQlfr implements CodeEnum {
	// @formatter:off
	AmericanDentalAssociationCodes("AD", "American Dental Association Codes"),
	CurrentProceduralTerminologyCPTCodes("CJ", "Current Procedural Terminology (CPT) Codes"),
	HealthCareFinancingAdministrationCommon("HC", "Health Care Financing Administration Common"),
	InternationalClassificationOfDiseasesClinical("ID", "International Classification of Diseases Clinical"),
	HomeInfusionEDICoalitionHIECProductServiceCode("IV", "Home Infusion EDI Coalition (HIEC) Product/Service Code"),
	NationalDrugCodeIn542Format("N4", "National Drug Code in 5-4-2 Format"),
	NationalDrugCodeNDC("ND", "National Drug Code (NDC)"),
	MutuallyDefined("ZZ", "Mutually Defined");
	// @formatter:on

	private static final Map<String, SvcIdQlfr> lookup = new HashMap<String, SvcIdQlfr>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 235;

	static {
		for (SvcIdQlfr svcIdQlfr : EnumSet.allOf(SvcIdQlfr.class))
			lookup.put(svcIdQlfr.getCode(), svcIdQlfr);
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

	private SvcIdQlfr(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static SvcIdQlfr get(String code) {
		return lookup.get(code);
	}
}
