/**
 * Created by Patka on 4/3/2015.
 *
 * Manages stocks using a Concurrent Linked Deque
 */

import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.Iterator;

public class StockTrans {

    private ConcurrentLinkedDeque<Share> sharesDeque;
    private int totalShares, capitalGain;

    public StockTrans() {
        sharesDeque = new ConcurrentLinkedDeque<Share>();
        capitalGain = 0;
    }

    /**
     * Buy shares.
     * @param amount        Integer amount of shares to buy.
     * @param price         Integer price of shares.
     */
    public void buyShares(int amount, int price) {
        sharesDeque.add(new Share(amount, price));
        totalShares += amount;
    }

    /**
     * Sell shares.
     * @param amount                        Integer amount of shares to sell.
     * @param sellPrice                     Integer price to sell the shares for.
     * @throws NotEnoughSharesException     Thrown when not enough shares to sell.
     */
    public void sellShares(int amount, int sellPrice) throws NotEnoughSharesException {
        if (totalShares < amount) {
            throw new NotEnoughSharesException("Sorry, you do not have enough shares to sell.");
        }
        Share firstShare;
        int origPrice, firstShares;

        while (amount > 0) {
            firstShare = sharesDeque.peekFirst();
            firstShares = firstShare.getShares();
            origPrice = firstShare.getPrice();

            if (amount < firstShares) {
                firstShare.sellShares(amount);
                capitalGain += (sellPrice - origPrice) * amount;
                break;
            }
            else {
                capitalGain += (sellPrice - origPrice) * firstShares;
                amount -= firstShares;
                sharesDeque.removeFirst();
            }
        }
    }

    /**
     * Get capital gain.
     * @return Integer capital gain.
     */
    public int getCapitalGain() {
        return capitalGain;
    }

    /**
     * Format capital gain currency.
     * @return String representation of capital gain formatted with the proper currency.
     */
    public String getFormattedCapitalGain() {
        DecimalFormat decFMT = (DecimalFormat) NumberFormat.getCurrencyInstance();
        String symbol = decFMT.getCurrency().getSymbol();
        decFMT.setNegativePrefix("-" + symbol);
        decFMT.setNegativeSuffix("");
        return decFMT.format(capitalGain);
    }

    /**
     * Print out the deque.
     */
    public void printDeque() {
        Iterator iterator = sharesDeque.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }
}
