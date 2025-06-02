package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.IndustryCode;

public class IndustryCodeDeserializer extends StdScalarDeserializer<IndustryCode> {
	private static final long serialVersionUID = 1L;

	public IndustryCodeDeserializer() {
		super(IndustryCode.class);
	}

	@Override
	public IndustryCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		IndustryCode industryCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			industryCode = IndustryCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			industryCode = IndustryCode.get(text);
		}

		if (industryCode == null) {
			throw new RuntimeException("Cannot deserialize IndustryCode enum");
		}

		return industryCode;
	}
}
