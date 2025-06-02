package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.ReleaseIndustryIDCode;

public class ReleaseIndustryIDCodeDeserializer extends StdScalarDeserializer<ReleaseIndustryIDCode> {
	private static final long serialVersionUID = 1L;

	public ReleaseIndustryIDCodeDeserializer() {
		super(ReleaseIndustryIDCode.class);
	}

	@Override
	public ReleaseIndustryIDCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ReleaseIndustryIDCode releaseIndustryIDCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			releaseIndustryIDCode = ReleaseIndustryIDCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			releaseIndustryIDCode = ReleaseIndustryIDCode.get(text);
		}

		if (releaseIndustryIDCode == null) {
			throw new RuntimeException("Cannot deserialize ReleaseIndustryIDCode enum");
		}

		return releaseIndustryIDCode;
	}
}
