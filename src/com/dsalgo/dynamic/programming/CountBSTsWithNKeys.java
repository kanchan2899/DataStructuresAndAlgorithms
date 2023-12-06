package com.dsalgo.dynamic.programming;

// https://www.geeksforgeeks.org/total-number-of-possible-binary-search-trees-with-n-keys/
public class CountBSTsWithNKeys {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(countBSTs(n));
    }

    /**
     * Using DP - Tabulation
     *
     * TC: O(n ^ 2)
     * SC: O(n)
     *
     * @param n
     * @return
     */
    private static int countBSTs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for(int i = 1; i <= n; i++) {
            dp[i] = 0;

            for(int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
