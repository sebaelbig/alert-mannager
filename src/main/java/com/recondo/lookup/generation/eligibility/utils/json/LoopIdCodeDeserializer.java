package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.LoopIdCode;

public class LoopIdCodeDeserializer extends StdScalarDeserializer<LoopIdCode> {
	private static final long serialVersionUID = 1L;

	public LoopIdCodeDeserializer() {
		super(LoopIdCode.class);
	}

	@Override
	public LoopIdCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		LoopIdCode loopIdCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			loopIdCode = LoopIdCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			loopIdCode = LoopIdCode.get(text);
		}

		if (loopIdCode == null) {
			throw new RuntimeException("Cannot deserialize LoopIdCode enum");
		}

		return loopIdCode;
	}
}
