package com.dsalgo.maths;

public class PowerOfN {
    public static void main(String[] args) {
        int x = 4;
        int n = 5;
        System.out.println(power(x, n));
        System.out.println(power1(x, n));
        System.out.println(power2(x, n));
    }

    /**
     * Using bit manipulation: Intialize result as 1. Start a while loop until n > 0
     * Check if (n % 2 != 0), if it is multiply the result by x, else don't do anything.
     * For every iteration, x becomes x * x and n becomes n /2.
     *
     * TC: O(log n)
     * SC: O(1)
     * @param x
     * @param n
     * @return
     */
    private static int power2(int x, int n) {
        int result = 1;
        while (n > 0) {
            if(n % 2 != 0) {
                result *= x;
            }
            x = x * x;
            n = n >> 1;
        }
        return result;
    }

    /**
     * Using recursion:
     * @param x
     * @param n
     * @return
     */
    private static int power1(int x, int n) {
        if(n == 0) {
            return 1;
        }
        int temp = power1(x, n / 2);

        if(n % 2 == 0) {
            return temp * temp;
        } else {
            return temp * temp * x;
        }
    }

    /**
     * Bruteforce: Initialize result as 1. Run a loop from 0 to n - 1
     * and multiply result with x. Return result at the end;
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param x
     * @param n
     * @return
     */
    private static int power(int x, int n) {
        int res = 1;
        for(int i = 0; i < n; i++) {
            res = res * x;
        }
        return res;
    }


}
