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
        // 鍐嶆兂鐐规祴璇曠敤渚�...
        String[] test = {
                "espresso small milk milk",
                "espresso medium milk milk",
                "mocha grant whip cream",
                //the test for new drink and new size
                "decaf mocha small milk",
                "decaf mocha grant milk chocolate whip cream"
                // 娴嬭瘯鐢ㄤ緥
        };
        double[] ans = {
                2.0,
                2.3,
                2.9,
                1.5,
                3
                // 瀵瑰簲cost
        };
        Beverage order;
        for (int i = 0; i < test.length; i++) {
            order = bp.produce(test[i].toLowerCase().split(" "));
            Assert.assertEquals(ans[i], order.cost(), 0.09);
        }
    }
}
