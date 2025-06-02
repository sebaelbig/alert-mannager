package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.StudentStatusCode;

public class StudentStatusCodeDeserializer extends StdScalarDeserializer<StudentStatusCode> {
	private static final long serialVersionUID = 1L;

	public StudentStatusCodeDeserializer() {
		super(StudentStatusCode.class);
	}

	@Override
	public StudentStatusCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		StudentStatusCode studentStatusCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			studentStatusCode = StudentStatusCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			studentStatusCode = StudentStatusCode.get(text);
		}

		if (studentStatusCode == null) {
			throw new RuntimeException("Cannot deserialize StudentStatusCode enum");
		}

		return studentStatusCode;
	}
}
