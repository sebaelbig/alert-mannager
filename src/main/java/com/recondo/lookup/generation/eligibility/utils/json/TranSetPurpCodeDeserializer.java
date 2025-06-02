package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.TranSetPurpCode;

public class TranSetPurpCodeDeserializer extends StdScalarDeserializer<TranSetPurpCode> {
	private static final long serialVersionUID = 1L;

	public TranSetPurpCodeDeserializer() {
		super(TranSetPurpCode.class);
	}

	@Override
	public TranSetPurpCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		TranSetPurpCode tranSetPurpCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			tranSetPurpCode = TranSetPurpCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			tranSetPurpCode = TranSetPurpCode.get(text);
		}

		if (tranSetPurpCode == null) {
			throw new RuntimeException("Cannot deserialize TranSetPurpCode enum");
		}

		return tranSetPurpCode;
	}
}
