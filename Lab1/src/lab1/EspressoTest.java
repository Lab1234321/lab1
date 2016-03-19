package lab1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * test the cost of espresso
 */
public class EspressoTest {
    Espresso espresso;

    @Before
    public void setUp() throws Exception {
        espresso = new Espresso();
    }

    @Test
    public void testCost() throws Exception {
        String[] size = {"small", "medium", "large", "grant"};
        double[] cost = {0.4, 0.7, 1, 1.3};
        for (int i = 0; i < size.length; i++) {
            espresso.setSize(size[i]);
            Assert.assertEquals(cost[i]+1.0, espresso.cost(), 0);
        }
    }
}