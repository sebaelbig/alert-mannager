package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.AmtQualCode;

public class AmtQualCodeDeserializer extends StdScalarDeserializer<AmtQualCode> {
	private static final long serialVersionUID = 1L;

	public AmtQualCodeDeserializer() {
		super(AmtQualCode.class);
	}

	@Override
	public AmtQualCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		AmtQualCode amtQualCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			amtQualCode = AmtQualCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			amtQualCode = AmtQualCode.get(text);
		}

		if (amtQualCode == null) {
			throw new RuntimeException("Cannot deserialize AmtQualCode enum");
		}

		return amtQualCode;
	}
}
