package lab1;

/**
 * Created by Joker on 3/12/16.
 */
public class Decaf extends CoffeeBeverage {
    public Decaf() {
        description = "Decaf";
    }

    public double cost() {
        return super.cost() + 0.5;
    }
}
