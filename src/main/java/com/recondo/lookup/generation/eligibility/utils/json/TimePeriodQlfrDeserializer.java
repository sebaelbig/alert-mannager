package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.TimePeriodQlfr;

public class TimePeriodQlfrDeserializer extends StdScalarDeserializer<TimePeriodQlfr> {
	private static final long serialVersionUID = 1L;

	public TimePeriodQlfrDeserializer() {
		super(TimePeriodQlfr.class);
	}

	@Override
	public TimePeriodQlfr deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		TimePeriodQlfr timePeriodQlfr = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			timePeriodQlfr = TimePeriodQlfr.valueOf(text);
		} catch (IllegalArgumentException e) {
			timePeriodQlfr = TimePeriodQlfr.get(text);
		}

		if (timePeriodQlfr == null) {
			throw new RuntimeException("Cannot deserialize TimePeriodQlfr enum");
		}

		return timePeriodQlfr;
	}
}
