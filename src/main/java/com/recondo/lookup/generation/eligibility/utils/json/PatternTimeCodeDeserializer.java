package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.PatternTimeCode;

public class PatternTimeCodeDeserializer extends StdScalarDeserializer<PatternTimeCode> {
	private static final long serialVersionUID = 1L;

	public PatternTimeCodeDeserializer() {
		super(PatternTimeCode.class);
	}

	@Override
	public PatternTimeCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		PatternTimeCode patternTimeCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			patternTimeCode = PatternTimeCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			patternTimeCode = PatternTimeCode.get(text);
		}

		if (patternTimeCode == null) {
			throw new RuntimeException("Cannot deserialize PatternTimeCode enum");
		}

		return patternTimeCode;
	}
}
