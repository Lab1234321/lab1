package lab1;

public class HouseBlend extends Beverage {
	private String description;
	
	public HouseBlend() {
		description = "HouseBlend";
	}
	
	public String getDescription() {
		return description;
	}

	public double cost() {
		return super.cost() + 0.8;
	}
}
