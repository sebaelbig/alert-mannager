package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.InfStatusCode;

public class InfStatusCodeDeserializer extends StdScalarDeserializer<InfStatusCode> {
	private static final long serialVersionUID = 1L;

	public InfStatusCodeDeserializer() {
		super(InfStatusCode.class);
	}

	@Override
	public InfStatusCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		InfStatusCode infStatusCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			infStatusCode = InfStatusCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			infStatusCode = InfStatusCode.get(text);
		}

		if (infStatusCode == null) {
			throw new RuntimeException("Cannot deserialize InfStatusCode enum");
		}

		return infStatusCode;
	}
}
