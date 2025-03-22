package com.course.vo;

public class UserVo {
	
	private Integer id;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String birthDay;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public String toString() {
		return "UserVo [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", birthDay=" + birthDay + "]";
	}
	
	
}
