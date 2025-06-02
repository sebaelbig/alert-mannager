package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.IndustryCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = IndustryCodeDeserializer.class)
public enum IndustryCode implements CodeEnum {
	// @formatter:off
	Pharmacy("01", "Pharmacy"),
	School("03", "School"),
	HomelessShelter("04", "Homeless Shelter"),
	IndianHealthServiceFreestandingFacility("05", "Indian Health Service Free-standing Facility"),
	IndianHealthServiceProviderbasedFacility("06", "Indian Health Service Provider-based Facility"),
	Tribal638FreestandingFacility("07", "Tribal 638 Free-standing Facility"),
	Tribal638ProviderbasedFacility("08", "Tribal 638 Provider-based Facility"),
	Office("11", "Office"),
	Home("12", "Home"),
	AssistedLivingFacility("13", "Assisted Living Facility"),
	GroupHome("14", "Group Home"),
	MobileUnit("15", "Mobile Unit"),
	UrgentCareFacility("20", "Urgent Care Facility"),
	InpatientHospital("21", "Inpatient Hospital"),
	OutpatientHospital("22", "Outpatient Hospital"),
	EmergencyRoomHospital("23", "Emergency Room - Hospital"),
	AmbulatorySurgicalCenter("24", "Ambulatory Surgical Center"),
	BirthingCenter("25", "Birthing Center"),
	MilitaryTreatmentFacility("26", "Military Treatment Facility"),
	SkilledNursingFacility("31", "Skilled Nursing Facility"),
	NursingFacility("32", "Nursing Facility"),
	CustodialCareFacility("33", "Custodial Care Facility"),
	Hospice("34", "Hospice"),
	AmbulanceLand("41", "Ambulance - Land"),
	AmbulanceAirOrWater("42", "Ambulance - Air or Water"),
	IndependentClinic("49", "Independent Clinic"),
	FederallyQualifiedHealthCenter("50", "Federally Qualified Health Center"),
	InpatientPsychiatricFacility("51", "Inpatient Psychiatric Facility"),
	PsychiatricFacilityPartialHospitalization("52", "Psychiatric Facility Partial Hospitalization"),
	CommunityMentalHealthCenter("53", "Community Mental Health Center"),
	IntermediateCareFacilityMentallyRetarded("54", "Intermediate Care Facility/Mentally Retarded"),
	ResidentialSubstanceAbuseTreatmentFacility("55", "Residential Substance Abuse Treatment Facility"),
	PsychiatricResidentialTreatmentCenter("56", "Psychiatric Residential Treatment Center"),
	NonresidentialSubstanceAbuseTreatmentFacility("57", "Non-residential Substance Abuse Treatment Facility"),
	MassImmunizationCenter("60", "Mass Immunization Center"),
	ComprehensiveInpatientRehabilitationFacility("61", "Comprehensive Inpatient Rehabilitation Facility"),
	ComprehensiveOutpatientRehabilitationFacility("62", "Comprehensive Outpatient Rehabilitation Facility"),
	EndStageRenalDiseaseTreatmentFacility("65", "End-Stage Renal Disease Treatment Facility"),
	StateOrLocalPublicHealthClinic("71", "State or Local Public Health Clinic"),
	RuralHealthClinic("72", "Rural Health Clinic"),
	IndependentLaboratory("81", "Independent Laboratory"),
	OtherUnlistedFacility("99", "Other Unlisted Facility");
	// @formatter:on

	private static final Map<String, IndustryCode> lookup = new HashMap<String, IndustryCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 1271;

	static {
		for (IndustryCode industryCode : EnumSet.allOf(IndustryCode.class))
			lookup.put(industryCode.getCode(), industryCode);
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

	private IndustryCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static IndustryCode get(String code) {
		return lookup.get(code);
	}
}
