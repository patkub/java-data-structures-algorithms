//Stock Transactions - Patrick Kubiak - 4/3/2015
//Manages stock transactions using a Circular Queue.

import net.datastructures.LinkedCircularQueue;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class StockTrans {

    private LinkedCircularQueue<Share> sharesCircleQueue;
    private int totalShares, capitalGain;

    public StockTrans() {
        sharesCircleQueue = new LinkedCircularQueue<Share>();
        capitalGain = 0;
    }

    /**
     * Buy shares.
     * @param amount        Integer amount of shares to buy.
     * @param price         Integer price of shares.
     */
    public void buyShares(int amount, int price) {
        sharesCircleQueue.enqueue(new Share(amount, price));
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
            firstShare = sharesCircleQueue.first();
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
                sharesCircleQueue.dequeue();
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
     * Displays the shares.
     */
    public void displayShares() {
        System.out.print(sharesCircleQueue.toString());
    }
}
