package com.course.model.vo;

public class UserVo {

	/** 電子郵件 */
	private String email;
	
	/** 密碼 */
	private String password;
	
	/** 姓名 */
	private String name;
	
	/** 手機 */
	private String mobile;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
