package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.ServiceTypeCode;

public class ServiceTypeCodeDeserializer extends StdScalarDeserializer<ServiceTypeCode> {
	private static final long serialVersionUID = 1L;

	public ServiceTypeCodeDeserializer() {
		super(ServiceTypeCode.class);
	}

	@Override
	public ServiceTypeCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ServiceTypeCode serviceTypeCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			serviceTypeCode = ServiceTypeCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			serviceTypeCode = ServiceTypeCode.get(text);
		}

		if (serviceTypeCode == null) {
			throw new RuntimeException("Cannot deserialize ServiceTypeCode enum");
		}

		return serviceTypeCode;
	}
}
