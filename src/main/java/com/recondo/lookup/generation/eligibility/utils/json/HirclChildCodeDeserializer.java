package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.HirclChildCode;

public class HirclChildCodeDeserializer extends StdScalarDeserializer<HirclChildCode> {
	private static final long serialVersionUID = 1L;

	public HirclChildCodeDeserializer() {
		super(HirclChildCode.class);
	}

	@Override
	public HirclChildCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		HirclChildCode hirclChildCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			hirclChildCode = HirclChildCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			hirclChildCode = HirclChildCode.get(text);
		}

		if (hirclChildCode == null) {
			throw new RuntimeException("Cannot deserialize HirclChildCode enum");
		}

		return hirclChildCode;
	}
}
