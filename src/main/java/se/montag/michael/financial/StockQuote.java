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

    public StockQuote(String symbol, double bid, double ask, DateTime time) {
        this.symbol = symbol;
        this.bid = bid;
        this.ask = ask;
        this.time = time;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockQuote that = (StockQuote) o;

        if (Double.compare(that.ask, ask) != 0) return false;
        if (Double.compare(that.bid, bid) != 0) return false;
        if (!symbol.equals(that.symbol)) return false;
        if (!time.equals(that.time)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(bid);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(ask);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + symbol.hashCode();
        result = 31 * result + time.hashCode();
        return result;
    }
}
