package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.BenefitTypeCode;

public class BenefitTypeCodeDeserializer extends StdScalarDeserializer<BenefitTypeCode> {
	private static final long serialVersionUID = 1L;

	public BenefitTypeCodeDeserializer() {
		super(BenefitTypeCode.class);
	}

	@Override
	public BenefitTypeCode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		BenefitTypeCode benefitTypeCode = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			benefitTypeCode = BenefitTypeCode.valueOf(text);
		} catch (IllegalArgumentException e) {
			benefitTypeCode = BenefitTypeCode.get(text);
		}

		if (benefitTypeCode == null) {
			throw new RuntimeException("Cannot deserialize BenefitTypeCode enum");
		}

		return benefitTypeCode;
	}
}
