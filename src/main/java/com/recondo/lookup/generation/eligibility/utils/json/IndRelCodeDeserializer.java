package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.IndRelCode;

public class IndRelCodeDeserializer extends StdScalarDeserializer<IndRelCode> {
	private static final long serialVersionUID = 1L;

	public IndRelCodeDeserializer() {
		super(IndRelCode.class);
	}

	@Override
	public IndRelCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		IndRelCode indRelCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			indRelCode = IndRelCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			indRelCode = IndRelCode.get(text);
		}

		if (indRelCode == null) {
			throw new RuntimeException("Cannot deserialize IndRelCode enum");
		}

		return indRelCode;
	}
}
