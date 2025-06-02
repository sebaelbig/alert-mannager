package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.FollowUpActionCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = FollowUpActionCodeDeserializer.class)
public enum FollowUpActionCode implements CodeEnum {
	// @formatter:off
	PleaseCorrectAndResubmit("C", "Please Correct and Resubmit"),
	ResubmissionNotAllowed("N", "Resubmission Not Allowed"),
	PleaseResubmitOriginalTransaction("P", "Please Resubmit Original Transaction"),
	ResubmissionAllowed("R", "Resubmission Allowed"),
	DoNotResubmitInquiryInitiatedToAThirdParty("S", "Do Not Resubmit; Inquiry Initiated to a Third Party"),
	PleaseWait30DaysAndResubmit("W", "Please Wait 30 Days and Resubmit"),
	PleaseWait10DaysAndResubmit("X", "Please Wait 10 Days and Resubmit"),
	DoNotResubmitWeWillHoldYourRequestAnd("Y", "Do Not Resubmit; We Will Hold Your Request and");
	// @formatter:on

	private static final Map<String, FollowUpActionCode> lookup = new HashMap<String, FollowUpActionCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 889;

	static {
		for (FollowUpActionCode followUpActionCode : EnumSet.allOf(FollowUpActionCode.class))
			lookup.put(followUpActionCode.getCode(), followUpActionCode);
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

	private FollowUpActionCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static FollowUpActionCode get(String code) {
		return lookup.get(code);
	}
}
