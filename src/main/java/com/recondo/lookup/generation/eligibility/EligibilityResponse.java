package com.recondo.lookup.generation.eligibility;

import com.recondo.lookup.generation.eligibility.parts.Insured;
import com.recondo.lookup.generation.eligibility.parts.Payer;
import com.recondo.lookup.generation.eligibility.parts.Provider;
import com.recondo.lookup.generation.eligibility.parts.Ref;
import com.recondo.lookup.generation.eligibility.parts.TraceNumber;
import com.recondo.lookup.generation.eligibility.parts.TransactionHeader;
import com.recondo.lookup.generation.eligibility.parts.response.Benefit;
import com.recondo.lookup.generation.eligibility.parts.response.ResponseError;
import com.recondo.lookup.generation.eligibility.parts.response.Substantiation;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a X12 EDI 271 Eligibility Response
 *
 * @author Robert.Larivee
 *
 */
public class EligibilityResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private TransactionHeader header;
	@Valid
	private Payer payer;
	private Provider provider;
	private Insured subscriber;
	private Insured dependent;
	private List<ResponseError> errors = new ArrayList<>();
	private List<Benefit> benefits = new ArrayList<>();
	private List<Ref> refSegments = new ArrayList<>();
	private List<Substantiation> substantiations = new ArrayList<>();
	@Size(max = 3)
	private List<TraceNumber> traceNumbers = new ArrayList<>();


	// Must have a default constructor for Jackson to use when parsing JSON
	public EligibilityResponse() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


	public TransactionHeader getHeader() {
		return header;
	}
	public void setHeader(TransactionHeader header) {
		this.header = header;
	}

	public Payer getPayer() {
		return payer;
	}
	public void setPayer(Payer payer) {
		this.payer = payer;
	}

	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Insured getSubscriber() {
		return subscriber;
	}
	public void setSubscriber(Insured subscriber) {
		this.subscriber = subscriber;
	}

	public Insured getDependent() {
		return dependent;
	}
	public void setDependent(Insured dependent) {
		this.dependent = dependent;
	}

	public List<ResponseError> getResponseErrors() {
		return errors;
	}
	public void setResponseErrors(List<ResponseError> errors) {
		this.errors = errors;
	}
	public void addResponseError(ResponseError error) {
		errors.add(error);
	}

	public List<Benefit> getBenefits() {
		return benefits;
	}
	public void setBenefits(List<Benefit> benefits) {
		this.benefits = benefits;
	}
	public void addBenefit(Benefit benefit) {
		benefits.add(benefit);
	}

	public List<Ref> getRefSegments() {
		return refSegments;
	}
	public void setRefSegments(List<Ref> refSegments) {
		this.refSegments = refSegments;
	}
	public void addRefSegment(Ref ref) {
		refSegments.add(ref);
	}

	public List<Substantiation> getSubstantiations() {
		return substantiations;
	}
	public void setSubstantiations(List<Substantiation> substantiations) {
		this.substantiations = substantiations;
	}
	public void addSubstantiation(Substantiation substantiation) {
		substantiations.add(substantiation);
	}

	public List<TraceNumber> getTrns() {
		return traceNumbers;
	}
	public void setTrns(List<TraceNumber> trns) {
		this.traceNumbers = trns;
	}
	public void addTrn(TraceNumber trn) {
		traceNumbers.add(trn);
	}
}
