package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.AuthInfoQlfr;

public class AuthInfoQlfrDeserializer extends StdScalarDeserializer<AuthInfoQlfr> {
	private static final long serialVersionUID = 1L;

	public AuthInfoQlfrDeserializer() {
		super(AuthInfoQlfr.class);
	}

	@Override
	public AuthInfoQlfr deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		AuthInfoQlfr authInfoQlfr = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			authInfoQlfr = AuthInfoQlfr.valueOf(text);
		} catch (IllegalArgumentException e) {
			authInfoQlfr = AuthInfoQlfr.get(text);
		}

		if (authInfoQlfr == null) {
			throw new RuntimeException("Cannot deserialize AuthInfoQlfr enum");
		}

		return authInfoQlfr;
	}
}
