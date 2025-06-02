package com.recondo.lookup.generation.ruleInput.eligibility.parts.response;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.UUID;

/**
 * Holds data identifying the location of substantiated data from payer responses
 */
public class RuleSubstantiation {
	private UUID substantiationUUID;
	private String source;
	private String locator;
	private String text;

	private String mediaType;
	private String substantiationType;


	public RuleSubstantiation() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


	public UUID getSubstantiationUUID() {
		return substantiationUUID;
	}
	public void setSubstantiationUUID(UUID substantiationUUID) {
		this.substantiationUUID = substantiationUUID;
	}

	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}

	public String getLocator() {
		return locator;
	}
	public void setLocator(String locator) {
		this.locator = locator;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getSubstantiationType() {
		return substantiationType;
	}
	public void setSubstantiationType(String substantiationType) {
		this.substantiationType = substantiationType;
	}
}
