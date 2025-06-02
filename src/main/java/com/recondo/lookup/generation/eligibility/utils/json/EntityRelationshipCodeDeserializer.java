package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.EntityRelationshipCode;

public class EntityRelationshipCodeDeserializer extends StdScalarDeserializer<EntityRelationshipCode> {
	private static final long serialVersionUID = 1L;

	public EntityRelationshipCodeDeserializer() {
		super(EntityRelationshipCode.class);
	}

	@Override
	public EntityRelationshipCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		EntityRelationshipCode entityRelationshipCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			entityRelationshipCode = EntityRelationshipCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			entityRelationshipCode = EntityRelationshipCode.get(text);
		}

		if (entityRelationshipCode == null) {
			throw new RuntimeException("Cannot deserialize EntityRelationshipCode enum");
		}

		return entityRelationshipCode;
	}
}
