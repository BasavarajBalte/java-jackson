package com.jackson;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("cat")
public class Cat extends Animal {
	boolean likesCream;
	public int lives;
	public Cat(String name,boolean likesCream, int lives) {
		super(name);
		this.likesCream = likesCream;
		this.lives = lives;
	}
	
}
