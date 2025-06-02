package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.MaintReasonCode;

public class MaintReasonCodeDeserializer extends StdScalarDeserializer<MaintReasonCode> {
	private static final long serialVersionUID = 1L;

	public MaintReasonCodeDeserializer() {
		super(MaintReasonCode.class);
	}

	@Override
	public MaintReasonCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		MaintReasonCode maintReasonCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			maintReasonCode = MaintReasonCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			maintReasonCode = MaintReasonCode.get(text);
		}

		if (maintReasonCode == null) {
			throw new RuntimeException("Cannot deserialize MaintReasonCode enum");
		}

		return maintReasonCode;
	}
}
