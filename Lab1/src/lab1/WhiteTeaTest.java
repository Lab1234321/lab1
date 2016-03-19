package lab1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Febend on 2016/3/19.
 */
public class WhiteTeaTest {

    WhiteTea whiteTea;

    @Before
    public void setUp() throws Exception {
        whiteTea = new WhiteTea();
    }

    @Test
    public void testCost() throws Exception {
        String[] size = {"small", "medium", "large", "grant"};
        double[] cost = {0.2, 0.5, 0.7, 0.9};
        for (int i = 0; i < size.length; i++) {
            whiteTea.setSize(size[i]);
            Assert.assertEquals(cost[i]+1.0, whiteTea.cost(),0);
        }
    }
}