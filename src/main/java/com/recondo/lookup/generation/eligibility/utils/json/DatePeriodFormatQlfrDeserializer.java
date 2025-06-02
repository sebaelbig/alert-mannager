package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.DatePeriodFormatQlfr;

public class DatePeriodFormatQlfrDeserializer extends StdScalarDeserializer<DatePeriodFormatQlfr> {
	private static final long serialVersionUID = 1L;

	public DatePeriodFormatQlfrDeserializer() {
		super(DatePeriodFormatQlfr.class);
	}

	@Override
	public DatePeriodFormatQlfr deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		DatePeriodFormatQlfr datePeriodFormatQlfr = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			datePeriodFormatQlfr = DatePeriodFormatQlfr.valueOf(text);
		} catch (IllegalArgumentException e) {
			datePeriodFormatQlfr = DatePeriodFormatQlfr.get(text);
		}

		if (datePeriodFormatQlfr == null) {
			throw new RuntimeException("Cannot deserialize DatePeriodFormatQlfr enum");
		}

		return datePeriodFormatQlfr;
	}
}
