package com.dsalgo.dynamic.programming;

// https://www.geeksforgeeks.org/problems/count-number-of-hops-1587115620/1
public class CountNumberOfHops {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(countWays(n));
    }

    static long countWays(int n)
    {
        if(n <= 0) {
            return 0;
        }
        if(n <= 2) {
            return n;
        }

        long mod = 1000000007L;
        long[] dp = new long[n + 1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % mod;
        }

        return dp[n];
    }

}
