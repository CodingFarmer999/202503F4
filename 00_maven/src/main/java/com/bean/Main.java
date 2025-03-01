package com.bean;

public class Main {

	public static void main(String[] args) {
//		User user= new User();
//		user.setName("");
		
		Toyota toyota = new Toyota(new ToyotaEngine());
		
		
		Toyota toyota2 = new Toyota();
		toyota2.setEngine(new BenzEngine());
		toyota2.move();
	}

}
