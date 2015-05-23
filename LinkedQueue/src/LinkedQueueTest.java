/**
 * Created by Patka on 5/17/2015.
 */

import java.util.Scanner;

import net.datastructures.LinkedQueue;
import net.datastructures.QueueIsEmptyException;

public class LinkedQueueTest {
    private static Scanner input = new Scanner(System.in);
    private static LinkedQueue<Integer> queue = new LinkedQueue<Integer>();

    public static void main(String[] args) {
        char choice = 'X';
        int num;
        String strNum;

        System.out.println("Welcome to the Linked Queue Test.");
        do {
            System.out.println("(I)nsert - (R)emove - (P)eek - (D)isplay - E(x)it");
            System.out.print("Input: ");
            choice = input.next().toUpperCase().charAt(0);

            switch (choice) {
                case 'I': {
                    //insert
                    boolean bStop = false;
                    do {
                        System.out.print("Number to insert (x to stop): ");
                        strNum = input.next();
                        if (strNum.toUpperCase().charAt(0) == 'X') {
                            bStop = true;
                        } else {
                            num = Integer.parseInt(strNum);
                            queue.enqueue(num);
                        }
                    } while (!bStop);
                    break;
                }

                case 'R': {
                    //remove
                    try {
                        num = queue.dequeue();
                        System.out.println("Removed first element in queue: " + num);
                        System.out.println("Queue from front to back: " + queue);
                    } catch (QueueIsEmptyException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 'P': {
                    //peek
                    num = queue.first();
                    System.out.println("First element in queue: " + num);
                    break;
                }

                case 'D': {
                    //display
                    System.out.println("Queue from front to back: " + queue);
                    break;
                }

                case 'X': {
                    //exit
                    System.out.println("\nHave an nice day!");
                    System.exit(0);
                }
            }
        } while (choice != 'E');
    }
}
