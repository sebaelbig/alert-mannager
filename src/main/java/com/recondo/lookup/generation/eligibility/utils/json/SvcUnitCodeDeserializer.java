package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.SvcUnitCode;

public class SvcUnitCodeDeserializer extends StdScalarDeserializer<SvcUnitCode> {
	private static final long serialVersionUID = 1L;

	public SvcUnitCodeDeserializer() {
		super(SvcUnitCode.class);
	}

	@Override
	public SvcUnitCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		SvcUnitCode svcUnitCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			svcUnitCode = SvcUnitCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			svcUnitCode = SvcUnitCode.get(text);
		}

		if (svcUnitCode == null) {
			throw new RuntimeException("Cannot deserialize SvcUnitCode enum");
		}

		return svcUnitCode;
	}
}
