package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.RespAgencyCode;

public class RespAgencyCodeDeserializer extends StdScalarDeserializer<RespAgencyCode> {
	private static final long serialVersionUID = 1L;

	public RespAgencyCodeDeserializer() {
		super(RespAgencyCode.class);
	}

	@Override
	public RespAgencyCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		RespAgencyCode respAgencyCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			respAgencyCode = RespAgencyCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			respAgencyCode = RespAgencyCode.get(text);
		}

		if (respAgencyCode == null) {
			throw new RuntimeException("Cannot deserialize RespAgencyCode enum");
		}

		return respAgencyCode;
	}
}
