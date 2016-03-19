package lab1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * only to test the cost of different size of coffee beverage
 */

public class CoffeeBeverageTest {
    CoffeeBeverage coffeeBeverage;

    @Before
    public void setUp() throws Exception {
        coffeeBeverage = new CoffeeBeverage();
    }

    @Test
    public void testCost(){
        String[] size = {"small", "medium", "large", "grant"};
        double[] costs = {0.4, 0.7, 1, 1.3};
        for (int i = 0; i< size.length;i++){
            coffeeBeverage.setSize(size[i]);
            Assert.assertEquals(costs[i],coffeeBeverage.cost(),0);
        }
    }
}
