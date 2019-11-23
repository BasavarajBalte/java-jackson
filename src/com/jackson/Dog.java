package com.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonInclude(value = Include.NON_NULL)
@JsonTypeName("dog")
public class Dog extends Animal {
	public double barkVolum;

	public Dog(String name,double barkVolum) {
		super(name);
		this.barkVolum = barkVolum;
	}
	
}
