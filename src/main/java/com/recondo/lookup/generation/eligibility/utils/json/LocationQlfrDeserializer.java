package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.LocationQlfr;

public class LocationQlfrDeserializer extends StdScalarDeserializer<LocationQlfr> {
	private static final long serialVersionUID = 1L;

	public LocationQlfrDeserializer() {
		super(LocationQlfr.class);
	}

	@Override
	public LocationQlfr deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		LocationQlfr locationQlfr = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			locationQlfr = LocationQlfr.valueOf(text);
		} catch (IllegalArgumentException e) {
			locationQlfr = LocationQlfr.get(text);
		}

		if (locationQlfr == null) {
			throw new RuntimeException("Cannot deserialize LocationQlfr enum");
		}

		return locationQlfr;
	}
}
