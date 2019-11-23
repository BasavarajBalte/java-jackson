package com.jackson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JavaToJackson {
	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);//print in format
		try {
			Patient patient = new Patient();
			patient.setFirstName("raj");
			patient.setLastName("B");
			patient.setCity("Bangalore");
			patient.setAddress("Jp nagar");
			patient.setDateOfBirth("2019-11-22");
			patient.setPhone("9886283409");
			patient.setState("karnataka");
			patient.setZip("abc.zip");
			
			mapper.writeValue(new File("writepatient.JSON"), patient);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
