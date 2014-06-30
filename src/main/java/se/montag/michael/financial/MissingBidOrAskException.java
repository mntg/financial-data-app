package se.montag.michael.financial;

/**
 * Created by mike on 6/30/14.
 */
public class MissingBidOrAskException extends Exception {
    public MissingBidOrAskException(String message) {
        super(message);
    }
}
