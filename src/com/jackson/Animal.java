package com.jackson;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = Dog.class, name = "dog"),
		@Type(value = Cat.class, name = "cat"), })
public abstract class Animal {
	public String name;
	
	public Animal(String name) {
		this.name = name;
	}
}
