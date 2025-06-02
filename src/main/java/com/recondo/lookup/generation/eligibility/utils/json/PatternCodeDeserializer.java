package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.PatternCode;

public class PatternCodeDeserializer extends StdScalarDeserializer<PatternCode> {
	private static final long serialVersionUID = 1L;

	public PatternCodeDeserializer() {
		super(PatternCode.class);
	}

	@Override
	public PatternCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		PatternCode patternCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			patternCode = PatternCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			patternCode = PatternCode.get(text);
		}

		if (patternCode == null) {
			throw new RuntimeException("Cannot deserialize PatternCode enum");
		}

		return patternCode;
	}
}
