package com.recondo.lookup.generation.eligibility.parts.codes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.recondo.lookup.generation.eligibility.utils.json.RejectReasonCodeDeserializer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = RejectReasonCodeDeserializer.class)
public enum RejectReasonCode implements CodeEnum {
	// @formatter:off
	AuthorizedQuantityExceeded("04", "Authorized Quantity Exceeded"),
	RequiredApplicationDataMissing("15", "Required application data missing"),
	InputErrors("33", "Input Errors"),
	OutOfNetwork("35", "Out of Network"),
	AuthorizationAccessRestrictions("41", "Authorization/Access Restrictions"),
	UnableToRespondAtCurrentTime("42", "Unable to Respond at Current Time"),
	InvalidMissingProviderIdentification("43", "Invalid/Missing Provider Identification"),
	InvalidMissingProviderName("44", "Invalid/Missing Provider Name"),
	InvalidMissingProviderSpecialty("45", "Invalid/Missing Provider Specialty"),
	InvalidMissingProviderPhoneNumber("46", "Invalid/Missing Provider Phone Number"),
	InvalidMissingProviderState("47", "Invalid/Missing Provider State"),
	InvalidMissingReferringProviderIdentification("48", "Invalid/Missing Referring Provider Identification"),
	ProviderIsNotPrimaryCarePhysician("49", "Provider is Not Primary Care Physician"),
	ProviderIneligibleForInquiries("50", "Provider Ineligible for Inquiries"),
	ProviderNotOnFile("51", "Provider Not on File"),
	ServiceDatesNotWithinProviderPlanEnrollment("52", "Service Dates Not Within Provider Plan Enrollment"),
	InquiredBenefitInconsistentWithProviderType("53", "Inquired Benefit Inconsistent with Provider Type"),
	InappropriateProductServiceIDQualifier("54", "Inappropriate Product/Service ID Qualifier"),
	InappropriateProductServiceID("55", "Inappropriate Product/Service ID"),
	InappropriateDate("56", "Inappropriate Date"),
	InvalidMissingDatesOfService("57", "Invalid/Missing Date(s) of Service"),
	InvalidMissingDateofBirth("58", "Invalid/Missing Date-of-Birth"),
	DateOfBirthFollowsDatesOfService("60", "Date of Birth Follows Date(s) of Service"),
	DateOfDeathPrecedesDatesOfService("61", "Date of Death Precedes Date(s) of Service"),
	DateOfServiceNotWithinAllowableInquiryPeriod("62", "Date of Service Not Within Allowable Inquiry Period"),
	DateOfServiceInFuture("63", "Date of Service in Future"),
	InvalidMissingPatientID("64", "Invalid/Missing Patient ID"),
	InvalidMissingPatientName("65", "Invalid/Missing Patient Name"),
	InvalidMissingPatientGenderCode("66", "Invalid/Missing Patient Gender Code"),
	PatientNotFound("67", "Patient Not Found"),
	DuplicatePatientIDNumber("68", "Duplicate Patient ID Number"),
	InconsistentWithPatientsAge("69", "Inconsistent with Patient's Age"),
	InconsistentWithPatientsGender("70", "Inconsistent with Patient's Gender"),
	PatientBirthDateDoesNotMatchThatForThe("71", "Patient Birth Date Does Not Match That for the"),
	InvalidMissingSubscriberInsuredID("72", "Invalid/Missing Subscriber/Insured ID"),
	InvalidMissingSubscriberInsuredName("73", "Invalid/Missing Subscriber/Insured Name"),
	InvalidMissingSubscriberInsuredGenderCode("74", "Invalid/Missing Subscriber/Insured Gender Code"),
	SubscriberInsuredNotFound("75", "Subscriber/Insured Not Found"),
	DuplicateSubscriberInsuredIDNumber("76", "Duplicate Subscriber/Insured ID Number"),
	SubscriberFoundPatientNotFound("77", "Subscriber Found~~~ Patient Not Found"),
	SubscriberInsuredNotInGroupPlanIdentified("78", "Subscriber/Insured Not in Group/Plan Identified"),
	InvalidParticipantIdentification("79", "Invalid Participant Identification"),
	NoResponseReceivedTransactionTerminated("80", "No Response received - Transaction Terminated"),
	InvalidOrMissingProviderAddress("97", "Invalid or Missing Provider Address"),
	ExperimentalServiceOrProcedure("98", "Experimental Service or Procedure"),
	AuthorizationNumberNotFound("AA", "Authorization Number Not Found"),
	RequiresPrimaryCarePhysicianAuthorization("AE", "Requires Primary Care Physician Authorization"),
	InvalidMissingDiagnosisCodes("AF", "Invalid/Missing Diagnosis Code(s)"),
	InvalidMissingProcedureCodes("AG", "Invalid/Missing Procedure Code(s)"),
	AdditionalPatientConditionInformationRequired("AO", "Additional Patient Condition Information Required"),
	CertificationInformationDoesNotMatchPatient("CI", "Certification Information Does Not Match Patient"),
	RequiresMedicalReview("E8", "Requires Medical Review"),
	InvalidAuthorizationNumberFormat("IA", "Invalid Authorization Number Format"),
	MissingAuthorizationNumber("MA", "Missing Authorization Number"),
	PayerNameOrIdentifierMissing("T4", "Payer Name or Identifier Missing");
	// @formatter:on

	private static final Map<String, RejectReasonCode> lookup = new HashMap<String, RejectReasonCode>();
	private final String code;
	private final String description;
	private final int dataElementNumber = 901;

	static {
		for (RejectReasonCode rejectReasonCode : EnumSet.allOf(RejectReasonCode.class))
			lookup.put(rejectReasonCode.getCode(), rejectReasonCode);
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

	private RejectReasonCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static RejectReasonCode get(String code) {
		return lookup.get(code);
	}
}
