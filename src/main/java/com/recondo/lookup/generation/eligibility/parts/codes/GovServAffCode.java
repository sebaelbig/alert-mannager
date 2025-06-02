package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.GovServAffCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = GovServAffCodeDeserializer.class)
public enum GovServAffCode implements CodeEnum {
	// @formatter:off
	AirForce("A", "Air Force"),
	AirForceReserves("B", "Air Force Reserves"),
	Army("C", "Army"),
	ArmyReserves("D", "Army Reserves"),
	CoastGuard("E", "Coast Guard"),
	MarineCorps("F", "Marine Corps"),
	MarineCorpsReserves("G", "Marine Corps Reserves"),
	NationalGuard("H", "National Guard"),
	Navy("I", "Navy"),
	NavyReserves("J", "Navy Reserves"),
	Other("K", "Other"),
	PeaceCorp("L", "Peace Corp"),
	RegularArmedForces("M", "Regular Armed Forces"),
	Reserves("N", "Reserves"),
	USPublicHealthService("O", "U.S. Public Health Service"),
	ForeignMilitary("Q", "Foreign Military"),
	AmericanRedCross("R", "American Red Cross"),
	DepartmentOfDefense("S", "Department of Defense"),
	UnitedServicesOrganization("U", "United Services Organization"),
	MilitarySealiftCommand("W", "Military Sealift Command");
	// @formatter:on

	private static final Map<String, GovServAffCode> lookup = new HashMap<String, GovServAffCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 1595;

	static {
		for (GovServAffCode govServAffCode : EnumSet.allOf(GovServAffCode.class))
			lookup.put(govServAffCode.getCode(), govServAffCode);
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

	private GovServAffCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static GovServAffCode get(String code) {
		return lookup.get(code);
	}
}
