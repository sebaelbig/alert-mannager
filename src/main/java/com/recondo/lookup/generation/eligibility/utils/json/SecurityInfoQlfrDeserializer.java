package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.SecurityInfoQlfr;

public class SecurityInfoQlfrDeserializer extends StdScalarDeserializer<SecurityInfoQlfr> {
	private static final long serialVersionUID = 1L;

	public SecurityInfoQlfrDeserializer() {
		super(SecurityInfoQlfr.class);
	}

	@Override
	public SecurityInfoQlfr deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		SecurityInfoQlfr securityInfoQlfr = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			securityInfoQlfr = SecurityInfoQlfr.valueOf(text);
		} catch (IllegalArgumentException e) {
			securityInfoQlfr = SecurityInfoQlfr.get(text);
		}

		if (securityInfoQlfr == null) {
			throw new RuntimeException("Cannot deserialize SecurityInfoQlfr enum");
		}

		return securityInfoQlfr;
	}
}
