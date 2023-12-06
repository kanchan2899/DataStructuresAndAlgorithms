package com.dsalgo.dynamic.programming;

// https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
public class KadaneAlgo {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println(maxSubarraySum(arr));
    }

    /**
     * Usimg DP: For each index i, DP[i] stores the maximum possible Largest Sum Contiguous
     * Subarray ending at index i, and therefore we can calculate DP[i] using the mentioned
     * state transition:
     *
     * DP[i] = max(DP[i-1] + arr[i] , arr[i])
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param arr
     * @return
     */
    private static int maxSubarraySum(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];

        dp[0] = arr[0];

        int max = dp[0];

        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i], arr[i] + dp[i - 1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
