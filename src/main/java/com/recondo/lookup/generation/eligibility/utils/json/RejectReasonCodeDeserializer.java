package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.RejectReasonCode;

public class RejectReasonCodeDeserializer extends StdScalarDeserializer<RejectReasonCode> {
	private static final long serialVersionUID = 1L;

	public RejectReasonCodeDeserializer() {
		super(RejectReasonCode.class);
	}

	@Override
	public RejectReasonCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		RejectReasonCode rejectReasonCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			rejectReasonCode = RejectReasonCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			rejectReasonCode = RejectReasonCode.get(text);
		}

		if (rejectReasonCode == null) {
			throw new RuntimeException("Cannot deserialize RejectReasonCode enum");
		}

		return rejectReasonCode;
	}
}
