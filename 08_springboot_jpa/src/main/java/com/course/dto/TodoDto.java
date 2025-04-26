package com.course.dto;

public class TodoDto {

	private String username;

	public TodoDto() {
	}
	
	public TodoDto(String username) {
		super();
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
