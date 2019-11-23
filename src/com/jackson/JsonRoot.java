package com.jackson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonRoot {
	public static void main(String[] args) throws JsonProcessingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		// readjson
		JsonNode jNode = mapper.readTree(new File("writepatient.JSON"));

		JsonNode name = jNode.get("firstName");
		System.out.println(name.asText());

		// writejson

		JsonNode jwnode = mapper.readTree(new File("writepatient.JSON"));

		ObjectNode objnode = (ObjectNode) jwnode;
		objnode.put("patientNickname", "kasas");
		objnode.putArray("patientweight");
		objnode.withArray("patientweight").add("120");
		objnode.withArray("patientweight").add("100");
		objnode.withArray("patientweight").add("160");
		
		ArrayNode node = objnode.arrayNode();

		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jwnode));
		;
	}
}
