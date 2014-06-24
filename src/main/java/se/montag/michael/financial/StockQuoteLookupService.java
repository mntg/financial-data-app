package se.montag.michael.financial;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Created by mike on 6/24/14.
 */
public class StockQuoteLookupService {

    public StockQuoteLookupService() {}

    /*
    Given a stock symbol this method returns a stock quote.
    @param  symbol  a stock symbol
    @return         returns a stock quote
     */
    public static StockQuote getQuote(String symbol) {
        symbol  = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quotes%20where%20symbol%20in%20(%22" + symbol + "\")&env=store://datatables.org/alltableswithkeys";
        try {
            StockQuote s = new StockQuote(symbol);
            Document doc = Jsoup.connect(symbol).timeout(10*1000).get();
            s.setBidAsk(Double.parseDouble(getWebContent(doc,"Bid")),Double.parseDouble(getWebContent(doc,"Ask")));
            return s;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String getWebContent(Document doc, String property) throws Exception{
        Element q = doc.select(property).get(0);
        checkValidHTML(q.html());
        return(q.html());
    }

    private static void checkValidHTML(String str) throws Exception {
        if(str.equals("")) {
            throw new ConnectionException("Not a valid symbol.");
        }
    }
}
