package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.CvgeLevelCode;

public class CvgeLevelCodeDeserializer extends StdScalarDeserializer<CvgeLevelCode> {
	private static final long serialVersionUID = 1L;

	public CvgeLevelCodeDeserializer() {
		super(CvgeLevelCode.class);
	}

	@Override
	public CvgeLevelCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		CvgeLevelCode cvgeLevelCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			cvgeLevelCode = CvgeLevelCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			cvgeLevelCode = CvgeLevelCode.get(text);
		}

		if (cvgeLevelCode == null) {
			throw new RuntimeException("Cannot deserialize CvgeLevelCode enum");
		}

		return cvgeLevelCode;
	}
}
