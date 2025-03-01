package model;

import org.springframework.stereotype.Component;

@Component
public class Benz {
	private Engine engine;
	
	public Benz() {

	}
	
	public Benz(Engine engine) {
		super();
		this.engine = engine;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "Benz [engine=" + engine + "]";
	}
	
	
}
