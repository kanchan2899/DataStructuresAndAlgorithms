package com.dsalgo.maths;

public class GCD {
    public static void main(String[] args) {
        int a = 10, b = 15;
        System.out.println(gcd1(a, b));
        System.out.println(gcd2(a, b));
    }

    private static int gcd2(int a, int b) {
        while(a != b) {
            if(a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;       // return b;
    }

    /**
     * Bruteforce:
     *
     * @param a
     * @param b
     * @return
     */
    private static int gcd1(int a, int b) {
        int gcd = Math.min(a, b);
        while (gcd > 0) {
            if(a % gcd == 0 && b % gcd == 0) {
                break;
            }
            gcd--;
        }
        return gcd;
    }
}
