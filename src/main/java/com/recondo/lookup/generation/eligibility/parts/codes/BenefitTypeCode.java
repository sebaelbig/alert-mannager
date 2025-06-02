package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.BenefitTypeCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = BenefitTypeCodeDeserializer.class)
public enum BenefitTypeCode implements CodeEnum {
	// @formatter:off
	ActiveCoverage("1", "Active Coverage"),
	ActiveFullRiskCapitation("2", "Active - Full Risk Capitation"),
	ActiveServicesCapitated("3", "Active - Services Capitated"),
	ActiveServicesCapitatedToPrimaryCare("4", "Active - Services Capitated to Primary Care"),
	ActivePendingInvestigation("5", "Active - Pending Investigation"),
	Inactive("6", "Inactive"),
	InactivePendingEligibilityUpdate("7", "Inactive - Pending Eligibility Update"),
	InactivePendingInvestigation("8", "Inactive - Pending Investigation"),
	CoInsurance("A", "Co-Insurance"),
	CoPayment("B", "Co-Payment"),
	Deductible("C", "Deductible"),
	CoverageBasis("CB", "Coverage Basis"),
	BenefitDescription("D", "Benefit Description"),
	Exclusions("E", "Exclusions"),
	Limitations("F", "Limitations"),
	OutOfPocketStopLoss("G", "Out of Pocket (Stop Loss)"),
	Unlimited("H", "Unlimited"),
	NonCovered("I", "Non-Covered"),
	CostContainment("J", "Cost Containment"),
	Reserve("K", "Reserve"),
	PrimaryCareProvider("L", "Primary Care Provider"),
	PreexistingCondition("M", "Pre-existing Condition"),
	ManagedCareCoordinator("MC", "Managed Care Coordinator"),
	ServicesRestrictedToFollowingProvider("N", "Services Restricted to Following Provider"),
	NotDeemedAMedicalNecessity("O", "Not Deemed a Medical Necessity"),
	BenefitDisclaimer("P", "Benefit Disclaimer"),
	SecondSurgicalOpinionRequired("Q", "Second Surgical Opinion Required"),
	OtherOrAdditionalPayor("R", "Other or Additional Payor"),
	PriorYearsHistory("S", "Prior Year(s) History"),
	CardsReportedLostStolen("T", "Card(s) Reported Lost/Stolen"),
	ContactFollowingEntityForEligibilityOrBenefit("U", "Contact Following Entity for Eligibility or Benefit"),
	CannotProcess("V", "Cannot Process"),
	OtherSourceOfData("W", "Other Source of Data"),
	HealthCareFacility("X", "Health Care Facility"),
	SpendDown("Y", "Spend Down");
	// @formatter:on

	private static final Map<String, BenefitTypeCode> lookup = new HashMap<String, BenefitTypeCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 1390;

	static {
		for (BenefitTypeCode benefitTypeCode : EnumSet.allOf(BenefitTypeCode.class))
			lookup.put(benefitTypeCode.getCode(), benefitTypeCode);
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

	private BenefitTypeCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static BenefitTypeCode get(String code) {
		return lookup.get(code);
	}
}
