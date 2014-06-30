package se.montag.michael.financial;

/**
 * Created by mike on 6/29/14.
 */
public interface StockQuoteLookupService {
    /*
        Given a stock symbol this method returns a stock quote.
        @param  symbol  a stock symbol
        @return         returns a stock quote
         */
    StockQuote getQuote(String symbol);
}
