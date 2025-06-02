package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.InsurTypeCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = InsurTypeCodeDeserializer.class)
public enum InsurTypeCode implements CodeEnum {
	// @formatter:off
	MedicareSecondaryWorkingAgedBeneficiaryOr("12", "Medicare Secondary Working Aged Beneficiary or"),
	MedicareSecondaryEndStageRenalDisease("13", "Medicare Secondary End-Stage Renal Disease"),
	MedicareSecondaryNofaultInsuranceIncluding("14", "Medicare Secondary~~~ No-fault Insurance including"),
	MedicareSecondaryWorkersCompensation("15", "Medicare Secondary Worker's Compensation"),
	MedicareSecondaryPublicHealthServicePHSor("16", "Medicare Secondary Public Health Service (PHS)or"),
	MedicareSecondaryBlackLung("41", "Medicare Secondary Black Lung"),
	MedicareSecondaryVeteransAdministration("42", "Medicare Secondary Veteran's Administration"),
	MedicareSecondaryDisabledBeneficiaryUnder("43", "Medicare Secondary Disabled Beneficiary Under"),
	MedicareSecondaryOtherLiabilityInsuranceIs("47", "Medicare Secondary~~~ Other Liability Insurance is"),
	AutoInsurancePolicy("AP", "Auto Insurance Policy"),
	Commercial("C1", "Commercial"),
	ConsolidatedOmnibusBudgetReconciliationAct("CO", "Consolidated Omnibus Budget Reconciliation Act"),
	MedicareConditionallyPrimary("CP", "Medicare Conditionally Primary"),
	Disability("D", "Disability"),
	DisabilityBenefits("DB", "Disability Benefits"),
	ExclusiveProviderOrganization("EP", "Exclusive Provider Organization"),
	FamilyOrFriends("FF", "Family or Friends"),
	GroupPolicy("GP", "Group Policy"),
	HealthMaintenanceOrganizationHMO("HM", "Health Maintenance Organization (HMO)"),
	HealthMaintenanceOrganizationHMOMedicare("HN", "Health Maintenance Organization (HMO) - Medicare"),
	SpecialLowIncomeMedicareBeneficiary("HS", "Special Low Income Medicare Beneficiary"),
	Indemnity("IN", "Indemnity"),
	IndividualPolicy("IP", "Individual Policy"),
	LongTermCare("LC", "Long Term Care"),
	LongTermPolicy("LD", "Long Term Policy"),
	LifeInsurance("LI", "Life Insurance"),
	Litigation("LT", "Litigation"),
	MedicarePartA("MA", "Medicare Part A"),
	MedicarePartB("MB", "Medicare Part B"),
	Medicaid("MC", "Medicaid"),
	MedigapPartA("MH", "Medigap Part A"),
	MedigapPartB("MI", "Medigap Part B"),
	MedicarePrimary("MP", "Medicare Primary"),
	Other("OT", "Other"),
	PropertyInsurancePersonal("PE", "Property Insurance - Personal"),
	Personal("PL", "Personal"),
	PersonalPaymentCashNoInsurance("PP", "Personal Payment (Cash - No Insurance)"),
	PreferredProviderOrganizationPPO("PR", "Preferred Provider Organization (PPO)"),
	PointOfServicePOS("PS", "Point of Service (POS)"),
	QualifiedMedicareBeneficiary("QM", "Qualified Medicare Beneficiary"),
	PropertyInsuranceReal("RP", "Property Insurance - Real"),
	SupplementalPolicy("SP", "Supplemental Policy"),
	TaxEquityFiscalResponsibilityActTEFRA("TF", "Tax Equity Fiscal Responsibility Act (TEFRA)"),
	WorkersCompensation("WC", "Workers Compensation"),
	WrapUpPolicy("WU", "Wrap Up Policy");
	// @formatter:on

	private static final Map<String, InsurTypeCode> lookup = new HashMap<String, InsurTypeCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 1336;

	static {
		for (InsurTypeCode insurTypeCode : EnumSet.allOf(InsurTypeCode.class))
			lookup.put(insurTypeCode.getCode(), insurTypeCode);
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

	private InsurTypeCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static InsurTypeCode get(String code) {
		return lookup.get(code);
	}
}
