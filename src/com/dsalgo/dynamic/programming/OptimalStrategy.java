package com.dsalgo.dynamic.programming;

// https://www.geeksforgeeks.org/optimal-strategy-for-a-game-dp-31/
public class OptimalStrategy {
    public static void main(String[] args) {
        int[] arr = {20, 30, 2, 2, 2, 10};
        System.out.println(optimalStrategy(arr, arr.length));
    }

    private static int optimalStrategy(int[] arr, int n) {
        int[][] dp = new int[n][n];
        int x, y, z;

        for(int gap = 0; gap < n; gap++) {
            for(int i = 0, j = gap; j < n; j++, i++) {
                x = ((i + 2) <= j) ? dp[i + 2][j] : 0;
                y = ((i + 1) <= (j - 1)) ? dp[i + 1][j - 1] : 0;
                z = (i <= (j - 2)) ? dp[i][j - 2] : 0;

                dp[i][j] = Math.max(arr[i] + Math.min(x, y), arr[j] + Math.min(y, z));
            }
        }
        return dp[0][n - 1];
    }
}
