/**
 * Created by pkubiak on 11/5/2015.
 */

import java.util.Scanner;

public class Euclid {

    public static int gcd(int p, int q) {
        if (q == 0)
        {
            return p;
        }
        else
        {
            int r = p % q;
            System.out.println(p + " = " + q + " * " + (p / q) + " + " + r);
            return gcd(q, r);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int p, q, g;

        System.out.println("Euclidean GCD");
        System.out.print("p = ");
        p = input.nextInt();
        System.out.print("q = ");
        q = input.nextInt();

        g = gcd(p, q);
        System.out.println("GCD = " + g);
    }
}
