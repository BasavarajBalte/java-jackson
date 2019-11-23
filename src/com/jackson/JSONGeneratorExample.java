package com.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONGeneratorExample {
	public static void main(String[] args) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonFactory jfactory = new JsonFactory();
		JsonGenerator jgen = jfactory.createGenerator(System.out);
		jgen.setPrettyPrinter(new DefaultPrettyPrinter());
		//Exception in thread "main" java.lang.IllegalStateException: 
		//No ObjectCodec defined for the generator, 
		//can only serialize simple wrapper types (type passed com.jackson.Patient)
		//above error if not set this
		jgen.setCodec(mapper);
		
		jgen.writeStartObject();
		
		jgen.writeFieldName("name");
		jgen.writeString("raj");
		jgen.writeFieldName("lastname");
		jgen.writeString("B");
		
		jgen.writeStringField("place", "bangalore");
		
		Patient patient = new Patient();
		patient.setCity("bidar");
		patient.setFirstName("basavaraj");
		patient.setLastName("bb");
		jgen.writeObjectField("patient", patient);
		
		jgen.writeEndObject();
		jgen.close();
		
		
	}
}
