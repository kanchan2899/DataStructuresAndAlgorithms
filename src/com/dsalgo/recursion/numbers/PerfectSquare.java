package com.dsalgo.recursion.numbers;

// https://leetcode.com/problems/perfect-squares/description/
public class PerfectSquare {
    public static void main(String[] args) {
        int n = 20;
        System.out.println(numSquares(n));
        System.out.println(numSquares1(n));
    }

    private static int numSquares(int n) {
        if( n < 4) {
            return n;
        }
        int ans = n;

        for(int i = 1; i * i <= n; i++) {
            int sqrt = (i * i);
            ans = Math.min(ans, 1 + numSquares(n - sqrt));
        }
        return ans;
    }

    private static int numSquares1(int n) {
        int[] memo = new int[n + 1];
        return helper(n, memo);
    }

    private static int helper(int n, int[] memo) {
        if(n < 4) {
            return n;
        }

        if(memo[n] != 0) {
            return memo[n];
        }

        int ans = n;

        for(int i = 1; i * i <= n; i++) {
            int square = i * i;
            ans = Math.min(ans, 1 + helper(n - square, memo));
        }
        return memo[n] = ans;
    }
}
