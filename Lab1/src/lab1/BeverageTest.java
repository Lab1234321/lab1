package lab1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Febend on 2016/3/19.
 */
public class BeverageTest {

    Beverage beverage;

    @Before
    public void setUp() throws Exception {
        beverage = new Beverage();
    }

    @Test
    public void testCost() throws Exception {
        Assert.assertEquals(0, beverage.cost(), 0);
    }
}