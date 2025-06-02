package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.EntityRelationshipCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = EntityRelationshipCodeDeserializer.class)
public enum EntityRelationshipCode implements CodeEnum {
	// @formatter:off
	Parent("01", "Parent"),
	Child("02", "Child"),
	DomesticPartner("27", "Domestic Partner"),
	Spouse("41", "Spouse"),
	Employee("48", "Employee"),
	Other("65", "Other"),
	Unknown("72", "Unknown");
	// @formatter:on

	private static final Map<String, EntityRelationshipCode> lookup = new HashMap<String, EntityRelationshipCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 706;

	static {
		for (EntityRelationshipCode entityRelationshipCode : EnumSet.allOf(EntityRelationshipCode.class))
			lookup.put(entityRelationshipCode.getCode(), entityRelationshipCode);
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

	private EntityRelationshipCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static EntityRelationshipCode get(String code) {
		return lookup.get(code);
	}
}
