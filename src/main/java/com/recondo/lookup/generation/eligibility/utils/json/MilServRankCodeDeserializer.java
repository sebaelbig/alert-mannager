package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.MilServRankCode;

public class MilServRankCodeDeserializer extends StdScalarDeserializer<MilServRankCode> {
	private static final long serialVersionUID = 1L;

	public MilServRankCodeDeserializer() {
		super(MilServRankCode.class);
	}

	@Override
	public MilServRankCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		MilServRankCode milServRankCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			milServRankCode = MilServRankCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			milServRankCode = MilServRankCode.get(text);
		}

		if (milServRankCode == null) {
			throw new RuntimeException("Cannot deserialize MilServRankCode enum");
		}

		return milServRankCode;
	}
}
