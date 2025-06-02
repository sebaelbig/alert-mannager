package com.recondo.lookup.generation.eligibility.parts.response;

import com.recondo.lookup.generation.eligibility.parts.codes.PatternCode;
import com.recondo.lookup.generation.eligibility.parts.codes.PatternTimeCode;
import com.recondo.lookup.generation.eligibility.parts.codes.QtyQlfr;
import com.recondo.lookup.generation.eligibility.parts.codes.SvcUnitCode;
import com.recondo.lookup.generation.eligibility.parts.codes.TimePeriodQlfr;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * Represents the HSD segment of a X12 270/271 EDI
 * 
 * @author Robert.Larivee
 */
public class HealthcareServiceDelivery implements Serializable {
	private static final long serialVersionUID = 1L;

	private QtyQlfr quantityQlfr;
	private String quantityQlfrDesc;
	private Double quantity;

	private SvcUnitCode svcUnitCode;
	private String svcUnitCodeDesc;

	private Double sampleSelectionMod;

	private TimePeriodQlfr timePeriodQlfr;
	private String timePeriodQlfrDesc;

	private Short timePeriodCount;

	private PatternCode deliveryFrequencyCode;
	private String deliveryFrequencyCodeDesc;

	private PatternTimeCode deliveryPatternTimeCode;
	private String deliveryPatternTimeCodeDesc;


	// Must have a default constructor for Jackson to use when parsing JSON
	public HealthcareServiceDelivery() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


	public QtyQlfr getQuantityQlfr() {
		return quantityQlfr;
	}
	public void setQuantityQlfr(QtyQlfr quantityQlfr) {
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

	public SvcUnitCode getSvcUnitCode() {
		return svcUnitCode;
	}
	public void setSvcUnitCode(SvcUnitCode svcUnitCode) {
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

	public TimePeriodQlfr getTimePeriodQlfr() {
		return timePeriodQlfr;
	}
	public void setTimePeriodQlfr(TimePeriodQlfr timePeriodQlfr) {
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

	public PatternCode getDeliveryFrequencyCode() {
		return deliveryFrequencyCode;
	}
	public void setDeliveryFrequencyCode(PatternCode deliveryFrequencyCode) {
		this.deliveryFrequencyCode = deliveryFrequencyCode;
	}

	public String getDeliveryFrequencyCodeDesc() {
		return deliveryFrequencyCodeDesc;
	}
	public void setDeliveryFrequencyCodeDesc(String deliveryFrequencyCodeDesc) {
		this.deliveryFrequencyCodeDesc = deliveryFrequencyCodeDesc;
	}

	public PatternTimeCode getDeliveryPatternTimeCode() {
		return deliveryPatternTimeCode;
	}
	public void setDeliveryPatternTimeCode(PatternTimeCode deliveryPatternTimeCode) {
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
