package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.InterchangeUsageIndicator;

public class InterchangeUsageIndicatorDeserializer extends StdScalarDeserializer<InterchangeUsageIndicator> {
	private static final long serialVersionUID = 1L;

	public InterchangeUsageIndicatorDeserializer() {
		super(InterchangeUsageIndicator.class);
	}

	@Override
	public InterchangeUsageIndicator deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		InterchangeUsageIndicator interchangeUsageIndicator = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			interchangeUsageIndicator = InterchangeUsageIndicator.valueOf(text);
		} catch (IllegalArgumentException e) {
			interchangeUsageIndicator = InterchangeUsageIndicator.get(text);
		}

		if (interchangeUsageIndicator == null) {
			throw new RuntimeException("Cannot deserialize InterchangeUsageIndicator enum");
		}

		return interchangeUsageIndicator;
	}
}
