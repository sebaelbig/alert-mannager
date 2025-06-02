package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.ImplConRef;

public class ImplConRefDeserializer extends StdScalarDeserializer<ImplConRef> {
	private static final long serialVersionUID = 1L;

	public ImplConRefDeserializer() {
		super(ImplConRef.class);
	}

	@Override
	public ImplConRef deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ImplConRef implConRef = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			implConRef = ImplConRef.valueOf(text);
		} catch (IllegalArgumentException e) {
			implConRef = ImplConRef.get(text);
		}

		if (implConRef == null) {
			throw new RuntimeException("Cannot deserialize ImplConRef enum");
		}

		return implConRef;
	}
}
