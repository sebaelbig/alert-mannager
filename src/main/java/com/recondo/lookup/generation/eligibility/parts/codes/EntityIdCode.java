package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.EntityIdCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = EntityIdCodeDeserializer.class)
public enum EntityIdCode implements CodeEnum {
	// @formatter:off
	LegalRepresentative("LR", "Legal Representative"),
	TertiaryPayer("TTP", "Tertiary Payer"),
	UtilizationManagementOrganization("X3", "Utilization Management Organization"),
	PriorInsuranceCarrier("P4", "Prior Insurance Carrier"),
	Employer("36", "Employer"),
	Hospital("80", "Hospital"),
	Facility("FA", "Facility"),
	ThirdPartyAdministrator("2B", "Third-Party Administrator"),
	Dependent("03", "Dependent"),
	Provider("1P", "Provider"),
	SecondaryPayer("SEP", "Secondary Payer"),
	ContractedServiceProvider("13", "Contracted Service Provider"),
	GatewayProvider("GP", "Gateway Provider"),
	PlanSponsor("P5", "Plan Sponsor"),
	Payer("PR", "Payer"),
	InsuredOrSubscriber("IL", "Insured or Subscriber"),
	PrimaryCareProvider("P3", "Primary Care Provider"),
	PrimaryPayer("PRP", "Primary Payer"),
	OtherPhysician("73", "Other Physician"),
	Vendor("VN", "Vendor"),
	PreferredProviderOrganization("1I", "Preferred Provider Organization"),
	Group("GW", "Group"),
	IndependentPhysiciansAssociation("I3", "Independent Physicians Association"),
	OriginCarrier("OC", "Origin Carrier"),
	OrganizationCompletingConfigurationChange("VY", "Organization Completing Configuration Change");
	// @formatter:on

	private static final Map<String, EntityIdCode> lookup = new HashMap<String, EntityIdCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 98;

	static {
		for (EntityIdCode entityIdCode : EnumSet.allOf(EntityIdCode.class))
			lookup.put(entityIdCode.getCode(), entityIdCode);
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

	private EntityIdCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static EntityIdCode get(String code) {
		return lookup.get(code);
	}
}
