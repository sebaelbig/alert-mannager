package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.ProvCode;

public class ProvCodeDeserializer extends StdScalarDeserializer<ProvCode> {
	private static final long serialVersionUID = 1L;

	public ProvCodeDeserializer() {
		super(ProvCode.class);
	}

	@Override
	public ProvCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ProvCode provCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			provCode = ProvCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			provCode = ProvCode.get(text);
		}

		if (provCode == null) {
			throw new RuntimeException("Cannot deserialize ProvCode enum");
		}

		return provCode;
	}
}
