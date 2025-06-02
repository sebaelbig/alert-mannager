package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.HirclStructCode;

public class HirclStructCodeDeserializer extends StdScalarDeserializer<HirclStructCode> {
	private static final long serialVersionUID = 1L;

	public HirclStructCodeDeserializer() {
		super(HirclStructCode.class);
	}

	@Override
	public HirclStructCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		HirclStructCode hirclStructCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			hirclStructCode = HirclStructCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			hirclStructCode = HirclStructCode.get(text);
		}

		if (hirclStructCode == null) {
			throw new RuntimeException("Cannot deserialize HirclStructCode enum");
		}

		return hirclStructCode;
	}
}
