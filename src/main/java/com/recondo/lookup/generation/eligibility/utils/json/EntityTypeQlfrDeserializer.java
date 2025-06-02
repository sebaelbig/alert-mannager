package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.EntityTypeQlfr;

public class EntityTypeQlfrDeserializer extends StdScalarDeserializer<EntityTypeQlfr> {
	private static final long serialVersionUID = 1L;

	public EntityTypeQlfrDeserializer() {
		super(EntityTypeQlfr.class);
	}

	@Override
	public EntityTypeQlfr deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		EntityTypeQlfr entityTypeQlfr = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			entityTypeQlfr = EntityTypeQlfr.valueOf(text);
		} catch (IllegalArgumentException e) {
			entityTypeQlfr = EntityTypeQlfr.get(text);
		}

		if (entityTypeQlfr == null) {
			throw new RuntimeException("Cannot deserialize EntityTypeQlfr enum");
		}

		return entityTypeQlfr;
	}
}
