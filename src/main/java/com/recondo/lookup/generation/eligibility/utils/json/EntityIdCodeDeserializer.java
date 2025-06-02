package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.EntityIdCode;

public class EntityIdCodeDeserializer extends StdScalarDeserializer<EntityIdCode> {
	private static final long serialVersionUID = 1L;

	public EntityIdCodeDeserializer() {
		super(EntityIdCode.class);
	}

	@Override
	public EntityIdCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		EntityIdCode entityIdCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			entityIdCode = EntityIdCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			entityIdCode = EntityIdCode.get(text);
		}

		if (entityIdCode == null) {
			throw new RuntimeException("Cannot deserialize EntityIdCode enum");
		}

		return entityIdCode;
	}
}
