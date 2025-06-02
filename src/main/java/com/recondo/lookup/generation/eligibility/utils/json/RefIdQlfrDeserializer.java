package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.RefIdQlfr;

public class RefIdQlfrDeserializer extends StdScalarDeserializer<RefIdQlfr> {
	private static final long serialVersionUID = 1L;

	public RefIdQlfrDeserializer() {
		super(RefIdQlfr.class);
	}

	@Override
	public RefIdQlfr deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		RefIdQlfr refIdQlfr = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			refIdQlfr = RefIdQlfr.valueOf(text);
		} catch (IllegalArgumentException e) {
			refIdQlfr = RefIdQlfr.get(text);
		}

		if (refIdQlfr == null) {
			throw new RuntimeException("Cannot deserialize RefIdQlfr enum");
		}

		return refIdQlfr;
	}
}
