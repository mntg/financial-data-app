package se.montag.michael.financial;

import java.util.List;

/**
 * Created by mike on 6/24/14.
 */
public interface StockQuoteRepository {

    /*
    Saves a stock quote to the repository.
     */
    public void save(StockQuote s);

    public List<StockQuote> getStockQuotes(String symbol);
}
