package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.AckRequestedDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = AckRequestedDeserializer.class)
public enum AckRequested implements CodeEnum {
	// @formatter:off
	NoAckRequested("0", "No Ack Requested"),
	AckRequested("1", "Ack Requested");
	// @formatter:on

	private static final Map<String, AckRequested> lookup = new HashMap<String, AckRequested>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 13;

	static {
		for (AckRequested ackRequested : EnumSet.allOf(AckRequested.class))
			lookup.put(ackRequested.getCode(), ackRequested);
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

	private AckRequested(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static AckRequested get(String code) {
		return lookup.get(code);
	}
}
