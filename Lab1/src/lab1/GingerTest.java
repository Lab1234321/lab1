package lab1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Febend on 2016/3/19.
 */
public class GingerTest {
    Beverage redTea, greenTea, whiteTea;

    @Test
    public void testCostWithTea() throws Exception {
        String[] size = {"small", "medium", "large", "grant"};
        double[] costs = {0.2, 0.5, 0.7, 0.9};
        for (int i = 0; i< size.length;i++){
            redTea = new RedTea();
            ((TeaBeverage) redTea).setSize(size[i]);
            redTea = new Ginger(redTea);
            Assert.assertEquals(costs[i]+0.8+0.6, redTea.cost(),0);
            greenTea = new GreenTea();
            ((TeaBeverage) greenTea).setSize(size[i]);
            greenTea = new Ginger(greenTea);
            Assert.assertEquals(costs[i]+1+0.6, greenTea.cost(), 0);
            whiteTea = new WhiteTea();
            ((TeaBeverage) whiteTea).setSize(size[i]);
            whiteTea = new Ginger(whiteTea);
            Assert.assertEquals(costs[i]+1+0.6, whiteTea.cost(), 0);
        }
    }

}