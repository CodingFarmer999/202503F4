package model;

public class Tesla {

	private Integer price;
	
	private Engine engine;

	public Tesla() {
		super();
	}
	
	public Tesla(Engine engine) {
		this.engine = engine;
	}
	
	public Tesla(Integer price, Engine engine) {
		super();
		this.price = price;
		this.engine = engine;
	}
	
	public void move() {
		engine.start();
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "Tesla [price=" + price + ", engine=" + engine + "]";
	}
	
	
}
