package com.recondo.lookup.generation.ruleInput.eligibility.parts;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Represents the TRN segment of a X12 270/271 EDI
 */
public class RuleTraceNumber {
	private String traceTypeCode;
	private String traceTypeCodeDesc;

	private String refId;

	private String originId;

	private String additionalRefId;


	public RuleTraceNumber() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


	public String getTraceTypeCode() {
		return traceTypeCode;
	}
	public void setTraceTypeCode(String traceTypeCode) {
		this.traceTypeCode = traceTypeCode;
	}

	public String getTraceTypeCodeDesc() {
		return traceTypeCodeDesc;
	}
	public void setTraceTypeCodeDesc(String traceTypeCodeDesc) {
		this.traceTypeCodeDesc = traceTypeCodeDesc;
	}

	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getOriginId() {
		return originId;
	}
	public void setOriginId(String originId) {
		this.originId = originId;
	}

	public String getAdditionalRefId() {
		return additionalRefId;
	}
	public void setAdditionalRefId(String additionalRefId) {
		this.additionalRefId = additionalRefId;
	}
}
