package com.jackson;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class JsonFormatExample {
	public JsonFormatExample(String name, Date date) {
		this.name = name;
		this.eventDate = date;
	}

	private String name;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
	public Date eventDate;
}
