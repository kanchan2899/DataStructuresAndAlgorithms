package com.dsalgo.dynamic.programming;

public class CountWaysToReachNthStairNoOrdering {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(countWays(n));
    }

    private static long countWays(int m) {
        long dp[] = new long[m + 1];
        dp[0] = 1;

        for(int i = 1; i <= 2; i++) {
            for(int j = i; j <= m; j++) {
                dp[j] += dp[j - i];
            }
        }
        return dp[m];
    }
}
