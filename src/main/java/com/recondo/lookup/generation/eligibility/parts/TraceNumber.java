package com.recondo.lookup.generation.eligibility.parts;

import com.recondo.lookup.generation.eligibility.parts.codes.TraceTypeCode;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Represents the TRN segment of a X12 270/271 EDI
 * 
 * @author Robert.Larivee
 */
public class TraceNumber implements Serializable {
	private static final long serialVersionUID = 1L;

	private TraceTypeCode traceTypeCode;
	private String traceTypeCodeDesc;

	@Size(min = 1, max = 50)
	private String refId;

	@Size(min = 10, max = 10)
	private String originId;

	@Size(min = 1, max = 50)
	private String additionalRefId;


	// Must have a default constructor for Jackson to use when parsing JSON
	public TraceNumber() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


	public TraceTypeCode getTraceTypeCode() {
		return traceTypeCode;
	}
	public void setTraceTypeCode(TraceTypeCode traceTypeCode) {
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
