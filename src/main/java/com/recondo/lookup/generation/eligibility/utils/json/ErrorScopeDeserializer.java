package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.ErrorScope;

public class ErrorScopeDeserializer extends StdScalarDeserializer<ErrorScope> {
	private static final long serialVersionUID = 1L;

	public ErrorScopeDeserializer() {
		super(ErrorScope.class);
	}

	@Override
	public ErrorScope deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ErrorScope errorScope = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			errorScope = ErrorScope.valueOf(text);
		} catch (IllegalArgumentException e) {
			errorScope = ErrorScope.get(text);
		}

		if (errorScope == null) {
			throw new RuntimeException("Cannot deserialize ErrorScope enum");
		}

		return errorScope;
	}
}
