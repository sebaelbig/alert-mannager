package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.FollowUpActionCode;

public class FollowUpActionCodeDeserializer extends StdScalarDeserializer<FollowUpActionCode> {
	private static final long serialVersionUID = 1L;

	public FollowUpActionCodeDeserializer() {
		super(FollowUpActionCode.class);
	}

	@Override
	public FollowUpActionCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		FollowUpActionCode followUpActionCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			followUpActionCode = FollowUpActionCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			followUpActionCode = FollowUpActionCode.get(text);
		}

		if (followUpActionCode == null) {
			throw new RuntimeException("Cannot deserialize FollowUpActionCode enum");
		}

		return followUpActionCode;
	}
}
