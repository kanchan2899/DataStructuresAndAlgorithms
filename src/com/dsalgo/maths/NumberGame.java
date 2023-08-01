package com.dsalgo.maths;

// https://practice.geeksforgeeks.org/problems/number-game0303/1
public class NumberGame {

    public static void main(String[] args) {
        long n = 4;
        System.out.println(numGame(n));
    }

    /**
     * The problem states that we need least common multiple of all numbers from 1 to n.
     * Initialize result as 1. Start a loop i from 1 to n and calculate the LCM of result of current
     * i and mod the result. Return result.
     * TC: O(n * log n)
     * SC: O(1)
     * @param n
     * @return
     */
    static long numGame(long n) {
        long mod = 1000000007L;
        long result = 1;

        for(long i = 1; i <= n; i++) {
            result = lcm(result, i) % mod;
        }
        return result;
    }

    private static long lcm(long a, long b) {
        long lcm = (a * b) / gcd(a, b);
        return lcm;
    }

    private static long gcd(long a, long b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
