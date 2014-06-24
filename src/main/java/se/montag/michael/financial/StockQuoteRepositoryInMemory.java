package se.montag.michael.financial;

import java.util.*;

/**
 * Created by mike on 6/24/14.
 */
public class StockQuoteRepositoryInMemory implements StockQuoteRepository {

    private Map<String,List<StockQuote>> stockQuotes;

    public StockQuoteRepositoryInMemory() {
        stockQuotes = new HashMap<String,List<StockQuote>>();
    }

    @Override
    public void save(StockQuote s) {
        List<StockQuote> stockList = stockQuotes.get(s.getSymbol());
        if(stockList == null) {
            stockList = new LinkedList<StockQuote>();
            stockList.add(s);
            stockQuotes.put(s.getSymbol(),stockList);
        } else {
            stockList.add(s);
        }
    }

    public List<StockQuote> getStockQuotes(String symbol) {
        return stockQuotes.get(symbol);
    }
}
