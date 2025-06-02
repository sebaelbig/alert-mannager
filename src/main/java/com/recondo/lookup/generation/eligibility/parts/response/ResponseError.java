package com.recondo.lookup.generation.eligibility.parts.response;

import com.recondo.lookup.generation.eligibility.parts.codes.ErrorScope;
import com.recondo.lookup.generation.eligibility.parts.codes.FollowUpActionCode;
import com.recondo.lookup.generation.eligibility.parts.codes.RejectReasonCode;
import com.recondo.lookup.generation.eligibility.parts.codes.YesNoIndicator;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * Represents an Error, either internal or from a X12 270/271
 * 
 * @author Robert.Larivee
 */
public class ResponseError implements Serializable {
	private static final long serialVersionUID = 1L;

	private ErrorScope errorScope;
	private String errorScopeDesc;

	private YesNoIndicator validRequestIndicator;
	private String validRequestIndicatorDesc;

	private RejectReasonCode rejectReasonCode;
	private String rejectReasonCodeDesc;

	private FollowUpActionCode followUpActionCode;
	private String followUpActionCodeDesc;


	// Must have a default constructor for Jackson to use when parsing JSON
	public ResponseError() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


	public ErrorScope getErrorScope() {
		return errorScope;
	}
	public void setErrorScope(ErrorScope errorScope) {
		this.errorScope = errorScope;
	}

	public String getErrorScopeDesc() {
		return errorScopeDesc;
	}
	public void setErrorScopeDesc(String errorScopeDesc) {
		this.errorScopeDesc = errorScopeDesc;
	}

	public YesNoIndicator getValidRequestIndicator() {
		return validRequestIndicator;
	}
	public void setValidRequestIndicator(YesNoIndicator validRequestIndicator) {
		this.validRequestIndicator = validRequestIndicator;
	}

	public String getValidRequestIndicatorDesc() {
		return validRequestIndicatorDesc;
	}
	public void setValidRequestIndicatorDesc(String validRequestIndicatorDesc) {
		this.validRequestIndicatorDesc = validRequestIndicatorDesc;
	}

	public RejectReasonCode getRejectReasonCode() {
		return rejectReasonCode;
	}
	public void setRejectReasonCode(RejectReasonCode rejectReasonCode) {
		this.rejectReasonCode = rejectReasonCode;
	}

	public String getRejectReasonCodeDesc() {
		return rejectReasonCodeDesc;
	}
	public void setRejectReasonCodeDesc(String rejectReasonCodeDesc) {
		this.rejectReasonCodeDesc = rejectReasonCodeDesc;
	}

	public FollowUpActionCode getFollowUpActionCode() {
		return followUpActionCode;
	}
	public void setFollowUpActionCode(FollowUpActionCode followUpActionCode) {
		this.followUpActionCode = followUpActionCode;
	}

	public String getFollowUpActionCodeDesc() {
		return followUpActionCodeDesc;
	}
	public void setFollowUpActionCodeDesc(String followUpActionCodeDesc) {
		this.followUpActionCodeDesc = followUpActionCodeDesc;
	}
}
