package lab1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * test the cost of beverage with ingredient.
 */
public class BeverageWithIngredientTest {

    BeverageWithIngredient bwic, bwit;
    CoffeeBeverage coffeeBeverage;
    TeaBeverage teaBeverage;
    @Before
    public void setUp() throws Exception {
        coffeeBeverage = new CoffeeBeverage();
        teaBeverage = new TeaBeverage();
    }

    @Test
    public void testCost() throws Exception {
        String[] size = {"small", "medium", "large", "grant"};
        double[] cCosts = {0.4, 0.7, 1, 1.3};
        double[] tCosts = {0.2, 0.5, 0.7, 0.9};
        for (int i = 0; i < size.length; i++){
            coffeeBeverage.setSize(size[i]);
            teaBeverage.setSize(size[i]);
            bwic = new BeverageWithIngredient(coffeeBeverage);
            bwit = new BeverageWithIngredient(teaBeverage);
            Assert.assertEquals(cCosts[i], bwic.cost(), 0);
            Assert.assertEquals(tCosts[i], bwit.cost(), 0);
        }
    }
}