package lab1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Febend on 2016/3/19.
 */
public class HouseBlendTest {

    HouseBlend houseBlend;

    @Before
    public void setUp() throws Exception {
        houseBlend = new HouseBlend();
    }

    @Test
    public void testCost() throws Exception {
        String[] size = {"small", "medium", "large", "grant"};
        double[] cost = {0.4, 0.7, 1, 1.3};
        for (int i = 0; i < size.length; i++) {
            cost[i] += 0.8;
            houseBlend.setSize(size[i]);
            Assert.assertEquals(cost[i], houseBlend.cost(), 0);
        }
    }
}