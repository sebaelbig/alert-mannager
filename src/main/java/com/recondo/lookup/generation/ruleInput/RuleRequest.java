package com.recondo.lookup.generation.ruleInput;

import com.recondo.lookup.generation.providerInterface.ProviderInterface;
// import com.recondo.lookup.generation.ruleInput.eligibility.RuleEligibilityResponse;
// import com.recondo.lookup.generation.ruleInput.eligibility.parts.response.RuleBenefit;

// import com.recondo.lookup.generation.ruleInput.eligibility.RuleEligibilityResponse;
// import com.recondo.lookup.generation.ruleInput.eligibility.parts.response.RuleBenefit;
import com.recondo.lookup.generation.ruleInput.eligibility.RuleEligibilityResponse;
import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class RuleRequest {
	// private Map<String, List<RuleBenefit>> validBenefits = new HashMap<>();
	private String providerCode;
	private String recoPayerId;
	private String regionCode;
	private boolean isSpv;
	private boolean isMedicare;
	private boolean isMedicaid;
	private boolean isOutOfNetwork;
	private String enteredMemberNumber;
	private String memberNumber;
	private String groupNumber;
	private String patientType;
	private String medicalService;
	private String patientState;
	private String patientZip;
	private Date dateOfService;
	private Date dateOfBirth;
	private String genderCode;
	private String subscriberRelationship;
	private RuleEligibilityResponse eligibilityResponse;
	private ProviderInterface providerInterface;
	private List<String> revenueCodes;
	private List<String> procedureCodes;


	public RuleRequest() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	// public Map<String, List<RuleBenefit>> getValidBenefits() {
	// 	return validBenefits;
	// }
	// public void setValidBenefits(Map<String, List<RuleBenefit>> validBenefits) {
	// 	this.validBenefits = validBenefits;
	// }
	// public void addValidBenefits(String scopeName, List<RuleBenefit> newValidBenefits) {
	// 	List<RuleBenefit> currentValidBenefits = this.validBenefits.get(scopeName);
	// 	if (currentValidBenefits == null) {
	// 		this.validBenefits.put(scopeName, newValidBenefits);
	// 	} else {
	// 		currentValidBenefits.addAll(newValidBenefits);
	// 	}
	// }
	// public void addValidBenefit(String scopeName, RuleBenefit newValidBenefit) {
	// 	List<RuleBenefit> currentValidBenefits = this.validBenefits.get(scopeName);
	// 	if (currentValidBenefits == null) {
	// 		List<RuleBenefit> newValidBenefits = new ArrayList<>();
	// 		newValidBenefits.add(newValidBenefit);
	// 		this.validBenefits.put(scopeName, newValidBenefits);
	// 	} else {
	// 		currentValidBenefits.add(newValidBenefit);
	// 	}
	// }

	public boolean getIsSpv(){return isSpv;}
	public boolean getIsMedicare(){return isMedicare;}
	public boolean getIsMedicaid(){return isMedicaid;}
	public boolean getIsOutOfNetwork(){return isOutOfNetwork;}
}
