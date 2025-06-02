package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.SvcIdQlfr;

public class SvcIdQlfrDeserializer extends StdScalarDeserializer<SvcIdQlfr> {
	private static final long serialVersionUID = 1L;

	public SvcIdQlfrDeserializer() {
		super(SvcIdQlfr.class);
	}

	@Override
	public SvcIdQlfr deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		SvcIdQlfr svcIdQlfr = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			svcIdQlfr = SvcIdQlfr.valueOf(text);
		} catch (IllegalArgumentException e) {
			svcIdQlfr = SvcIdQlfr.get(text);
		}

		if (svcIdQlfr == null) {
			throw new RuntimeException("Cannot deserialize SvcIdQlfr enum");
		}

		return svcIdQlfr;
	}
}
