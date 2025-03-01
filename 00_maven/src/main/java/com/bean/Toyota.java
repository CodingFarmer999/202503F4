package com.bean;

public class Toyota {

	Engine engine;
	
	public Toyota() {
		super();
	}
	
	public Toyota(Engine engine) {
		super();
		this.engine = engine;
	}
	
	public void setEngine(Engine engine) {
		this.engine = engine;
	}



	public void move() {
		// go
//		ToyotaEngine engine = new ToyotaEngine();
//		engine.start();
		
		engine.start();
	}
}
