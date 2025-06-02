package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.MaintTypeCode;

public class MaintTypeCodeDeserializer extends StdScalarDeserializer<MaintTypeCode> {
	private static final long serialVersionUID = 1L;

	public MaintTypeCodeDeserializer() {
		super(MaintTypeCode.class);
	}

	@Override
	public MaintTypeCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		MaintTypeCode maintTypeCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			maintTypeCode = MaintTypeCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			maintTypeCode = MaintTypeCode.get(text);
		}

		if (maintTypeCode == null) {
			throw new RuntimeException("Cannot deserialize MaintTypeCode enum");
		}

		return maintTypeCode;
	}
}
