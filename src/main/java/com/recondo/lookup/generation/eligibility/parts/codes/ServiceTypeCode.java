package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.ServiceTypeCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = ServiceTypeCodeDeserializer.class)
public enum ServiceTypeCode implements CodeEnum {
	// @formatter:off
	MedicalCare("1", "Medical Care"),
	BloodCharges("10", "Blood Charges"),
	UsedDurableMedicalEquipment("11", "Used Durable Medical Equipment"),
	DurableMedicalEquipmentPurchase("12", "Durable Medical Equipment Purchase"),
	AmbulatoryServiceCenterFacility("13", "Ambulatory Service Center Facility"),
	RenalSuppliesInTheHome("14", "Renal Supplies in the Home"),
	AlternateMethodDialysis("15", "Alternate Method Dialysis"),
	ChronicRenalDiseaseCRDEquipment("16", "Chronic Renal Disease (CRD) Equipment"),
	PreAdmissionTesting("17", "Pre-Admission Testing"),
	DurableMedicalEquipmentRental("18", "Durable Medical Equipment Rental"),
	PneumoniaVaccine("19", "Pneumonia Vaccine"),
	Surgical("2", "Surgical"),
	SecondSurgicalOpinion("20", "Second Surgical Opinion"),
	ThirdSurgicalOpinion("21", "Third Surgical Opinion"),
	SocialWork("22", "Social Work"),
	DiagnosticDental("23", "Diagnostic Dental"),
	Periodontics("24", "Periodontics"),
	Restorative("25", "Restorative"),
	Endodontics("26", "Endodontics"),
	MaxillofacialProsthetics("27", "Maxillofacial Prosthetics"),
	AdjunctiveDentalServices("28", "Adjunctive Dental Services"),
	Consultation("3", "Consultation"),
	HealthBenefitPlanCoverage("30", "Health Benefit Plan Coverage"),
	PlanWaitingPeriod("32", "Plan Waiting Period"),
	Chiropractic("33", "Chiropractic"),
	ChiropracticOfficeVisits("34", "Chiropractic Office Visits"),
	DentalCare("35", "Dental Care"),
	DentalCrowns("36", "Dental Crowns"),
	DentalAccident("37", "Dental Accident"),
	Orthodontics("38", "Orthodontics"),
	Prosthodontics("39", "Prosthodontics"),
	DiagnosticXRay("4", "Diagnostic X-Ray"),
	OralSurgery("40", "Oral Surgery"),
	RoutinePreventiveDental("41", "Routine (Preventive) Dental"),
	HomeHealthCare("42", "Home Health Care"),
	HomeHealthPrescriptions("43", "Home Health Prescriptions"),
	HomeHealthVisits("44", "Home Health Visits"),
	Hospice("45", "Hospice"),
	RespiteCare("46", "Respite Care"),
	Hospital("47", "Hospital"),
	HospitalInpatient("48", "Hospital - Inpatient"),
	HospitalRoomAndBoard("49", "Hospital - Room and Board"),
	DiagnosticLab("5", "Diagnostic Lab"),
	HospitalOutpatient("50", "Hospital - Outpatient"),
	HospitalEmergencyAccident("51", "Hospital - Emergency Accident"),
	HospitalEmergencyMedical("52", "Hospital - Emergency Medical"),
	HospitalAmbulatorySurgical("53", "Hospital - Ambulatory Surgical"),
	LongTermCare("54", "Long Term Care"),
	MajorMedical("55", "Major Medical"),
	MedicallyRelatedTransportation("56", "Medically Related Transportation"),
	AirTransportation("57", "Air Transportation"),
	Cabulance("58", "Cabulance"),
	LicensedAmbulance("59", "Licensed Ambulance"),
	RadiationTherapy("6", "Radiation Therapy"),
	GeneralBenefits("60", "General Benefits"),
	InvitroFertilization("61", "In-vitro Fertilization"),
	MRICATScan("62", "MRI/CAT Scan"),
	DonorProcedures("63", "Donor Procedures"),
	Acupuncture("64", "Acupuncture"),
	NewbornCare("65", "Newborn Care"),
	Pathology("66", "Pathology"),
	SmokingCessation("67", "Smoking Cessation"),
	WellBabyCare("68", "Well Baby Care"),
	Maternity("69", "Maternity"),
	Anesthesia("7", "Anesthesia"),
	Transplants("70", "Transplants"),
	AudiologyExam("71", "Audiology Exam"),
	InhalationTherapy("72", "Inhalation Therapy"),
	DiagnosticMedical("73", "Diagnostic Medical"),
	PrivateDutyNursing("74", "Private Duty Nursing"),
	ProstheticDevice("75", "Prosthetic Device"),
	Dialysis("76", "Dialysis"),
	OtologicalExam("77", "Otological Exam"),
	Chemotherapy("78", "Chemotherapy"),
	AllergyTesting("79", "Allergy Testing"),
	SurgicalAssistance("8", "Surgical Assistance"),
	Immunizations("80", "Immunizations"),
	RoutinePhysical("81", "Routine Physical"),
	FamilyPlanning("82", "Family Planning"),
	Infertility("83", "Infertility"),
	Abortion("84", "Abortion"),
	AIDS("85", "AIDS"),
	EmergencyServices("86", "Emergency Services"),
	Cancer("87", "Cancer"),
	Pharmacy("88", "Pharmacy"),
	FreeStandingPrescriptionDrug("89", "Free Standing Prescription Drug"),
	OtherMedical("9", "Other Medical"),
	MailOrderPrescriptionDrug("90", "Mail Order Prescription Drug"),
	BrandNamePrescriptionDrug("91", "Brand Name Prescription Drug"),
	GenericPrescriptionDrug("92", "Generic Prescription Drug"),
	Podiatry("93", "Podiatry"),
	PodiatryOfficeVisits("94", "Podiatry - Office Visits"),
	PodiatryNursingHomeVisits("95", "Podiatry - Nursing Home Visits"),
	ProfessionalPhysician("96", "Professional (Physician)"),
	Anesthesiologist("97", "Anesthesiologist"),
	ProfessionalPhysicianVisitOffice("98", "Professional (Physician) Visit - Office"),
	ProfessionalPhysicianVisitInpatient("99", "Professional (Physician) Visit - Inpatient"),
	ProfessionalPhysicianVisitOutpatient("A0", "Professional (Physician) Visit - Outpatient"),
	ProfessionalPhysicianVisitNursingHome("A1", "Professional (Physician) Visit - Nursing Home"),
	ProfessionalPhysicianVisitSkilledNursing("A2", "Professional (Physician) Visit - Skilled Nursing"),
	ProfessionalPhysicianVisitHome("A3", "Professional (Physician) Visit - Home"),
	Psychiatric("A4", "Psychiatric"),
	PsychiatricRoomAndBoard("A5", "Psychiatric - Room and Board"),
	Psychotherapy("A6", "Psychotherapy"),
	PsychiatricInpatient("A7", "Psychiatric - Inpatient"),
	PsychiatricOutpatient("A8", "Psychiatric - Outpatient"),
	Rehabilitation("A9", "Rehabilitation"),
	RehabilitationRoomAndBoard("AA", "Rehabilitation - Room and Board"),
	RehabilitationInpatient("AB", "Rehabilitation - Inpatient"),
	RehabilitationOutpatient("AC", "Rehabilitation - Outpatient"),
	OccupationalTherapy("AD", "Occupational Therapy"),
	PhysicalMedicine("AE", "Physical Medicine"),
	SpeechTherapy("AF", "Speech Therapy"),
	SkilledNursingCare("AG", "Skilled Nursing Care"),
	SkilledNursingCareRoomAndBoard("AH", "Skilled Nursing Care - Room and Board"),
	SubstanceAbuse("AI", "Substance Abuse"),
	Alcoholism("AJ", "Alcoholism"),
	DrugAddiction("AK", "Drug Addiction"),
	VisionOptometry("AL", "Vision (Optometry)"),
	Frames("AM", "Frames"),
	RoutineExam("AN", "Routine Exam"),
	Lenses("AO", "Lenses"),
	NonmedicallyNecessaryPhysical("AQ", "Nonmedically Necessary Physical"),
	ExperimentalDrugTherapy("AR", "Experimental Drug Therapy"),
	BurnCare("B1", "Burn Care"),
	BrandNamePrescriptionDrugFormulary("B2", "Brand Name Prescription Drug - Formulary"),
	BrandNamePrescriptionDrugNonFormulary("B3", "Brand Name Prescription Drug - Non-Formulary"),
	IndependentMedicalEvaluation("BA", "Independent Medical Evaluation"),
	PartialHospitalizationPsychiatric("BB", "Partial Hospitalization (Psychiatric)"),
	DayCarePsychiatric("BC", "Day Care (Psychiatric)"),
	CognitiveTherapy("BD", "Cognitive Therapy"),
	MassageTherapy("BE", "Massage Therapy"),
	PulmonaryRehabilitation("BF", "Pulmonary Rehabilitation"),
	CardiacRehabilitation("BG", "Cardiac Rehabilitation"),
	Pediatric("BH", "Pediatric"),
	Nursery("BI", "Nursery"),
	Skin("BJ", "Skin"),
	Orthopedic("BK", "Orthopedic"),
	Cardiac("BL", "Cardiac"),
	Lymphatic("BM", "Lymphatic"),
	Gastrointestinal("BN", "Gastrointestinal"),
	Endocrine("BP", "Endocrine"),
	Neurology("BQ", "Neurology"),
	Eye("BR", "Eye"),
	InvasiveProcedures("BS", "Invasive Procedures"),
	Gynecological("BT", "Gynecological"),
	Obstetrical("BU", "Obstetrical"),
	ObstetricalGynecological("BV", "Obstetrical/Gynecological"),
	MailOrderPrescriptionDrugBrandName("BW", "Mail Order Prescription Drug: Brand Name"),
	MailOrderPrescriptionDrugGeneric("BX", "Mail Order Prescription Drug: Generic"),
	PhysicianVisitOfficeSick("BY", "Physician Visit - Office: Sick"),
	PhysicianVisitOfficeWell("BZ", "Physician Visit - Office: Well"),
	CoronaryCare("C1", "Coronary Care"),
	PrivateDutyNursingInpatient("CA", "Private Duty Nursing - Inpatient"),
	PrivateDutyNursingHome("CB", "Private Duty Nursing - Home"),
	SurgicalBenefitsProfessionalPhysician("CC", "Surgical Benefits - Professional (Physician)"),
	SurgicalBenefitsFacility("CD", "Surgical Benefits - Facility"),
	MentalHealthProviderInpatient("CE", "Mental Health Provider - Inpatient"),
	MentalHealthProviderOutpatient("CF", "Mental Health Provider - Outpatient"),
	MentalHealthFacilityInpatient("CG", "Mental Health Facility - Inpatient"),
	MentalHealthFacilityOutpatient("CH", "Mental Health Facility - Outpatient"),
	SubstanceAbuseFacilityInpatient("CI", "Substance Abuse Facility - Inpatient"),
	SubstanceAbuseFacilityOutpatient("CJ", "Substance Abuse Facility - Outpatient"),
	ScreeningXray("CK", "Screening X-ray"),
	ScreeningLaboratory("CL", "Screening laboratory"),
	MammogramHighRiskPatient("CM", "Mammogram - High Risk Patient"),
	MammogramLowRiskPatient("CN", "Mammogram - Low Risk Patient"),
	FluVaccination("CO", "Flu Vaccination"),
	EyewearAndEyewearAccessories("CP", "Eyewear and Eyewear Accessories"),
	CaseManagement("CQ", "Case Management"),
	Dermatology("DG", "Dermatology"),
	DurableMedicalEquipment("DM", "Durable Medical Equipment"),
	DiabeticSupplies("DS", "Diabetic Supplies"),
	GenericPrescriptionDrugFormulary("GF", "Generic Prescription Drug - Formulary"),
	GenericPrescriptionDrugNonFormulary("GN", "Generic Prescription Drug - Non-Formulary"),
	Allergy("GY", "Allergy"),
	IntensiveCare("IC", "Intensive Care"),
	MentalHealth("MH", "Mental Health"),
	NeonatalIntensiveCare("NI", "Neonatal Intensive Care"),
	Oncology("ON", "Oncology"),
	PhysicalTherapy("PT", "Physical Therapy"),
	Pulmonary("PU", "Pulmonary"),
	Renal("RN", "Renal"),
	ResidentialPsychiatricTreatment("RT", "Residential Psychiatric Treatment"),
	TransitionalCare("TC", "Transitional Care"),
	TransitionalNurseryCare("TN", "Transitional Nursery Care"),
	UrgentCareyOutpatient("UC", "Urgent Carey - Outpatient");
	// @formatter:on

	private static final Map<String, ServiceTypeCode> lookup = new HashMap<String, ServiceTypeCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 1365;

	static {
		for (ServiceTypeCode serviceTypeCode : EnumSet.allOf(ServiceTypeCode.class))
			lookup.put(serviceTypeCode.getCode(), serviceTypeCode);
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

	private ServiceTypeCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static ServiceTypeCode get(String code) {
		return lookup.get(code);
	}
}
