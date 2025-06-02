package com.recondo.lookup.generation.ruleInput;

import com.recondo.lookup.generation.GeneratedAlert;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class RuleResponse {
	private List<GeneratedAlert> generatedAlerts = new ArrayList<>();

	// Must have a default constructor for Jackson to use when parsing JSON
	public RuleResponse() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	public List<GeneratedAlert> getGeneratedAlerts() {
		return generatedAlerts;
	}
	public void setGeneratedAlerts(List<GeneratedAlert> generatedAlerts) {
		this.generatedAlerts = generatedAlerts;
	}
	public void addGeneratedAlert(GeneratedAlert generatedAlert) {
		generatedAlerts.add(generatedAlert);
	}
	public void combineAlerts(RuleResponse ruleResponse) {
		this.generatedAlerts.addAll(ruleResponse.getGeneratedAlerts());
	}
}
