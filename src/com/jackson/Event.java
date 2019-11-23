package com.jackson;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Event {
	private String name;
	
	/*
	 * @JsonFormat(shape = Shape.STRING,pattern = "yyyy-mm-dd hh:mm") private String
	 * birthDate;
	 */
	//custom date serializer
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date birthDate;
	
	public Event(Date birthDate,String name) {
		this.birthDate = birthDate;
		this.name = name;
	}
}
