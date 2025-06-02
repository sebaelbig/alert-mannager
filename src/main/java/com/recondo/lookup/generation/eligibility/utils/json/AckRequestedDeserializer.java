package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.AckRequested;

public class AckRequestedDeserializer extends StdScalarDeserializer<AckRequested> {
	private static final long serialVersionUID = 1L;

	public AckRequestedDeserializer() {
		super(AckRequested.class);
	}

	@Override
	public AckRequested deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		AckRequested ackRequested = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			ackRequested = AckRequested.valueOf(text);
		} catch (IllegalArgumentException e) {
			ackRequested = AckRequested.get(text);
		}

		if (ackRequested == null) {
			throw new RuntimeException("Cannot deserialize AckRequested enum");
		}

		return ackRequested;
	}
}
