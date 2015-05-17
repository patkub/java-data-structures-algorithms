/**
 * Created by Patka on 4/1/2015.
 *
 * Represents a share of stock.
 */

import java.text.NumberFormat;
import java.text.DecimalFormat;

public class Share {

    private int shares, price;

    /**
     * Create a share of stock.
     * @param shares    Integer number of shares
     * @param price     Integer price of shares
     */
    public Share(int shares, int price) {
        this.shares = shares;
        this.price = price;
    }

    /**
     * Get amount of shares.
     * @return          Integer amount of shares
     */
    public int getShares() {
        return shares;
    }

    /**
     * Get price of shares.
     * @return          Integer price of shares
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sell shares.
     * @param shares    Integer amount of shares to sell.
     */
    public void sellShares(int shares) {
        this.shares -= shares;
    }

    /**
     * String representation of share in the form of 'x shares valued at $x each.'.
     * @return          String representation of share.
     */
    public String toString() {
        DecimalFormat decFMT = (DecimalFormat) NumberFormat.getCurrencyInstance();
        String symbol = decFMT.getCurrency().getSymbol();
        decFMT.setNegativePrefix("-" + symbol);
        decFMT.setNegativeSuffix("");
        return Integer.toString(shares) + " shares valued at " + decFMT.format(price) + " each.";
    }
}
