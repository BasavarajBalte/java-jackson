package com.jackson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFormatMain {
	public static void main(String[] args) throws ParseException, JsonProcessingException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String toparse = "20-12-2018";
		Date date = sdf.parse(toparse);
		
		JsonFormatExample example = new JsonFormatExample("party",date);
		System.out.println(new ObjectMapper().writeValueAsString(example));
	}
}
