package se.montag.michael.financial;

import java.util.*;

/**
 * Created by mike on 6/24/14.
 */
public class InMemoryStockQuoteRepository implements StockQuoteRepository {

    private Map<String,List<StockQuote>> stockQuotes;

    public InMemoryStockQuoteRepository() {
        stockQuotes = new HashMap<String,List<StockQuote>>();
    }

    @Override
    public void save(StockQuote s) {
        List<StockQuote> stockList = stockQuotes.get(s.getSymbol());
        if(stockList == null) {
            stockList = new LinkedList<StockQuote>();
            stockQuotes.put(s.getSymbol(), stockList);
        }
        stockList.add(s);
    }

    public List<StockQuote> getStockQuotes(String symbol) {
        List<StockQuote> quotes = stockQuotes.get(symbol);
        return quotes == null ? Collections.EMPTY_LIST : quotes;
    }
}
