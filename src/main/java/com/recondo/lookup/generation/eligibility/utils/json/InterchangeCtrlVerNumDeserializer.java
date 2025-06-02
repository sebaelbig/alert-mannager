package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.InterchangeCtrlVerNum;

public class InterchangeCtrlVerNumDeserializer extends StdScalarDeserializer<InterchangeCtrlVerNum> {
	private static final long serialVersionUID = 1L;

	public InterchangeCtrlVerNumDeserializer() {
		super(InterchangeCtrlVerNum.class);
	}

	@Override
	public InterchangeCtrlVerNum deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		InterchangeCtrlVerNum interchangeCtrlVerNum = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			interchangeCtrlVerNum = InterchangeCtrlVerNum.valueOf(text);
		} catch (IllegalArgumentException e) {
			interchangeCtrlVerNum = InterchangeCtrlVerNum.get(text);
		}

		if (interchangeCtrlVerNum == null) {
			throw new RuntimeException("Cannot deserialize InterchangeCtrlVerNum enum");
		}

		return interchangeCtrlVerNum;
	}
}
