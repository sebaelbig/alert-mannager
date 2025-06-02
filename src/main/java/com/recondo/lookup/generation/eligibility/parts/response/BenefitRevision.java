package com.recondo.lookup.generation.eligibility.parts.response;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BenefitRevision implements Serializable {
	private static final long serialVersionUID = 1L;

	private String revisor;
	private String details;
	private Map<String, List<Benefit>> realtedBenefits = new HashMap<String, List<Benefit>>();


	public BenefitRevision(String revisor, String details) {
		this.revisor = revisor;
		this.details = details;
	}

	// Must have a default constructor for Jackson to use when parsing JSON
	public BenefitRevision() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


	public String getRevisor() {
		return revisor;
	}
	public void setRevisor(String revisor) {
		this.revisor = revisor;
	}

	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

	public Map<String, List<Benefit>> getRealtedBenefits() {
		return realtedBenefits;
	}
	public void setRealtedBenefits(Map<String, List<Benefit>> realtedBenefits) {
		this.realtedBenefits = realtedBenefits;
	}
	public void addRealtedBenefit(String realtedBenefitDetails, Benefit benefit) {
		List<Benefit> realtedBenefit =  (realtedBenefits.containsKey(realtedBenefitDetails)) ? realtedBenefits.get(realtedBenefitDetails) : new ArrayList<>();
		realtedBenefit.add(benefit);
		this.realtedBenefits.put(realtedBenefitDetails, realtedBenefit);
	}
	public void addRealtedBenefits(String realtedBenefitDetails, List<Benefit> benefits) {
		List<Benefit> realtedBenefit =  (realtedBenefits.containsKey(realtedBenefitDetails)) ? realtedBenefits.get(realtedBenefitDetails) : new ArrayList<>();
		realtedBenefit.addAll(benefits);
		this.realtedBenefits.put(realtedBenefitDetails, realtedBenefit);
	}
}
