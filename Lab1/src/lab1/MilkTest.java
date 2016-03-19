package lab1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Febend on 2016/3/19.
 */
public class MilkTest {
    Beverage espresso, decaf, houseBlend, redTea, greenTea, whiteTea;

    @Test
    public void testCostWithCoffee() throws Exception {
        String[] size = {"small", "medium", "large", "grant"};
        double[] costs = {0.4, 0.7, 1, 1.3};
        for (int i = 0; i< size.length;i++){
            espresso = new Espresso();
            ((CoffeeBeverage) espresso).setSize(size[i]);
            espresso = new Milk(espresso);
            Assert.assertEquals(costs[i]+1.0+0.3, espresso.cost(), 0);
            decaf = new Decaf();
            ((CoffeeBeverage) decaf).setSize(size[i]);
            decaf = new Milk(decaf);
            Assert.assertEquals(costs[i]+0.5+0.3, decaf.cost(), 0);
            houseBlend = new HouseBlend();
            ((CoffeeBeverage) houseBlend).setSize(size[i]);
            houseBlend = new Milk(houseBlend);
            Assert.assertEquals(costs[i]+0.8+0.3, houseBlend.cost(), 0);
        }
    }

    @Test
    public void testCostWithTea() throws Exception {
        String[] size = {"small", "medium", "large", "grant"};
        double[] costs = {0.2, 0.5, 0.7, 0.9};
        for (int i = 0; i< size.length;i++){
            redTea = new RedTea();
            ((TeaBeverage) redTea).setSize(size[i]);
            redTea = new Milk(redTea);
            Assert.assertEquals(costs[i]+0.8+0.3, redTea.cost(), 0);
            greenTea = new GreenTea();
            ((TeaBeverage) greenTea).setSize(size[i]);
            greenTea = new Milk(greenTea);
            Assert.assertEquals(costs[i]+1.0+0.3, greenTea.cost(), 0);
            whiteTea = new WhiteTea();
            ((TeaBeverage) whiteTea).setSize(size[i]);
            whiteTea = new Milk(whiteTea);
            Assert.assertEquals(costs[i]+1.0+0.3, whiteTea.cost(), 0);
        }
    }
}