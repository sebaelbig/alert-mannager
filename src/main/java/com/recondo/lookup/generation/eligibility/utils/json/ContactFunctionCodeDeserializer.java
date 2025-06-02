package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.ContactFunctionCode;

public class ContactFunctionCodeDeserializer extends StdScalarDeserializer<ContactFunctionCode> {
	private static final long serialVersionUID = 1L;

	public ContactFunctionCodeDeserializer() {
		super(ContactFunctionCode.class);
	}

	@Override
	public ContactFunctionCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ContactFunctionCode contactFunctionCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			contactFunctionCode = ContactFunctionCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			contactFunctionCode = ContactFunctionCode.get(text);
		}

		if (contactFunctionCode == null) {
			throw new RuntimeException("Cannot deserialize ContactFunctionCode enum");
		}

		return contactFunctionCode;
	}
}
