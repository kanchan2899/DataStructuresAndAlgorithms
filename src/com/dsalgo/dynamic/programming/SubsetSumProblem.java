package com.dsalgo.dynamic.programming;

// https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
public class SubsetSumProblem {
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println(countSubsetsWithSum(arr, sum));
    }

    /**
     * Using DP - Tabulation:
     *
     * TC: O(n * sum)
     * SC: O(n * sum)
     *
     * @param arr
     * @param sum
     * @return
     */
    private static int countSubsetsWithSum(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];

        for(int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for(int j = 0; j <= sum; j++) {
            dp[0][j] = 0;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= sum; j++) {
                if(j < arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}
