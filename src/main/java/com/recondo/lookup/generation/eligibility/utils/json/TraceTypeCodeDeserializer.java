package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.TraceTypeCode;

public class TraceTypeCodeDeserializer extends StdScalarDeserializer<TraceTypeCode> {
	private static final long serialVersionUID = 1L;

	public TraceTypeCodeDeserializer() {
		super(TraceTypeCode.class);
	}

	@Override
	public TraceTypeCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		TraceTypeCode traceTypeCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			traceTypeCode = TraceTypeCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			traceTypeCode = TraceTypeCode.get(text);
		}

		if (traceTypeCode == null) {
			throw new RuntimeException("Cannot deserialize TraceTypeCode enum");
		}

		return traceTypeCode;
	}
}
