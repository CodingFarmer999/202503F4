package com.bean;

public class Main {

	public static void main(String[] args) {
		
		// 建構式注入
		Toyota toyota = new Toyota(new ToyotaEngine());
		toyota.move();
		
		Toyota toyota2 = new Toyota();
		// Setter 注入
		toyota2.setEngine(new BenzEngine());
		toyota2.move();
	}

}
