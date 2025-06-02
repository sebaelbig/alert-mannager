package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.RefIdQlfrDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = RefIdQlfrDeserializer.class)
public enum RefIdQlfr implements CodeEnum {
	// @formatter:off
	StateLicenseNumber("0B", "State License Number"),
	PlanNumber("18", "Plan Number"),
	MedicareProviderNumber("1C", "Medicare Provider Number"),
	MedicaidProviderNumber("1D", "Medicaid Provider Number"),
	FacilityIDNumber("1J", "Facility ID Number"),
	GroupOrPolicyNumber("1L", "Group or Policy Number"),
	MemberIdentificationNumber("1W", "Member Identification Number"),
	CaseNumber("3H", "Case Number"),
	FamilyUnitNumber("49", "Family Unit Number"),
	PersonalIdentificationNumberPIN("4A", "Personal Identification Number (PIN)"),
	SequenceNumber("55", "Sequence Number"),
	GroupNumber("6P", "Group Number"),
	ReferralNumber("9F", "Referral Number"),
	Servicer("9K", "Servicer"),
	EmployeeIdentificationNumber("A6", "Employee Identification Number"),
	AlternativeListID("ALS", "Alternative List ID"),
	CoverageListID("CLI", "Coverage List ID"),
	ContractNumber("CT", "Contract Number"),
	NationalAssociationOfBoardsOfPharmacyNumber("D3", "National Association of Boards of Pharmacy Number"),
	MedicalRecordIdentificationNumber("EA", "Medical Record Identification Number"),
	EmployersIdentificationNumber("EI", "Employer's Identification Number"),
	PatientAccountNumber("EJ", "Patient Account Number"),
	ElectronicDevicePinNumber("EL", "Electronic device pin number"),
	SubmitterIdentificationNumber("EO", "Submitter Identification Number"),
	HealthInsuranceClaimHICNumber("F6", "Health Insurance Claim (HIC) Number"),
	DrugFormularyNumber("FO", "Drug Formulary Number"),
	PriorAuthorizationNumber("G1", "Prior Authorization Number"),
	IdentificationCardSerialNumber("GH", "Identification Card Serial Number"),
	IdentityCardNumber("HJ", "Identity Card Number"),
	HealthCareFinancingAdministrationNational("HPI", "Health Care Financing Administration National"),
	IssueNumber("IF", "Issue Number"),
	InsurancePolicyNumber("IG", "Insurance Policy Number"),
	UserIdentification("JD", "User Identification"),
	MedicalAssistanceCategory("M7", "Medical Assistance Category"),
	MilitaryRankCivilianPayGradeNumber("ML", "Military Rank/Civilian Pay Grade Number"),
	ProviderPlanNetworkIdentificationNumber("N5", "Provider Plan Network Identification Number"),
	PlanNetworkIdentificationNumber("N6", "Plan Network Identification Number"),
	FacilityNetworkIdentificationNumber("N7", "Facility Network Identification Number"),
	MedicaidRecipientIdentificationNumber("NQ", "Medicaid Recipient Identification Number"),
	HealthCareProviderTaxonomyCode("PXC", "Health Care Provider Taxonomy Code"),
	PriorIdentifierNumber("Q4", "Prior Identifier Number"),
	SocialSecurityNumber("SY", "Social Security Number"),
	FederalTaxpayersIdentificationNumber("TJ", "Federal Taxpayer's Identification Number"),
	AgencyClaimNumber("Y4", "Agency Claim Number"),
	FacilityIdentificationNumber("1J", "Facility ID Number"),
	MutuallyDefined("ZZ", "Mutually Defined");
	// @formatter:on

	private static final Map<String, RefIdQlfr> lookup = new HashMap<String, RefIdQlfr>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 128;

	static {
		for (RefIdQlfr refIdQlfr : EnumSet.allOf(RefIdQlfr.class))
			lookup.put(refIdQlfr.getCode(), refIdQlfr);
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

	private RefIdQlfr(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static RefIdQlfr get(String code) {
		return lookup.get(code);
	}
}
