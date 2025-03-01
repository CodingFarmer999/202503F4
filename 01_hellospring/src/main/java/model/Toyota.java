package model;

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
		engine.start();
	}
}
