package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.TranTypeCode;

public class TranTypeCodeDeserializer extends StdScalarDeserializer<TranTypeCode> {
	private static final long serialVersionUID = 1L;

	public TranTypeCodeDeserializer() {
		super(TranTypeCode.class);
	}

	@Override
	public TranTypeCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		TranTypeCode tranTypeCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			tranTypeCode = TranTypeCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			tranTypeCode = TranTypeCode.get(text);
		}

		if (tranTypeCode == null) {
			throw new RuntimeException("Cannot deserialize TranTypeCode enum");
		}

		return tranTypeCode;
	}
}
