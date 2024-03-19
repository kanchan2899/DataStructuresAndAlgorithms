package com.dsalgo.grokking.patterns.dynamic.programming;

import java.util.Arrays;

// https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
public class _01KnapsackProblem {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 5};
        int[] values = {1, 5, 4, 8};
        int capacity = 6;

        System.out.println(maxProfit(weights, values, capacity, weights.length));
        System.out.println(maxProfitUsingMemoization(weights, values, capacity, weights.length));
        System.out.println(maxProfitUsingTabulation(weights, values, capacity, weights.length));
        System.out.println(maxProfitUsingTabulationOptimized(weights, values, capacity, weights.length));
    }

    private static int maxProfitUsingTabulationOptimized(int[] weights, int[] values, int capacity, int n) {
        int[] dp = new int[capacity + 1];
        Arrays.fill(dp, 0);

        // current ith row that will use the values of previous (i - 1)th row to fill itself
        int[] temp = new int[capacity + 1];
        Arrays.fill(temp, 0);

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= capacity; j++) {
                if(weights[i - 1] <= j) {
                    temp[j] = Math.max(values[i - 1] + dp[j - weights[i - 1]], dp[j]);
                } else {
                    temp[j] = dp[j];
                }
            }
            dp = temp.clone();
        }
        return dp[capacity];
    }

    private static int maxProfitUsingTabulation(int[] weights, int[] values, int capacity, int n) {
        int[][] dp = new int[n + 1][capacity + 1];

        for(int[] row: dp) {
            Arrays.fill(row, 0);
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= capacity; j++) {
                // check if the weight of the current item is less than the current capacity
                if(weights[i - 1] <= j) {
                    dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][capacity];
    }

    private static int maxProfitUsingMemoization(int[] weights, int[] values, int capacity, int n) {
        int[][] dp = new int[n + 1][capacity + 1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return helper(weights, values, capacity, n, dp);
    }

    private static int helper(int[] weights, int[] values, int capacity, int n, int[][] dp) {
        // base case
        if(n == 0 || capacity == 0) {
            return 0;
        }

        // if we have already solved this problem, fetch the results from dp array
        if(dp[n][capacity] != -1) {
            return dp[n][capacity];
        }

        // otherwise, solve it and save the result in the lookup table
        if(weights[n - 1] <= capacity) {
            dp[n][capacity] = Math.max(values[n - 1] + helper(weights,
                    values, capacity - weights[n - 1], n - 1, dp),
                    helper(weights, values, capacity, n - 1, dp));
            return dp[n][capacity];
        }

        dp[n][capacity] = helper(weights, values, capacity, n - 1, dp);
        return dp[n][capacity];
    }

    /**
     * Using recursion:
     *
     * 1. Base case: If there are no items left to add or the maximum capacity of the knapsack
     * has been reached, we return
     * 2. Recursive case 1: If the current item has a weight less than or equal to the remaining
     * capacity of the knapsack, it can be added to the knapsack. At this point, we make two
     * recursive calls to solve two sub-problems:
     *  a. Find the maximum value of items we can include in the knapsack, while including the
     *  current item.
     *  b. Find the maximum value of items we can include in the knapsack, while excluding
     * the current item.
     * 3. Of the two options, we choose the one that yields the higher value.
     * 4. Recursive case 2: On the other hand, if the weight of the item is greater than the
     * remaining capacity of the knapsack, the item cannot be added to the knapsack. Therefore,
     * we use a recursive call to move on to the next item, without adding this item to the knapsack.
     *
     * @param weights
     * @param values
     * @param capacity
     * @param n
     * @return
     */

    private static int maxProfit(int[] weights, int[] values, int capacity, int n) {
        if(n == 0 || capacity == 0) {
            return 0;
        }

        // if the weight of the nth item is less than capacity
        if(weights[n - 1] <= capacity) {
            // we either include the item and deduct the weight of the item from the knapsack capacity
            // (to get the remaining capacity) or we don't include the item at all.
            // we pick the option that yields the highest value
            return Math.max(values[n - 1] + maxProfit(weights, values, capacity - weights[n - 1], n - 1),
                    maxProfit(weights, values, capacity, n - 1));
        } else {
            // item can't be added to out knapsack if its weight is greater than the capacity
            return maxProfit(weights, values, capacity, n - 1);
        }
    }
}
