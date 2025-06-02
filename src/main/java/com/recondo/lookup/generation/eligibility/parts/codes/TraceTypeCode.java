package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.TraceTypeCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = TraceTypeCodeDeserializer.class)
public enum TraceTypeCode implements CodeEnum {
	// @formatter:off
	ReferencedTransactionTraceNumbers("2", "Referenced Transaction Trace Numbers"),
	CurrentTransactionTraceNumbers("1", "Current Transaction Trace Numbers");
	// @formatter:on

	private static final Map<String, TraceTypeCode> lookup = new HashMap<String, TraceTypeCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 481;

	static {
		for (TraceTypeCode traceTypeCode : EnumSet.allOf(TraceTypeCode.class))
			lookup.put(traceTypeCode.getCode(), traceTypeCode);
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

	private TraceTypeCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static TraceTypeCode get(String code) {
		return lookup.get(code);
	}
}
