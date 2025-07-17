package com.bean;

public class Toyota {

	/**	引擎 */
	private Engine engine;
	
	public Toyota() {
		
	}
	
	/**
	 * Constructor 注入
	 * @param engine
	 */
	public Toyota(Engine engine) {
		this.engine = engine;
	}
	
	/**
	 * Setter 注入
	 * @param engine
	 */
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void move() {
		// 在 Toyota 類別當中，直接 new ToyotaEngine，Toyota 依賴於 ToyotaEngine
		// ToyotaEngine engine = new ToyotaEngine();

		engine.start();
	}
}
