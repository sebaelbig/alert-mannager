package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.TransSetIdCode;

public class TransSetIdCodeDeserializer extends StdScalarDeserializer<TransSetIdCode> {
	private static final long serialVersionUID = 1L;

	public TransSetIdCodeDeserializer() {
		super(TransSetIdCode.class);
	}

	@Override
	public TransSetIdCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		TransSetIdCode transSetIdCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			transSetIdCode = TransSetIdCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			transSetIdCode = TransSetIdCode.get(text);
		}

		if (transSetIdCode == null) {
			throw new RuntimeException("Cannot deserialize TransSetIdCode enum");
		}

		return transSetIdCode;
	}
}
