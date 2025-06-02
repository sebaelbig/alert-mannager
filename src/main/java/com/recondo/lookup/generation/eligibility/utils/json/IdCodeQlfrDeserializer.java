package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.IdCodeQlfr;

public class IdCodeQlfrDeserializer extends StdScalarDeserializer<IdCodeQlfr> {
	private static final long serialVersionUID = 1L;

	public IdCodeQlfrDeserializer() {
		super(IdCodeQlfr.class);
	}

	@Override
	public IdCodeQlfr deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		IdCodeQlfr idCodeQlfr = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			idCodeQlfr = IdCodeQlfr.valueOf(text);
		} catch (IllegalArgumentException e) {
			idCodeQlfr = IdCodeQlfr.get(text);
		}

		if (idCodeQlfr == null) {
			throw new RuntimeException("Cannot deserialize IdCodeQlfr enum");
		}

		return idCodeQlfr;
	}
}
