package com.dsalgo.dynamic.programming;

// https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
public class KnapsackProblem {
    public static void main(String[] args) {
        int profit[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int W = 50;
        System.out.println(knapSack(weight, profit, W, weight.length));
        System.out.println(knapSack1(weight, profit, W, weight.length));
        System.out.println(knapSack2(weight, profit, W, weight.length));
    }

    private static int knapSack2(int[] weight, int[] profit, int W, int n) {
        int i, w;
        int[][] dp = new int[n + 1][W + 1];

        // build table dp[][] in bottom up manner
        for(i = 0; i <= n; i++) {
            for(w = 0; w <= W; w++) {
                if(i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weight[i - 1] <= w) {
                    dp[i][w] = Math.max(profit[i - 1] + dp[i - 1][w - weight[i - 1]],
                            dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][W];
    }

    /**
     * Using DP - memoization: If we get a subproblem the first time, we can solve this problem
     * by creating a 2-D array that can store a particular state (n, w). Now if we come across
     * the same state (n, w) again instead of calculating it in exponential complexity we can
     * directly return its result stored in the table in constant time.
     *
     * TC: O(n * w)
     * SC: O(n * w)
     *
     * @param weight
     * @param profit
     * @param W
     * @param n
     * @return
     */
    private static int knapSack1(int[] weight, int[] profit, int W, int n) {
        int[][] mem = new int[n + 1][W + 1];

        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < W + 1; j++) {
                mem[i][j] = -1;
            }
        }
        return helper(weight, profit, mem, W, n);
    }

    private static int helper(int[] weight, int[] profit, int[][] mem, int W, int n) {
        if(n == 0 || W == 0) {
            return 0;
        }

        if(mem[n][W] != -1) {
            return mem[n][W];
        }

        if(weight[n - 1] > W) {
            // store the value of function call stack in table before return
            return mem[n][W] = helper(weight, profit, mem, W, n - 1);
        } else {
            // return value of table after storing
            return mem[n][W] = Math.max(profit[n - 1] + helper(weight, profit, mem, W - weight[n - 1], n - 1),
                    helper(weight, profit, mem, W, n - 1));
        }
    }

    /**
     * Using recursion: A simple solution is to consider all subsets of items and calculate the
     * total weight and profit of all subsets. Consider the only subsets whose total weight is
     * smaller than W. From all such subsets, pick the subset with maximum profit.
     *
     * Optimal Substructure: To consider all subsets of items, there can be two cases for every item.
     *
     * Case 1: The item is included in the optimal subset.
     * Case 2: The item is not included in the optimal set.
     *
     * Case 1 (include the Nth item): Value of the Nth item plus maximum value obtained by remaining
     * N-1 items and remaining weight i.e. (W-weight of the Nth item).
     * Case 2 (exclude the Nth item): Maximum value obtained by N-1 items and W weight.
     * If the weight of the ‘Nth‘ item is greater than ‘W’, then the Nth item cannot be included
     * and Case 2 is the only possibility.
     *
     * TC: O(2 ^ n)
     * SC: O(n)
     *
     * @param weight
     * @param profit
     * @param W
     * @param n
     * @return
     */
    private static int knapSack(int[] weight, int[] profit, int W, int n) {

        if(n == 0 || W == 0) {
            return 0;
        }

        // if weight of the nth item is more than Knapsack capacity W, then this item cannot be
        // included in the original solution
        if(weight[n - 1] > W) {
            return knapSack(weight, profit, W, n - 1);
        } else {
            // return the maximum of two cases:
            // Case 1: nth item included
            // Case 2: nth item not included

            return Math.max(profit[n - 1] + knapSack(weight, profit, W - weight[n - 1], n - 1),
                    knapSack(weight, profit, W, n - 1));
        }
    }
}
