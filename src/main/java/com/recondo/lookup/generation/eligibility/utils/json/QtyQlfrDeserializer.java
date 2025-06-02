package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.recondo.lookup.generation.eligibility.parts.codes.QtyQlfr;

public class QtyQlfrDeserializer extends StdScalarDeserializer<QtyQlfr> {
	private static final long serialVersionUID = 1L;

	public QtyQlfrDeserializer() {
		super(QtyQlfr.class);
	}

	@Override
	public QtyQlfr deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		QtyQlfr qtyQlfr = null;

		String text = jp.getText();

		// We either have the name or the code.
		try {
			qtyQlfr = QtyQlfr.valueOf(text);
		} catch (IllegalArgumentException e) {
			qtyQlfr = QtyQlfr.get(text);
		}

		if (qtyQlfr == null) {
			throw new RuntimeException("Cannot deserialize QtyQlfr enum");
		}

		return qtyQlfr;
	}
}
