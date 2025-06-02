package com.recondo.lookup.generation.eligibility.parts.response;

import com.recondo.lookup.generation.eligibility.parts.codes.CodeCategory;
import com.recondo.lookup.generation.eligibility.parts.codes.CodeListQlfrCode;
import com.recondo.lookup.generation.eligibility.parts.codes.IndustryCode;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * Represents the III segment of a X12 270/271 EDI
 *
 * @author Robert.Larivee
 */
public class AdditionalInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private CodeListQlfrCode codeListQlfrCode;
	private String codeListQlfrCodeDesc;

	private IndustryCode industryCode;
	private String industryCodeDesc;

	private CodeCategory codeCategory;
	private String codeCategoryDesc;

	@Size(min = 1, max = 264)
	private String msgText;


	// Must have a default constructor for Jackson to use when parsing JSON
	public AdditionalInfo() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	public CodeListQlfrCode getCodeListQlfrCode() {
		return codeListQlfrCode;
	}
	public void setCodeListQlfrCode(CodeListQlfrCode codeListQlfrCode) {
		this.codeListQlfrCode = codeListQlfrCode;
	}

	public String getCodeListQlfrCodeDesc() {
		return codeListQlfrCodeDesc;
	}
	public void setCodeListQlfrCodeDesc(String codeListQlfrCodeDesc) {
		this.codeListQlfrCodeDesc = codeListQlfrCodeDesc;
	}

	public IndustryCode getIndustryCode() {
		return industryCode;
	}
	public void setIndustryCode(IndustryCode industryCode) {
		this.industryCode = industryCode;
	}

	public String getIndustryCodeDesc() {
		return industryCodeDesc;
	}
	public void setIndustryCodeDesc(String industryCodeDesc) {
		this.industryCodeDesc = industryCodeDesc;
	}

	public CodeCategory getCodeCategory() {
		return codeCategory;
	}
	public void setCodeCategory(CodeCategory codeCategory) {
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
