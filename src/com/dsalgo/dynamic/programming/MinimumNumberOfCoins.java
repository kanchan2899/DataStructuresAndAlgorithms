package com.dsalgo.dynamic.programming;

import java.util.Arrays;

// https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
public class MinimumNumberOfCoins {
    public static void main(String[] args) {
        int[] coins = {25, 10, 5};
        int sum = 30;

        System.out.println(minCoins(coins, coins.length, sum));
        System.out.println(minCoins1(coins, coins.length, sum));
        System.out.println(minCoins2(coins, coins.length, sum));
    }

    private static int minCoins2(int[] coins, int length, int sum) {
        int[] dp = new int[sum + 1];

        dp[0] = 0;

        for(int i = 1; i <= sum; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i = 1; i <= sum; i++) {
            for(int j = 0; j < length; j++) {
                int currCoins = dp[i - coins[j]];
                if(currCoins != Integer.MAX_VALUE && currCoins + 1 < dp[i]) {
                    dp[i] = currCoins + 1;
                }
            }
        }

        if(dp[sum] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[sum];
    }

    /**
     * Using DP - Memoization:
     *
     * 1. Creating a 2-D vector to store the Overlapping Solutions
     * 2. Keep Track of the overlapping subproblems while Traversing the array coins[]
     * 3. Recall them whenever needed.
     *
     * TC: O(n * sum)
     * SC: O(sum)
     *
     * @param coins
     * @param length
     * @param sum
     * @return
     */
    private static int minCoins1(int[] coins, int length, int sum) {
        int[] mem = new int[sum + 1];
        Arrays.fill(mem, -1);

        return helper(coins, length, sum, mem);
    }

    private static int helper(int[] coins, int length, int sum, int[] mem) {
        if(sum == 0) {
            return 0;
        }

        if(mem[sum] != -1) {
            return mem[sum];
        }

        int minCoins = Integer.MAX_VALUE;

        for(int i = 0; i < length; i++) {
            if(coins[i] <= sum) {
                int currCoins = helper(coins, length, sum - coins[i], mem);

                if(currCoins != Integer.MAX_VALUE && currCoins + 1 < minCoins) {
                    minCoins = currCoins + 1;
                }
            }
        }
        mem[sum] = minCoins;
        return minCoins;
    }

    /**
     * Using recursion:
     *
     * The minimum number of coins for a value V can be computed using the below recursive formula.
     *
     * If V == 0: 0 coins required
     * If V > 0: minCoins(coins[0..m-1], V ) = min { 1 + minCoins(V-coin[i])}
     * where 0 <=i <= m-1 and coins[i] <= V.
     *
     * TC: O(n ^ sum)
     * SC: O(sum)
     *
     * @param coins
     * @param sum
     * @return
     */
    private static int minCoins(int[] coins, int n, int sum) {
        if(n == 0) {
            return 0;
        }

        if(sum == 0) {
            return 0;
        }

        int minCoins = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            if(coins[i] <= sum) {
                int currCoins = minCoins(coins, n, sum - coins[i]);

                if(currCoins != Integer.MAX_VALUE && currCoins + 1 < minCoins) {
                    minCoins = currCoins + 1;
                }
            }
        }
        return minCoins;
    }
}
