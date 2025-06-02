package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.GovServAffCode;

public class GovServAffCodeDeserializer extends StdScalarDeserializer<GovServAffCode> {
	private static final long serialVersionUID = 1L;

	public GovServAffCodeDeserializer() {
		super(GovServAffCode.class);
	}

	@Override
	public GovServAffCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		GovServAffCode govServAffCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			govServAffCode = GovServAffCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			govServAffCode = GovServAffCode.get(text);
		}

		if (govServAffCode == null) {
			throw new RuntimeException("Cannot deserialize GovServAffCode enum");
		}

		return govServAffCode;
	}
}
