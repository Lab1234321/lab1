package lab1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Joker on 3/12/16.
 */
public class BeverageProducerTest {
    BeverageProducer bp;

    @Before
    public void setUp() {
        bp = new BeverageProducer();
    }

    @Test
    public void testBeverageProducer() {
        // 再想点测试用例...
        String[] test = {
                "espresso small milk milk",
                "espresso medium milk milk",
                "mocha grant whip cream",
                // 测试用例
        };
        double[] ans = {
                2.0,
                2.3,
                2.9,
                // 对应cost
        };
        Beverage order;
        for (int i = 0; i < test.length; i++) {
            order = bp.produce(test[i].toLowerCase().split(" "));
            Assert.assertEquals(ans[i], order.cost(), 0.09);
        }
    }
}
