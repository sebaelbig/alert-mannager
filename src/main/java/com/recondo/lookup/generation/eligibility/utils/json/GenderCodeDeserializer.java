package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.GenderCode;

public class GenderCodeDeserializer extends StdScalarDeserializer<GenderCode> {
	private static final long serialVersionUID = 1L;

	public GenderCodeDeserializer() {
		super(GenderCode.class);
	}

	@Override
	public GenderCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		GenderCode genderCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			genderCode = GenderCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			genderCode = GenderCode.get(text);
		}

		if (genderCode == null) {
			throw new RuntimeException("Cannot deserialize GenderCode enum");
		}

		return genderCode;
	}
}
