package com.jackson;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.tools.StandardJavaFileManager;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.*;

public class CustomDateSerializer extends StdSerializer<Date> {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm");

	public CustomDateSerializer() {
		this(null);
	}

	public CustomDateSerializer(Class t) {
		super(t);
	}

	@Override
	public void serialize(Date d, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeString(sdf.format(d));

	}

}
