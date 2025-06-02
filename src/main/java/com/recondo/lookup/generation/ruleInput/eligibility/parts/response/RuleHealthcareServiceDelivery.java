package com.recondo.lookup.generation.ruleInput.eligibility.parts.response;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Represents the HSD segment of a X12 270/271 EDI
 */
public class RuleHealthcareServiceDelivery {
	private String quantityQlfr;
	private String quantityQlfrDesc;
	private Double quantity;

	private String svcUnitCode;
	private String svcUnitCodeDesc;

	private Double sampleSelectionMod;

	private String timePeriodQlfr;
	private String timePeriodQlfrDesc;

	private Short timePeriodCount;

	private String deliveryFrequencyCode;
	private String deliveryFrequencyCodeDesc;

	private String deliveryPatternTimeCode;
	private String deliveryPatternTimeCodeDesc;


	public RuleHealthcareServiceDelivery() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


	public String getQuantityQlfr() {
		return quantityQlfr;
	}
	public void setQuantityQlfr(String quantityQlfr) {
		this.quantityQlfr = quantityQlfr;
	}

	public String getQuantityQlfrDesc() {
		return quantityQlfrDesc;
	}
	public void setQuantityQlfrDesc(String quantityQlfrDesc) {
		this.quantityQlfrDesc = quantityQlfrDesc;
	}

	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getSvcUnitCode() {
		return svcUnitCode;
	}
	public void setSvcUnitCode(String svcUnitCode) {
		this.svcUnitCode = svcUnitCode;
	}

	public String getSvcUnitCodeDesc() {
		return svcUnitCodeDesc;
	}
	public void setSvcUnitCodeDesc(String svcUnitCodeDesc) {
		this.svcUnitCodeDesc = svcUnitCodeDesc;
	}

	public Double getSampleSelectionMod() {
		return sampleSelectionMod;
	}
	public void setSampleSelectionMod(Double sampleSelectionMod) {
		this.sampleSelectionMod = sampleSelectionMod;
	}

	public String getTimePeriodQlfr() {
		return timePeriodQlfr;
	}
	public void setTimePeriodQlfr(String timePeriodQlfr) {
		this.timePeriodQlfr = timePeriodQlfr;
	}

	public String getTimePeriodQlfrDesc() {
		return timePeriodQlfrDesc;
	}
	public void setTimePeriodQlfrDesc(String timePeriodQlfrDesc) {
		this.timePeriodQlfrDesc = timePeriodQlfrDesc;
	}

	public Short getTimePeriodCount() {
		return timePeriodCount;
	}
	public void setTimePeriodCount(Short timePeriodCount) {
		this.timePeriodCount = timePeriodCount;
	}

	public String getDeliveryFrequencyCode() {
		return deliveryFrequencyCode;
	}
	public void setDeliveryFrequencyCode(String deliveryFrequencyCode) {
		this.deliveryFrequencyCode = deliveryFrequencyCode;
	}

	public String getDeliveryFrequencyCodeDesc() {
		return deliveryFrequencyCodeDesc;
	}
	public void setDeliveryFrequencyCodeDesc(String deliveryFrequencyCodeDesc) {
		this.deliveryFrequencyCodeDesc = deliveryFrequencyCodeDesc;
	}

	public String getDeliveryPatternTimeCode() {
		return deliveryPatternTimeCode;
	}
	public void setDeliveryPatternTimeCode(String deliveryPatternTimeCode) {
		this.deliveryPatternTimeCode = deliveryPatternTimeCode;
	}

	public String getDeliveryPatternTimeCodeDesc() {
		return deliveryPatternTimeCodeDesc;
	}
	public void setDeliveryPatternTimeCodeDesc(
			String deliveryPatternTimeCodeDesc) {
		this.deliveryPatternTimeCodeDesc = deliveryPatternTimeCodeDesc;
	}
}
