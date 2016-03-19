package lab1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * only to test the cost of different size of tea beverage
 */
public class TeaBeverageTest {

    TeaBeverage teaBeverage;
    @Before
    public void setUp() {
        teaBeverage = new TeaBeverage();
    }

    @Test
    public void testCost() throws Exception {
        String[] size = {"small", "medium", "large", "grant"};
        double[] costs = {0.2, 0.5, 0.7, 0.9};
        for (int i = 0; i < size.length; i++) {
            teaBeverage.setSize(size[i]);
            Assert.assertEquals(costs[i],teaBeverage.cost(),0);
        }
    }
}