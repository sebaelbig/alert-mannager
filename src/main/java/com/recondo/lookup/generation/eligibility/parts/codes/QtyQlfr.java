package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.QtyQlfrDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = QtyQlfrDeserializer.class)
public enum QtyQlfr implements CodeEnum {
	// @formatter:off
	Minimum("8H", "Minimum"),
	QuantityUsed("99", "Quantity Used"),
	CoveredActual("CA", "Covered - Actual"),
	CoveredEstimated("CE", "Covered - Estimated"),
	NumberOfCoinsuranceDays("D3", "Number of Co-insurance Days"),
	DeductibleBloodUnits("DB", "Deductible Blood Units"),
	Days("DY", "Days"),
	Units("FL", "Units"),
	Hours("HS", "Hours"),
	LifetimeReserveActual("LA", "Life-time Reserve - Actual"),
	LifetimeReserveEstimated("LE", "Life-time Reserve - Estimated"),
	Maximum("M2", "Maximum"),
	Month("MN", "Month"),
	NumberOfServicesOrProcedures("P6", "Number of Services or Procedures"),
	QuantityApproved("QA", "Quantity Approved"),
	AgeHighValue("S7", "Age, High Value"),
	AgeLowValue("S8", "Age, Low Value"),
	Visits("VS", "Visits"),
	Years("YY", "Years");
	// @formatter:on

	private static final Map<String, QtyQlfr> lookup = new HashMap<String, QtyQlfr>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 673;

	static {
		for (QtyQlfr qtyQlfr : EnumSet.allOf(QtyQlfr.class))
			lookup.put(qtyQlfr.getCode(), qtyQlfr);
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

	private QtyQlfr(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static QtyQlfr get(String code) {
		return lookup.get(code);
	}
}
