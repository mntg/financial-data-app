package se.montag.michael.financial;

import org.junit.Test;

import java.util.HashMap;

/**
 * Created by mike on 6/22/14.
 */
public class StockQuoteTest {

    @Test
    public void testGetQuote() {
        StockQuote s = new StockQuote("GOOG");
        s.setBidAsk(5, 6);
        assert(s.getBid() == 5 && s.getAsk() == 6);
    }

    @Test
    public void testEquals() {
        StockQuote s1 = new StockQuote("GOOG");
        s1.setBidAsk(5, 6);
        StockQuote s2 = new StockQuote("GOOG");
        s2.setBidAsk(5, 6);
        assert(!s1.equals(s2));
    }

    @Test
    public void testHashCode() {
        StockQuote s1 = new StockQuote("GOOG");
        s1.setBidAsk(5, 6);
        StockQuote s2 = new StockQuote("AAPL");
        s2.setBidAsk(21.2, 22);
        HashMap<String, StockQuote> map = new HashMap<String, StockQuote>();
        map.put(s1.getSymbol(), s1);
        map.put(s2.getSymbol(), s2);
        assert (map.get("GOOG").equals(s1) && map.get("AAPL").equals(s2));
    }
}
