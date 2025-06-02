package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.MilServRankCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = MilServRankCodeDeserializer.class)
public enum MilServRankCode implements CodeEnum {
	// @formatter:off
	Admiral("A1", "Admiral"),
	Airman("A2", "Airman"),
	AirmanFirstClass("A3", "Airman First Class"),
	BasicAirman("B1", "Basic Airman"),
	BrigadierGeneral("B2", "Brigadier General"),
	Captain("C1", "Captain"),
	ChiefMasterSergeant("C2", "Chief Master Sergeant"),
	ChiefPettyOfficer("C3", "Chief Petty Officer"),
	ChiefWarrant("C4", "Chief Warrant"),
	Colonel("C5", "Colonel"),
	Commander("C6", "Commander"),
	Commodore("C7", "Commodore"),
	Corporal("C8", "Corporal"),
	CorporalSpecialist4("C9", "Corporal Specialist 4"),
	Ensign("E1", "Ensign"),
	FirstLieutenant("F1", "First Lieutenant"),
	FirstSergeant("F2", "First Sergeant"),
	FirstSergeantMasterSergeant("F3", "First Sergeant-Master Sergeant"),
	FleetAdmiral("F4", "Fleet Admiral"),
	General("G1", "General"),
	GunnerySergeant("G4", "Gunnery Sergeant"),
	LanceCorporal("L1", "Lance Corporal"),
	Lieutenant("L2", "Lieutenant"),
	LieutenantColonel("L3", "Lieutenant Colonel"),
	LieutenantCommander("L4", "Lieutenant Commander"),
	LieutenantGeneral("L5", "Lieutenant General"),
	LieutenantJuniorGrade("L6", "Lieutenant Junior Grade"),
	Major("M1", "Major"),
	MajorGeneral("M2", "Major General"),
	MasterChiefPettyOfficer("M3", "Master Chief Petty Officer"),
	MasterGunnerySergeantMajor("M4", "Master Gunnery Sergeant Major"),
	MasterSergeant("M5", "Master Sergeant"),
	MasterSergeantSpecialist8("M6", "Master Sergeant Specialist 8"),
	PettyOfficerFirstClass("P1", "Petty Officer First Class"),
	PettyOfficerSecondClass("P2", "Petty Officer Second Class"),
	PettyOfficerThirdClass("P3", "Petty Officer Third Class"),
	Private("P4", "Private"),
	PrivateFirstClass("P5", "Private First Class"),
	RearAdmiral("R1", "Rear Admiral"),
	Recruit("R2", "Recruit"),
	Seaman("S1", "Seaman"),
	SeamanApprentice("S2", "Seaman Apprentice"),
	SeamanRecruit("S3", "Seaman Recruit"),
	SecondLieutenant("S4", "Second Lieutenant"),
	SeniorChiefPettyOfficer("S5", "Senior Chief Petty Officer"),
	SeniorMasterSergeant("S6", "Senior Master Sergeant"),
	Sergeant("S7", "Sergeant"),
	SergeantFirstClassSpecialist7("S8", "Sergeant First Class Specialist 7"),
	SergeantMajorSpecialist9("S9", "Sergeant Major Specialist 9"),
	SergeantSpecialist5("SA", "Sergeant Specialist 5"),
	StaffSergeant("SB", "Staff Sergeant"),
	StaffSergeantSpecialist6("SC", "Staff Sergeant Specialist 6"),
	TechnicalSergeant("T1", "Technical Sergeant"),
	ViceAdmiral("V1", "Vice Admiral"),
	WarrantOfficer("W1", "Warrant Officer");
	// @formatter:on

	private static final Map<String, MilServRankCode> lookup = new HashMap<String, MilServRankCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 1596;

	static {
		for (MilServRankCode milServRankCode : EnumSet.allOf(MilServRankCode.class))
			lookup.put(milServRankCode.getCode(), milServRankCode);
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

	private MilServRankCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static MilServRankCode get(String code) {
		return lookup.get(code);
	}
}
