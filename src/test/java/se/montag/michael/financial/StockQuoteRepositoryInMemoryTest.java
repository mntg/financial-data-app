package se.montag.michael.financial;

import org.junit.Test;

import java.util.List;

/**
 * Created by mike on 6/24/14.
 */
public class StockQuoteRepositoryInMemoryTest {
    @Test
    public void testStockQuoteRepository() {
        StockQuote s1 = new StockQuote("GOOG");
        s1.setBidAsk(12.1,12.4);
        StockQuote s2 = new StockQuote("GOOG");
        s2.setBidAsk(13.0,13.2);
        StockQuoteRepositoryInMemory repo = new StockQuoteRepositoryInMemory();
        repo.save(s1);
        repo.save(s2);


        List<StockQuote> list = repo.getStockQuotes("GOOG");
        List<StockQuote> listNull = repo.getStockQuotes("AAPL");
        assert(listNull == null && list.get(0).getBid() == 12.1 && list.get(0).getAsk() == 12.4 && list.get(1).getBid() == 13.0 && list.get(1).getAsk() == 13.2);
    }
}
