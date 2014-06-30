package se.montag.michael.financial;

import org.joda.time.DateTime;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertNotEquals;

/**
 * Created by mike on 6/22/14.
 */
public class StockQuoteTest {

    @Test
    public void testGetQuote() {
        StockQuote s = new StockQuote("GOOG",5,6,new DateTime());
        assert(s.getBid() == 5 && s.getAsk() == 6);
    }

}
