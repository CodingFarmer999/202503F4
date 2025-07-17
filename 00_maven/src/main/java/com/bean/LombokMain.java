package com.bean;

public class LombokMain {

	public static void main(String[] args) {
		User user1 = new User();
		user1.setId(1L);
		user1.setName("福利蓮");
		
		User user2 = new User();
		user1.setId(2L);
		user2.setName("福利蓮");
		
		System.out.println(user1.equals(user2));
	}

}
