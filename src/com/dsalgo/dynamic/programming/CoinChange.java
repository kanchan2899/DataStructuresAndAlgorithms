package com.dsalgo.dynamic.programming;

import java.util.Arrays;

// https://www.geeksforgeeks.org/coin-change-dp-7/
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 5;

        System.out.println(coinChange(coins, coins.length - 1, sum));
        System.out.println(coinChange1(coins, coins.length, sum));
        System.out.println(coinChange2(coins, sum));
    }

    /**
     * Using DP - Memoization
     *
     * 1. Create a 2D dp array to store the results of previously solved subproblems.
     * 2. dp[i][j] will represent the number of distinct ways to make the sum j by using the
     * first i coins.
     * 3. During the recursion call, if the same state is called more than once, then we can
     * directly return the answer stored for that state instead of calculating again.
     *
     * TC: O(n * sum)
     * SC: O(n * sum)
     *
     * @param coins
     * @param sum
     * @return
     */
    private static int coinChange2(int[] coins, int sum) {
        int[][] mem = new int[coins.length + 1][sum + 1];

        for(int[] m : mem) {
            Arrays.fill(m, -1);
        }

        return helper(coins, sum, mem, coins.length);
    }

    private static int helper(int[] coins, int sum, int[][] mem, int n) {
        if(sum == 0) {
            return mem[n][sum] = 1;
        }

        if(n == 0 || sum < 0) {
            return 0;
        }

        if(mem[n][sum] != -1) {
            return mem[n][sum];
        }

        return mem[n][sum] = helper(coins, sum - coins[n - 1], mem, n) + helper(coins, sum, mem, n - 1);
    }

    /**
     * Using DP - Tabulation:
     *
     * 1. Create a 2D dp array with rows and columns equal to the number of coin denominations
     * and target sum.
     * 2. dp[0][0] will be set to 1 which represents the base case where the target sum is 0, and
     * there is only one way to make the change by not selecting any coin.
     * 3. Iterate through the rows of the dp array (i from 1 to n), representing the current coin
     * being considered.
     *      - The inner loop iterates over the target sums (j from 0 to sum).
     *          a. Add the number of ways to make change without using the current coin, i.e.,
     *          dp[i][j] += dp[i-1][j].
     *          b. Add the number of ways to make change using the current coin, i.e.,
     *          dp[i][j] += dp[i][j-coins[i-1]].
     * 4. dp[n][sum] will contain the total number of ways to make change for the given target
     * sum using the available coin denominations.
     *
     * TC: O(n * sum)
     * SC: O(n * sum)
     *
     * @param coins
     * @param n
     * @param sum
     * @return
     */
    private static int coinChange1(int[] coins, int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];

        for(int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for(int i = 0; i <= sum; i++) {
            dp[0][sum] = 0;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if(coins[i - 1] <= j) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

    /**
     *
     * Using recursion:
     *
     * For each coin, there are 2 options.
     * 1. Include the current coin: Subtract the current coin’s denomination from the target sum
     * and call the count function recursively with the updated sum and the same set of coins i.e.,
     * count(coins, n, sum – coins[n-1] )
     * 2. Exclude the current coin: Call the count function recursively with the same sum and the
     * remaining coins. i.e., count(coins, n-1,sum ).
     *
     * Base case:
     * 1. If the target sum (sum) is 0, there is only one way to make the sum, which is by not
     * selecting any coin. So, count(0, coins, n) = 1.
     * 2. If the target sum (sum) is negative or no coins are left to consider (n == 0), then there
     * are no ways to make the sum, so count(sum, coins, 0) = 0.
     *
     * Recursive solution: count(coins,n,sum) = count(coins,n,sum-count[n-1]) + count(coins,n-1,sum)
     *
     * TC: O(2 ^ sum)
     * SC: O(sum)
     *
     * @param coins
     * @param n
     * @param sum
     * @return
     */
    private static int coinChange(int[] coins, int n, int sum) {
        if(sum == 0) {
            return 1;
        }
        if(sum < 0 || n == 0) {
            return 0;
        }

        return coinChange(coins, n, sum - coins[n - 1]) + coinChange(coins, n - 1, sum);
    }
}
