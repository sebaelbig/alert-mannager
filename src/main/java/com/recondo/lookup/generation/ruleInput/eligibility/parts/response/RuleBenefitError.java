package com.recondo.lookup.generation.ruleInput.eligibility.parts.response;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class RuleBenefitError {
	private String validRequestIndicator;
	private String validRequestIndicatorDesc;

	private String rejectReasonCode;
	private String rejectReasonCodeDesc;

	private String followUpActionCode;
	private String followUpActionCodeDesc;


	public RuleBenefitError() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


	public String getValidRequestIndicator() {
		return validRequestIndicator;
	}
	public void setValidRequestIndicator(String validRequestIndicator) {
		this.validRequestIndicator = validRequestIndicator;
	}

	public String getValidRequestIndicatorDesc() {
		return validRequestIndicatorDesc;
	}
	public void setValidRequestIndicatorDesc(String validRequestIndicatorDesc) {
		this.validRequestIndicatorDesc = validRequestIndicatorDesc;
	}

	public String getRejectReasonCode() {
		return rejectReasonCode;
	}
	public void setRejectReasonCode(String rejectReasonCode) {
		this.rejectReasonCode = rejectReasonCode;
	}

	public String getRejectReasonCodeDesc() {
		return rejectReasonCodeDesc;
	}
	public void setRejectReasonCodeDesc(String rejectReasonCodeDesc) {
		this.rejectReasonCodeDesc = rejectReasonCodeDesc;
	}

	public String getFollowUpActionCode() {
		return followUpActionCode;
	}
	public void setFollowUpActionCode(String followUpActionCode) {
		this.followUpActionCode = followUpActionCode;
	}

	public String getFollowUpActionCodeDesc() {
		return followUpActionCodeDesc;
	}
	public void setFollowUpActionCodeDesc(String followUpActionCodeDesc) {
		this.followUpActionCodeDesc = followUpActionCodeDesc;
	}
}
