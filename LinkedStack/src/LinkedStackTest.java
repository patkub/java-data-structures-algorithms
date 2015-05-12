//Linked Stack - Patrick Kubiak - 5/10/2015
//Test the implementation of a stack using a Singly Linked List

import java.util.Scanner;

import net.datastructures.LinkedStack;
import net.datastructures.StackIsEmptyException;

public class LinkedStackTest {
    private static Scanner input = new Scanner(System.in);
    private static LinkedStack<Integer> stack = new LinkedStack<Integer>();

    public static void main(String[] args) {
        char choice = 'E';
        int num, position;
        String strNum;

        System.out.println("Welcome to the Linked Stack Test.");
        do {
            try {
                System.out.println("(I)nsert - (R)emove - (T)op - (S)earch - (D)isplay - (E)xit");
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
                                stack.push(num);
                            }
                        } while (!bStop);
                        break;
                    }

                    case 'R': {
                        //remove
                        try {
                            num = stack.pop();
                            System.out.println("Removed top element in stack: " + num);
                            System.out.println("Stack from top to bottom: " + stack);
                        } catch (StackIsEmptyException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    }

                    case 'T': {
                        //top
                        try {
                            System.out.println("The number at the top of the stack is: " + stack.top());
                        } catch (StackIsEmptyException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    }

                    case 'S': {
                        //search
                        System.out.print("Number to search for: ");
                        strNum = input.next();
                        num = Integer.parseInt(strNum);
                        position = stack.search(num);

                        if (position == -1) {
                            System.out.println("Position: " + position + " (number not found in stack)");
                        }
                        else {
                            System.out.println("Position: " + position);
                        }
                        break;
                    }

                    case 'D': {
                        //display
                        System.out.println("Stack from top to bottom: " + stack);
                        break;
                    }

                    case 'E': {
                        //exit
                        System.out.println("\nHave an nice day!");
                        System.exit(0);
                    }
                }
            } catch (Exception e) {
                continue;
            }
        } while (choice != 'E');
    }
}
