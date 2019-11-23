package com.jackson;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

class Hospital {
	public Doctor doctor;

	public Hospital() {
	}
}

@JsonDeserialize(as = Nurse.class)
abstract class Doctor {
	public String name;

	public Doctor() {
	}
}

class Nurse extends Doctor {
	public int npiNumber;

	public Nurse() {
	}
}

@JsonRootName(value="user")
class User {
	public int id;
	public String name;

	public User() {
	}

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}

public class JacksonExceptionExamp {
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		jackson1();
		jackson2();
		jackson3();
	}

	static ObjectMapper mapper = new ObjectMapper();

	public static void jackson1() throws JsonMappingException, JsonProcessingException {
		String json = "{\"doctor\":{\"name\":\"jane\"}}";
		Hospital hospital = mapper.reader().forType(Hospital.class).readValue(json);
		System.out.println(hospital.doctor.name.toString());
	}

	public static void jackson2() throws JsonMappingException, JsonProcessingException {
		String json = "{\"id\":12,\"name\":\"test\"}";
		User user = mapper.readValue(json, User.class);
		System.out.println(user.name.toString());
	}
	
	public static void jackson3() throws JsonMappingException, JsonProcessingException {
		String json = "{\"user\":{\"id\":12,\"name\":\"jon\"}}";
		mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
		User user = mapper.readValue(json, User.class);
		System.out.println(user.name.toString());
	}
//https://www.baeldung.com/jackson-exception
	//https://www.baeldung.com/jackson-annotations
}
