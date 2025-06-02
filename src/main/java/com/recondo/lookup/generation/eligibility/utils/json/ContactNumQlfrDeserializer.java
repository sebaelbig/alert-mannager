package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.ContactNumQlfr;

public class ContactNumQlfrDeserializer extends StdScalarDeserializer<ContactNumQlfr> {
	private static final long serialVersionUID = 1L;

	public ContactNumQlfrDeserializer() {
		super(ContactNumQlfr.class);
	}

	@Override
	public ContactNumQlfr deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ContactNumQlfr contactNumQlfr = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			contactNumQlfr = ContactNumQlfr.valueOf(text);
		} catch (IllegalArgumentException e) {
			contactNumQlfr = ContactNumQlfr.get(text);
		}

		if (contactNumQlfr == null) {
			throw new RuntimeException("Cannot deserialize ContactNumQlfr enum");
		}

		return contactNumQlfr;
	}
}
