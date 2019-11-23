package com.jackson;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JacksonToJava {
	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			Patient patient = mapper.readValue(new File("writepatient.JSON"),Patient.class);
			System.out.println(patient.getFirstName());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
