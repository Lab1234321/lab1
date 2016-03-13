package lab1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Joker on 3/12/16.
 */
public class BeverageProducerMultiTest {
    BeverageProducerMulti bp;

    @Before
    public void setUp() {
        bp = new BeverageProducerMulti();
    }

    @Test
    public void testBeverageProducerMulti() {
        // 再想点测试用例...
        String[] test = {
                "3 espresso small milk milk ; espresso medium milk milk ; mocha grant whip cream",
                "2 espresso medium milk milk ; mocha grant whip cream",
                "2 Mocha small milk milk ; White Tea large Ginger"
                // test cases
        };
        double[] ans = {
        		7.2,
        		5.2,
        		4.6
                // corresponding cost
        };
        double cost;
        for (int i = 0; i < test.length; i++) {
            cost = bp.produce(test[i].toLowerCase().split(" "));
            Assert.assertEquals(ans[i], cost, 0.09);
        }
    }
}
