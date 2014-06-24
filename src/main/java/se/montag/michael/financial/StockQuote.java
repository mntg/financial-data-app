package se.montag.michael.financial;
import org.joda.time.DateTime;
/**
 * Created by mike on 6/22/14.
 */
public class StockQuote {
    private double bid;
    private double ask;
    private String symbol;
    private DateTime time;

    public StockQuote(String symbol) {
        this.symbol = symbol;
    }

    public StockQuote(String symbol, double bid, double ask) {
        this.symbol = symbol;
        this.bid = bid;
        this.ask = ask;
        time = new DateTime();
    }

    public void setBidAsk(double bid, double ask) {
        this.bid = bid;
        this.ask = ask;
        time = new DateTime();
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getBid() {
        return bid;
    }

    public double getAsk() {
        return ask;
    }

    public String getSymbol() {
        return symbol;
    }

    public DateTime getTime() {
        return time;
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof StockQuote)) {
            return false;
        } else {
            return ((StockQuote) other).getSymbol().equals(symbol) && ((StockQuote) other).getTime().equals(time);
        }
    }

    @Override
    public int hashCode() {
        return symbol.hashCode() + time.hashCode();
    }
}
