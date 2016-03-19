package lab1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * test the cost of beverage with ingredient.
 * haven't finished 3/19
 */
public class BeverageWithIngredientTest {

    BeverageWithIngredient bwic, bwit;
    CoffeeBeverage coffeeBeverage;
    TeaBeverage teaBeverage;
    @Before
    public void setUp() throws Exception {
        coffeeBeverage = new CoffeeBeverage();
        teaBeverage = new TeaBeverage();
        bwic = new BeverageWithIngredient(coffeeBeverage);
        bwit = new BeverageWithIngredient(teaBeverage);
    }

    @Test
    public void testCost() throws Exception {
        String[] size = {"small", "medium", "large", "grant"};
        double[] cCosts = {};
    }
}