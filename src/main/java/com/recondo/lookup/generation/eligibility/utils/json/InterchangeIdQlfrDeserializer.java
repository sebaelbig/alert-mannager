package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.InterchangeIdQlfr;

public class InterchangeIdQlfrDeserializer extends StdScalarDeserializer<InterchangeIdQlfr> {
	private static final long serialVersionUID = 1L;

	public InterchangeIdQlfrDeserializer() {
		super(InterchangeIdQlfr.class);
	}

	@Override
	public InterchangeIdQlfr deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		InterchangeIdQlfr interchangeIdQlfr = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			interchangeIdQlfr = InterchangeIdQlfr.valueOf(text);
		} catch (IllegalArgumentException e) {
			interchangeIdQlfr = InterchangeIdQlfr.get(text);
		}

		if (interchangeIdQlfr == null) {
			throw new RuntimeException("Cannot deserialize InterchangeIdQlfr enum");
		}

		return interchangeIdQlfr;
	}
}
