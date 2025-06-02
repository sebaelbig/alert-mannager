package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.CodeCategory;

public class CodeCategoryDeserializer extends StdScalarDeserializer<CodeCategory> {
	private static final long serialVersionUID = 1L;

	public CodeCategoryDeserializer() {
		super(CodeCategory.class);
	}

	@Override
	public CodeCategory deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		CodeCategory codeCategory = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			codeCategory = CodeCategory.valueOf(text);
		} catch (IllegalArgumentException e) {
			codeCategory = CodeCategory.get(text);
		}

		if (codeCategory == null) {
			throw new RuntimeException("Cannot deserialize CodeCategory enum");
		}

		return codeCategory;
	}
}
