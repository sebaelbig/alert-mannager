package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.DatePeriodQlfr;

public class DatePeriodQlfrDeserializer extends StdScalarDeserializer<DatePeriodQlfr> {
	private static final long serialVersionUID = 1L;

	public DatePeriodQlfrDeserializer() {
		super(DatePeriodQlfr.class);
	}

	@Override
	public DatePeriodQlfr deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		DatePeriodQlfr datePeriodQlfr = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			datePeriodQlfr = DatePeriodQlfr.valueOf(text);
		} catch (IllegalArgumentException e) {
			datePeriodQlfr = DatePeriodQlfr.get(text);
		}

		if (datePeriodQlfr == null) {
			throw new RuntimeException("Cannot deserialize DatePeriodQlfr enum");
		}

		return datePeriodQlfr;
	}
}
