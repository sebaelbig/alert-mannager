package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.InsurTypeCode;

public class InsurTypeCodeDeserializer extends StdScalarDeserializer<InsurTypeCode> {
	private static final long serialVersionUID = 1L;

	public InsurTypeCodeDeserializer() {
		super(InsurTypeCode.class);
	}

	@Override
	public InsurTypeCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		InsurTypeCode insurTypeCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			insurTypeCode = InsurTypeCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			insurTypeCode = InsurTypeCode.get(text);
		}

		if (insurTypeCode == null) {
			throw new RuntimeException("Cannot deserialize InsurTypeCode enum");
		}

		return insurTypeCode;
	}
}
