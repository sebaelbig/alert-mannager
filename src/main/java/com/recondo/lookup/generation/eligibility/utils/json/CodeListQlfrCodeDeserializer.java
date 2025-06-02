package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.CodeListQlfrCode;

public class CodeListQlfrCodeDeserializer extends StdScalarDeserializer<CodeListQlfrCode> {
	private static final long serialVersionUID = 1L;

	public CodeListQlfrCodeDeserializer() {
		super(CodeListQlfrCode.class);
	}

	@Override
	public CodeListQlfrCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		CodeListQlfrCode codeListQlfrCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			codeListQlfrCode = CodeListQlfrCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			codeListQlfrCode = CodeListQlfrCode.get(text);
		}

		if (codeListQlfrCode == null) {
			throw new RuntimeException("Cannot deserialize CodeListQlfrCode enum");
		}

		return codeListQlfrCode;
	}
}
