package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.IdCodeQlfrDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = IdCodeQlfrDeserializer.class)
public enum IdCodeQlfr implements CodeEnum {
	// @formatter:off
	CentersForMedicareAndMedicaidServicesNationalProviderIdentifier("XX", "Centers for Medicare and Medicaid Services National Provider Identifier"),
	PayorIdentification("PI", "Payor Identification"),
	FacilityIdentification("FA", "Facility Identification"),
	FederalTaxpayersIdentificationNumber("FI", "Federal Taxpayer's Identification Number"),
	MemberIdentificationNumber("MI", "Member Identification Number"),
	EmployersIdentificationNumber("24", "Employer's Identification Number"),
	ElectronicTransmitterIdentificationNumberETIN("46", "Electronic Transmitter Identification Number (ETIN)"),
	PharmacyProcessorNumber("PP", "Pharmacy Processor Number"),
	MutuallyDefined("ZZ", "Mutually Defined"),
	CentersForMedicareAndMedicaidServicesPlanID("XV", "Centers for Medicare and Medicaid Services PlanID"),
	NationalAssociationOfInsuranceCommissioners("NI", "National Association of Insurance Commissioners"),
	ServiceProviderNumber("SV", "Service Provider Number"),
	SocialSecurityNumber("34", "Social Security Number"),
	StandardUniqueHealthIdentifier("II", "Standard Unique Health Identifier");
	// @formatter:on

	private static final Map<String, IdCodeQlfr> lookup = new HashMap<String, IdCodeQlfr>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 66;

	static {
		for (IdCodeQlfr idCodeQlfr : EnumSet.allOf(IdCodeQlfr.class))
			lookup.put(idCodeQlfr.getCode(), idCodeQlfr);
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

	private IdCodeQlfr(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static IdCodeQlfr get(String code) {
		return lookup.get(code);
	}
}
