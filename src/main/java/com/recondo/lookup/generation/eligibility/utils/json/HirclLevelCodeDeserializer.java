package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.HirclLevelCode;

public class HirclLevelCodeDeserializer extends StdScalarDeserializer<HirclLevelCode> {
	private static final long serialVersionUID = 1L;

	public HirclLevelCodeDeserializer() {
		super(HirclLevelCode.class);
	}

	@Override
	public HirclLevelCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		HirclLevelCode hirclLevelCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			hirclLevelCode = HirclLevelCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			hirclLevelCode = HirclLevelCode.get(text);
		}

		if (hirclLevelCode == null) {
			throw new RuntimeException("Cannot deserialize HirclLevelCode enum");
		}

		return hirclLevelCode;
	}
}
