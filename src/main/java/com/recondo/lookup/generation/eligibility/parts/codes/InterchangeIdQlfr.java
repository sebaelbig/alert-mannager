package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.InterchangeIdQlfrDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = InterchangeIdQlfrDeserializer.class)
public enum InterchangeIdQlfr implements CodeEnum {
	// @formatter:off
	Duns("01", "Duns"),
	DunsPlusSuffix("14", "Duns Plus Suffix"),
	HealthIndustryNumber("20", "Health Industry Number"),
	CarrierIDNumber("27", "Carrier ID Number"),
	FiscalIntermediaryIDNumber("28", "Fiscal Intermediary ID Number"),
	MedicareProviderIDNumber("29", "Medicare Provider ID Number"),
	FederalTaxIDNumber("30", "Federal Tax ID Number"),
	NAICCode("33", "NAIC Code"),
	MutuallyDefined("ZZ", "Mutually Defined");
	// @formatter:on

	private static final Map<String, InterchangeIdQlfr> lookup = new HashMap<String, InterchangeIdQlfr>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 5;

	static {
		for (InterchangeIdQlfr interchangeIdQlfr : EnumSet.allOf(InterchangeIdQlfr.class))
			lookup.put(interchangeIdQlfr.getCode(), interchangeIdQlfr);
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

	private InterchangeIdQlfr(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static InterchangeIdQlfr get(String code) {
		return lookup.get(code);
	}
}
