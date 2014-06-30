package se.montag.michael.financial;
import org.joda.time.DateTime;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by mike on 6/24/14.
 */
public class YahooStockQuoteLookupService implements StockQuoteLookupService {
    /*
    Given a stock symbol this method returns a stock quote.
    @param  symbol  a stock symbol
    @return         returns a stock quote
     */
    @Override
    public StockQuote getQuote(String symbol) {
        String url = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quotes%20where%20symbol%20in%20(%22" + symbol + "\")&env=store://datatables.org/alltableswithkeys";
        try {
            Document doc = Jsoup.connect(url).timeout(15*1000).get();
            return new StockQuote(symbol,
                    Double.parseDouble(getWebContent(doc, "Bid")),
                    Double.parseDouble(getWebContent(doc,"Ask")),new DateTime());
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String getWebContent(Document doc, String property) throws Exception{
        Elements elements = doc.select(property);
        System.out.println(elements);
        if(elements.size() == 0) {
            throw new NotValidSymbolException("Not a valid symbol.");
        } else {
            Element ele = elements.get(0);
            checkValidHTML(ele.html());
            return(ele.html());
        }
    }

    private static void checkValidHTML(String str) throws Exception {
        if(str.equals("")) {
            throw new MissingBidOrAskException("Bid or ask is missing.");
        }
    }
}
