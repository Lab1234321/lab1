package lab1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Febend on 2016/3/19.
 */
public class DecafTest {

    Decaf decaf;

    @Before
    public void setUp() throws Exception {
        decaf = new Decaf();
    }

    @Test
    public void testCost() throws Exception {
        String[] size = {"small", "medium", "large", "grant"};
        double[] cost = {0.4, 0.7, 1, 1.3};
        for (int i = 0; i < size.length; i++) {
            decaf.setSize(size[i]);
            Assert.assertEquals(cost[i]+0.5, decaf.cost(), 0);
        }
    }
}