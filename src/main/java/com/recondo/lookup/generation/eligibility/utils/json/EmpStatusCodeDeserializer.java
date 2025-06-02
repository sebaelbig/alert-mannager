package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.EmpStatusCode;

public class EmpStatusCodeDeserializer extends StdScalarDeserializer<EmpStatusCode> {
	private static final long serialVersionUID = 1L;

	public EmpStatusCodeDeserializer() {
		super(EmpStatusCode.class);
	}

	@Override
	public EmpStatusCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		EmpStatusCode empStatusCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			empStatusCode = EmpStatusCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			empStatusCode = EmpStatusCode.get(text);
		}

		if (empStatusCode == null) {
			throw new RuntimeException("Cannot deserialize EmpStatusCode enum");
		}

		return empStatusCode;
	}
}
