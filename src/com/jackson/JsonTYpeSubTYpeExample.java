package com.jackson;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonTYpeSubTYpeExample {
	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		//mapper.enableDefaultTyping();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		Dog dog = new Dog("lacy",12.00);
		Cat cat = new Cat("jon",true, 10);
		
		List<Animal> list = new ArrayList<Animal>();
		list.add(dog);
		list.add(cat);
		
		Zoo zoo= new Zoo();
		zoo.setAnimal(list);
		
		String jsonData = mapper.writeValueAsString(zoo);
		System.out.println(jsonData);
	}
}
