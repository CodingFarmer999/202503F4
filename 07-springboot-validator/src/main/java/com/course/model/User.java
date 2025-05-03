package com.course.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class User {

	@NotBlank
	@Size(min = 8 , max = 20, message = "使用者名稱長度需介於 8 ~ 20 碼" )
	private String username;
	
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "密碼只能輸入英數字")
	private String password;
	
	@Min(value = 18)
	private Integer age;
	
	@Email(message = "Email 格式不正確")
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
