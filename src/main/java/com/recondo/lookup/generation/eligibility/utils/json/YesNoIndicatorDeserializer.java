package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.YesNoIndicator;

public class YesNoIndicatorDeserializer extends StdScalarDeserializer<YesNoIndicator> {
	private static final long serialVersionUID = 1L;

	public YesNoIndicatorDeserializer() {
		super(YesNoIndicator.class);
	}

	@Override
	public YesNoIndicator deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		YesNoIndicator yesNoIndicator = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			yesNoIndicator = YesNoIndicator.valueOf(text);
		} catch (IllegalArgumentException e) {
			yesNoIndicator = YesNoIndicator.get(text);
		}

		if (yesNoIndicator == null) {
			throw new RuntimeException("Cannot deserialize YesNoIndicator enum");
		}

		return yesNoIndicator;
	}
}
