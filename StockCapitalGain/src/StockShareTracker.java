/**
 * Created by Patka on 4/3/2015.
 */

import java.util.Scanner;

public class StockShareTracker {

    public static void main(String[] args) {
        //initialize
        StockTrans stockManager = new StockTrans();     //manage stock transactions

        Scanner input = new Scanner(System.in);         //get user input
        String strInput;                                //store user input
        String[] strCommand;                            //determine action
        boolean bAgain;                                 //redisplay menu
        int shares, price;

        System.out.println("Welcome to the Stock Share Tracker");
        System.out.println("s - shares c - capital gain x - exit\n");

        do {
            //process input
            System.out.print("Transaction: ");
            strInput = input.nextLine();
            strCommand = strInput.split(" ");

            if (strInput.toUpperCase().charAt(0) == 'C') {
                //display capital gain
                System.out.println("\nCapital Gain: " + stockManager.getFormattedCapitalGain());
            }
            else if (strInput.toUpperCase().charAt(0) == 'X') {
                //exit
                System.out.println("\nHave a nice day.");
                break;
            }
            else if (strCommand[0].toUpperCase().equals("BUY")) {
                //buy shares
                shares = Integer.parseInt(strCommand[1]);
                price = Integer.parseInt(strCommand[4].substring(1, strCommand[4].length()));
                stockManager.buyShares(shares, price);
            }
            else if (strCommand[0].toUpperCase().equals("SELL")) {
                //sell shares
                shares = Integer.parseInt(strCommand[1]);
                price = Integer.parseInt(strCommand[4].substring(1, strCommand[4].length()));
                try {
                    stockManager.sellShares(shares, price);
                }
                catch (NotEnoughSharesException e) {
                    System.out.println(e.getMessage());
                }
            }
            else if (strInput.toUpperCase().charAt(0) == 'S') {
                //display shares
                System.out.println("===================== SHARES =====================");
                stockManager.printDeque();
                System.out.println("\nCapital Gain: " + stockManager.getFormattedCapitalGain());
                System.out.println("==================================================");
            }
        }
        while (strCommand[0].toUpperCase().charAt(0) != 'X');
    }
}
