package com.recondo.lookup.generation.eligibility.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdScalarSerializer;
import com.recondo.lookup.generation.eligibility.parts.codes.CodeEnum;

public class CodeEnumSerializer extends StdScalarSerializer<CodeEnum> {
	public CodeEnumSerializer() {
		super(Enum.class, false);
	}

	@Override
	public void serialize(CodeEnum value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
		jgen.writeString(value.getCode());
	}
}