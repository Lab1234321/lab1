package lab1;

public class BeverageWithIngredient extends Beverage {
	private Beverage drink;

	public BeverageWithIngredient(Beverage drink) {
		this.drink = drink;
		this.description = drink.description;
	}
	
	public double cost() {
		return drink.cost();
	}
}
