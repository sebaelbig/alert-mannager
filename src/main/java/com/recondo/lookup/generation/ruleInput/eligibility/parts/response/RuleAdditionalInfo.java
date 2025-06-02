package com.recondo.lookup.generation.ruleInput.eligibility.parts.response;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Represents the III segment of a X12 270/271 EDI
 */
public class RuleAdditionalInfo {
	private String codeListQlfrCode;
	private String codeListQlfrCodeDesc;

	private String industryCode;
	private String industryCodeDesc;

	private String codeCategory;
	private String codeCategoryDesc;

	private String msgText;


	public RuleAdditionalInfo() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


	public String getCodeListQlfrCode() {
		return codeListQlfrCode;
	}
	public void setCodeListQlfrCode(String codeListQlfrCode) {
		this.codeListQlfrCode = codeListQlfrCode;
	}

	public String getCodeListQlfrCodeDesc() {
		return codeListQlfrCodeDesc;
	}
	public void setCodeListQlfrCodeDesc(String codeListQlfrCodeDesc) {
		this.codeListQlfrCodeDesc = codeListQlfrCodeDesc;
	}

	public String getIndustryCode() {
		return industryCode;
	}
	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}

	public String getIndustryCodeDesc() {
		return industryCodeDesc;
	}
	public void setIndustryCodeDesc(String industryCodeDesc) {
		this.industryCodeDesc = industryCodeDesc;
	}

	public String getCodeCategory() {
		return codeCategory;
	}
	public void setCodeCategory(String codeCategory) {
		this.codeCategory = codeCategory;
	}

	public String getCodeCategoryDesc() {
		return codeCategoryDesc;
	}
	public void setCodeCategoryDesc(String codeCategoryDesc) {
		this.codeCategoryDesc = codeCategoryDesc;
	}

	public String getMsgText() {
		return msgText;
	}
	public void setMsgText(String msgText) {
		this.msgText = msgText;
	}
}
