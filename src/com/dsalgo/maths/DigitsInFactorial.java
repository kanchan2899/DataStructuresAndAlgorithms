package com.dsalgo.maths;

// https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Mathematics/problem/digits-in-factorial
public class DigitsInFactorial {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(digitsInFactorial(n));
        System.out.println(digitsInFactorial1(n));
    }

    private static int digitsInFactorial1(int n) {
        double result = 0;
        for(int i = 2; i <= n; i++) {
            result = result + Math.log10(i);
        }
        result = (int)(Math.floor(result)) + 1;
        return (int)result;
    }

    /**
     * Bruteforce: Calculate the factorial and then return Math.log10(fact) + 1
     *
     * TC: O(n)
     * SC: O(n)
     * @param n
     * @return
     */
    public static int digitsInFactorial(int n){
        return (int) (Math.log10(factorial(n)) + 1);
    }

    private static double factorial(int n) {
        if(n == 1 || n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
