package lab1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Febend on 2016/3/19.
 */
public class WhipCreamTest {
    Beverage espresso, decaf, houseBlend;

    @Test
    public void testCost() throws Exception {
        String[] size = {"small", "medium", "large", "grant"};
        double[] costs = {0.4, 0.7, 1, 1.3};
        for (int i = 0; i< size.length;i++){
            espresso = new Espresso();
            ((CoffeeBeverage) espresso).setSize(size[i]);
            espresso = new WhipCream(espresso);
            Assert.assertEquals(costs[i]+1.0+0.3, espresso.cost(), 1.3);
            decaf = new Decaf();
            ((CoffeeBeverage) decaf).setSize(size[i]);
            decaf = new WhipCream(decaf);
            Assert.assertEquals(costs[i]+0.5+0.3, decaf.cost(), 0.8);
            houseBlend = new HouseBlend();
            ((CoffeeBeverage) houseBlend).setSize(size[i]);
            houseBlend = new WhipCream(houseBlend);
            Assert.assertEquals(costs[i]+0.8+0.3, houseBlend.cost(), 1.1);
        }
    }
}