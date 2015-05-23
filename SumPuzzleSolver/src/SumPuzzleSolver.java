/**
 * Created by pkubiak on 3/11/2015.
 */

import java.util.*;

public class SumPuzzleSolver {
    private static String strPuzzle;                                              //store puzzle.
    private static ArrayList<Character> letters = new ArrayList<Character>();     //store list of unique letters.
    private static int solutionCount;                                             //store number of solutions found.

    public static void main(String[] args) {
        //initialize
        Scanner input = new Scanner(System.in);
        ArrayList<String> S = new ArrayList<String>();
        ArrayList<String> U = new ArrayList<String>();
        solutionCount = 0;

        //get input
        System.out.println("Welcome to the Summation Puzzle Solver");
        System.out.print("Enter the puzzle: ");
        strPuzzle = input.nextLine();

        //get unique characters
        for (int i = 0; i < strPuzzle.length(); i++) {
            char cChar = strPuzzle.charAt(i);
            if (!letters.contains(cChar) && isOnlyLetters(Character.toString(cChar))) {
                letters.add(cChar);
            }
        }

        //define U = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
        for (int i = 0; i < 10; i++) {
            U.add(Integer.toString(i));
        }

        puzzleSolve(letters.size(), S, U);

        if (solutionCount == 1) {
            System.out.println("Found 1 Solution");
        }
        else {
            System.out.println("Found " + solutionCount + " Solutions");
        }
    }

    /**
     * Solve the puzzle.
     *
     * @param k     an integer.
     * @param S     sequence S.
     * @param U     set U.
     */
    public static void puzzleSolve(int k, ArrayList<String> S, ArrayList<String> U) {
        for (int i = 0; i < U.size(); i++) {    //for ever e in U
            String e = U.get(i);
            S.add(e);                           //add e to end of S
            U.remove(e);                        //remove e from U

            if (k == 1) {
                checkSolution(S);               //test whether S is a configuration that solves the puzzle
            }
            else {
                puzzleSolve(k - 1, S, U);
            }

            S.remove(e);                        //remove e from S
            U.add(i, e);                        //add e back to its original position in U
        }
    }

    /**
     * Test whether S is a configuration that solves the puzzle.
     *
     * @param S     ArrayList of type String of each character in a sequence.
     */
    public static void checkSolution(ArrayList<String> S) {
        String strResult = strPuzzle;
        int index = 0, sum = 0, result;

        //replace letters in puzzle with values from S.
        for (int i = 0; i < letters.size(); i++) {
            strResult = strResult.replaceAll(letters.get(i).toString(), S.get(index));
            index++;
            if (index >= S.size()) {
                index = 0;
            }
        }

        //trim spaces and split equation by + and = signs
        String[] strParts = strResult.replaceAll("\\s", "").split("[\\+=]");

        //compute sum of addends
        for (int i = 0; i < strParts.length - 1; i++) {
            sum += Integer.parseInt(strParts[i]);
        }

        //result is last element in strParts[]
        result = Integer.parseInt(strParts[strParts.length - 1]);

        //if sum = result, S is a solution
        if (sum == result) {
            System.out.println(strResult);
            solutionCount++;
        }
    }

    /**
     * Check if a string only contains letters A - Z.
     *
     * @param s     String to check if it only contains letters A - Z.
     * @return      True if it is only composed of letters A - Z, false otherwise.
     */
    public static boolean isOnlyLetters(String s) {
        return s.matches("[a-zA-Z]+");
    }
}
