package se.montag.michael.financial;

import java.util.Scanner;
import java.util.logging.*;

/**
 * Created by mike on 6/24/14.
 */
public class StockQuoteFetcherApp {

    private StockQuoteRepository repo;
    private StockQuoteLookupService lookupService;
    private final static Logger logger = Logger.getLogger(StockQuoteFetcherApp.class.getName());
    private FileHandler fileHandler;

    public static void main(String[] args) {
        StockQuoteFetcherApp fetcher = new StockQuoteFetcherApp(new InMemoryStockQuoteRepository(), new YahooStockQuoteLookupService());
        fetcher.run();
    }

    public StockQuoteFetcherApp(StockQuoteRepository repo, StockQuoteLookupService lookupService) {
        this.repo = repo;
        this.lookupService = lookupService;
    }

    public void run() {
        try {
            fileHandler = new FileHandler("%h/IdeaProjects/FinancialDataApp/Logfiles/financial-app-log.txt",1024 * 1024, 1);
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.println("Enter symbol: ");
            String symbol = scan.nextLine();
            logger.log(Level.INFO, symbol);
            if(symbol.equals("") || symbol.equalsIgnoreCase("QUIT") || symbol.equalsIgnoreCase("EXIT") || symbol.equalsIgnoreCase("Q")) {
                break;
            }
            StockQuote s = lookupService.getQuote(symbol);
            System.out.println("Bid: " + s.getBid() + " Ask: " + s.getAsk());
            repo.save(s);
        }
    }
}
