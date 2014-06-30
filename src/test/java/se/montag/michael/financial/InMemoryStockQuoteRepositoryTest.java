package se.montag.michael.financial;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by mike on 6/24/14.
 */
public class InMemoryStockQuoteRepositoryTest {

    private InMemoryStockQuoteRepository repo;

    @Before
    public void setUp() throws Exception {
        repo = new InMemoryStockQuoteRepository();
    }

    @Test
    public void shouldReturnEmptyList() throws Exception {
        assertTrue(repo.getStockQuotes("GOOG").isEmpty());
    }

    @Test
    public void shouldSaveAndReturnSingleStockQuote() {
        StockQuote quote = new StockQuote("GOOG", 12.1, 12.4, new DateTime());
        repo.save(quote);
        assertEquals(Collections.singletonList(quote), repo.getStockQuotes("GOOG"));
    }

    @Test
    public void shouldSaveAndReturnMultipleStockQuotesForSameSymbol() {
        StockQuote quote1 = new StockQuote("GOOG", 12.1, 12.4, new DateTime());
        StockQuote quote2 = new StockQuote("GOOG", 1.2, 2.4, new DateTime());
        repo.save(quote1);
        repo.save(quote2);
        assertEquals(Arrays.asList(quote1, quote2), repo.getStockQuotes("GOOG"));
    }
}
