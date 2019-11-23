package com.jackson;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DateFormat {
	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Patient patient = mapper.readValue(new File("writepatient.JSON"),
					Patient.class);
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-mm-dd");
			Date date = sd.parse(patient.getDateOfBirth());
			
			Event event = new Event(date,"BirthDate");
			mapper.setDateFormat(sd);
			System.out.println("patient birthdate asd: ");
			System.out.println(mapper.writeValueAsString(event));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
