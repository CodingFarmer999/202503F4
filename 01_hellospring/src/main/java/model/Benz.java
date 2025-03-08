package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Benz {

	@Autowired
	@Qualifier("kiaEngine")
	private Engine engine;

	public Benz() {

	}

	// @Autowired
	public Benz(Engine engine) {
		super();
		this.engine = engine;
	}

	public Engine getEngine() {
		return engine;
	}

	// @Autowired
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "Benz [engine=" + engine + "]";
	}

	public void move() {
		engine.start();
	}

}
