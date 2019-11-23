package com.jackson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class JsonParseDemo {
	public static void main(String[] args) throws JsonParseException, IOException {
		JsonFactory fatory = new JsonFactory();
		JsonParser parse = fatory.createParser(new File("writepatient.JSON"));
		
		while(parse.nextToken() != null) {
			JsonToken token = parse.getCurrentToken();
			
			//System.out.println(token);
			if(token.equals(token.FIELD_NAME)) {
				String fieldName = parse.getCurrentName();
				parse.nextToken();
				if("firstName".equals(fieldName)) {
					System.out.println(parse.getValueAsString());
				}
			}
		}
	}
}
