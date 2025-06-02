package com.recondo.lookup.generation.eligibility.parts;

import com.recondo.lookup.generation.eligibility.parts.codes.RefIdQlfr;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Represents the REF segment of a X12 270/271 EDI
 * 
 * @author Robert.Larivee
 */
public class Ref implements Serializable {
	private static final long serialVersionUID = 1L;

	private RefIdQlfr refIdQlfr;
	private String refIdQlfrDesc;
	@Size(min = 1, max = 50)
	private String refId;

	@Size(min = 1, max = 80)
	private String description;


	// Must have a default constructor for Jackson to use when parsing JSON
	public Ref() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


	public RefIdQlfr getRefIdQlfr() {
		return refIdQlfr;
	}
	public void setRefIdQlfr(RefIdQlfr refIdQlfr) {
		this.refIdQlfr = refIdQlfr;
	}

	public String getRefIdQlfrDesc() {
		return refIdQlfrDesc;
	}
	public void setRefIdQlfrDesc(String refIdQlfrDesc) {
		this.refIdQlfrDesc = refIdQlfrDesc;
	}

	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
