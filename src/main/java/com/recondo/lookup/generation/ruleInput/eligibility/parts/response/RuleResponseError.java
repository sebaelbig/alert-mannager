package com.recondo.lookup.generation.ruleInput.eligibility.parts.response;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Represents an Error, either internal or from a X12 270/271
 */
public class RuleResponseError {
	private String errorScope;
	private String errorScopeDesc;

	private String validRequestIndicator;
	private String validRequestIndicatorDesc;

	private String rejectReasonCode;
	private String rejectReasonCodeDesc;

	private String followUpActionCode;
	private String followUpActionCodeDesc;


	public RuleResponseError() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	public String getErrorScope() {
		return errorScope;
	}
	public void setErrorScope(String errorScope) {
		this.errorScope = errorScope;
	}

	public String getErrorScopeDesc() {
		return errorScopeDesc;
	}
	public void setErrorScopeDesc(String errorScopeDesc) {
		this.errorScopeDesc = errorScopeDesc;
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
