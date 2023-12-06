package com.dsalgo.dynamic.programming;

public class MaximumSumWithNoTwoConsecutive {
    public static void main(String[] args) {
        int[] arr = {10, 5, 20, 2};
        System.out.println(maxSum(arr, arr.length));
        System.out.println(maxSum1(arr, arr.length));
        System.out.println(maxSum2(arr, arr.length));
    }

    /**
     * Using DP - Tabulation, space-optimized
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param arr
     * @param n
     * @return
     */
    private static int maxSum2(int[] arr, int n) {
        if(n == 1) {
            return arr[0];
        }
        int prev_prev = arr[0];
        int prev = Math.max(arr[0], arr[1]);
        int res = prev;

        for(int i = 3; i <= n; i++) {
            res = Math.max(prev, prev_prev + arr[i - 1]);
            prev_prev = prev;
            prev = res;
        }
        return res;
    }

    /**
     * Using DP - Tabulation
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param arr
     * @param n
     * @return
     */
    private static int maxSum1(int[] arr, int n) {
        if(n == 1)
            return arr[0];

        int[] dp = new int[n + 1];
        dp[1] = arr[0];
        dp[2] = Math.max(arr[0], arr[1]);

        for(int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i - 1]);
        }
        return dp[n];
    }

    /**
     * Using Recursion
     *
     * TC: O(2 ^ n)
     * SC: O(n)
     *
     * @param arr
     * @param n
     * @return
     */
    private static int maxSum(int[] arr, int n) {
        if(n == 1)
            return arr[0];
        if(n == 2)
            return Math.max(arr[0], arr[1]);
        return Math.max(maxSum(arr, n - 1), maxSum(arr, n - 2) + arr[n - 1]);
    }
}
