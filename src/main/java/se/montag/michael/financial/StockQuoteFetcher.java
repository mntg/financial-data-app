package se.montag.michael.financial;

import java.util.Scanner;

/**
 * Created by mike on 6/24/14.
 */
public class StockQuoteFetcher {

    public static void main(String[] args) {
        StockQuoteRepositoryInMemory  repo = new StockQuoteRepositoryInMemory();
        Scanner scan = new Scanner(System.in);
        while(true) {
            String symbol = scan.nextLine();
            if(symbol.equals("") || symbol.equalsIgnoreCase("QUIT") || symbol.equalsIgnoreCase("EXIT") || symbol.equalsIgnoreCase("Q")) {
                break;
            }
            StockQuote s = StockQuoteLookupService.getQuote(symbol);
            System.out.println("Bid: " + s.getBid() + " Ask: " + s.getAsk());
            repo.save(s);
        }
    }
}
