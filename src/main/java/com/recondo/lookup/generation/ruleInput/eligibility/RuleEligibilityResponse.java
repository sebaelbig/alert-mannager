package com.recondo.lookup.generation.ruleInput.eligibility;

import com.recondo.lookup.generation.ruleInput.eligibility.parts.RuleInsured;
import com.recondo.lookup.generation.ruleInput.eligibility.parts.RulePayer;
import com.recondo.lookup.generation.ruleInput.eligibility.parts.RuleProvider;
import com.recondo.lookup.generation.ruleInput.eligibility.parts.RuleRef;
import com.recondo.lookup.generation.ruleInput.eligibility.parts.RuleTraceNumber;
import com.recondo.lookup.generation.ruleInput.eligibility.parts.RuleTransactionHeader;
import com.recondo.lookup.generation.ruleInput.eligibility.parts.response.RuleBenefit;
import com.recondo.lookup.generation.ruleInput.eligibility.parts.response.RuleResponseError;
import com.recondo.lookup.generation.ruleInput.eligibility.parts.response.RuleSubstantiation;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a X12 EDI 271 Eligibility Response 
 */
public class RuleEligibilityResponse {
	private RuleTransactionHeader header;
	private RulePayer payer;
	private RuleProvider provider;
	private RuleInsured subscriber;
	private RuleInsured dependent;
	private List<RuleResponseError> errors = new ArrayList<>();
	private List<RuleBenefit> benefits = new ArrayList<>();
	private List<RuleRef> refSegments = new ArrayList<>();
	private List<RuleSubstantiation> substantiations = new ArrayList<>();
	private List<RuleTraceNumber> traceNumbers = new ArrayList<>();


	public RuleEligibilityResponse() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


	public RuleTransactionHeader getHeader() {
		return header;
	}
	public void setHeader(RuleTransactionHeader header) {
		this.header = header;
	}

	public RulePayer getPayer() {
		return payer;
	}
	public void setPayer(RulePayer payer) {
		this.payer = payer;
	}

	public RuleProvider getProvider() {
		return provider;
	}
	public void setProvider(RuleProvider provider) {
		this.provider = provider;
	}

	public RuleInsured getSubscriber() {
		return subscriber;
	}
	public void setSubscriber(RuleInsured subscriber) {
		this.subscriber = subscriber;
	}

	public RuleInsured getDependent() {
		return dependent;
	}
	public void setDependent(RuleInsured dependent) {
		this.dependent = dependent;
	}

	public List<RuleResponseError> getResponseErrors() {
		return errors;
	}
	public void setResponseErrors(List<RuleResponseError> errors) {
		this.errors = errors;
	}
	public void addResponseError(RuleResponseError error) {
		errors.add(error);
	}

	public List<RuleBenefit> getBenefits() {
		return benefits;
	}
	public void setBenefits(List<RuleBenefit> benefits) {
		this.benefits = benefits;
	}
	public void addBenefit(RuleBenefit benefit) {
		benefits.add(benefit);
	}

	public List<RuleRef> getRefSegments() {
		return refSegments;
	}
	public void setRefSegments(List<RuleRef> refSegments) {
		this.refSegments = refSegments;
	}
	public void addRefSegment(RuleRef refSegment) {
		refSegments.add(refSegment);
	}

	public List<RuleSubstantiation> getSubstantiations() {
		return substantiations;
	}
	public void setSubstantiations(List<RuleSubstantiation> substantiations) {
		this.substantiations = substantiations;
	}
	public void addSubstantiation(RuleSubstantiation substantiation) {
		substantiations.add(substantiation);
	}

	public List<RuleTraceNumber> getTrns() {
		return traceNumbers;
	}
	public void setTrns(List<RuleTraceNumber> trns) {
		this.traceNumbers = trns;
	}
	public void addTrn(RuleTraceNumber trn) {
		traceNumbers.add(trn);
	}
}
