package se.montag.michael.financial;

import org.junit.Test;

/**
 * Created by mike on 6/24/14.
 */
public class StockQuoteLookupServiceTest {

    @Test
    public void testStockQuoteLookup() {
        System.out.println(new YahooStockQuoteLookupService().getQuote("GOOG").getBid());
        assert(1 == 1);
    }
}
