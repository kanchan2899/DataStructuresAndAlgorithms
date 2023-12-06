package com.dsalgo.dynamic.programming;

import java.util.Vector;

// https://www.geeksforgeeks.org/binomial-coefficient-dp-9/
public class BinomialCoefficient {
    public static void main(String[] args) {
        int n = 5;
        int k = 2;

        System.out.println(bionomialCoefficient(n, k));
        System.out.println(bionomialCoefficient1(n, k));
        System.out.println(bionomialCoefficient2(n, k));
        System.out.println(bionomialCoefficient3(n, k));
    }

    /**
     * DP - Memoization: Memoization Approach: The idea is to create a lookup table and follow
     * the recursive top-down approach. Before computing any value, we check if it is already
     * in the lookup table. If yes, we return the value. Else we compute the value and store it
     * in the lookup table.
     *
     * TC: O(n * k)
     * SC: O(n * k)
     *
     * @param n
     * @param k
     * @return
     */
    private static int bionomialCoefficient3(int n, int k) {
        // Make a temporary lookup table
        Vector<Integer>[] dp = new Vector[n+1];

        // Loop to create table dynamically
        for(int i = 0; i < n + 1; i++) {
            dp[i] = new Vector<>();
            for(int j = 0; j <= k; j++) {
                dp[i].add(-1);
            }
        }
        return helper(n, k, dp);
    }

    private static int helper(int n, int k, Vector<Integer>[] dp) {
        // if value in lookup table then return
        if(dp[n].get(k) != -1) {
            return dp[n].get(k);
        }

        // when k reaches 0, store value in a table before return
        if(k == 0) {
            dp[n].add(k, 1);
            return dp[n].get(k);
        }

        // when n reaches k, store value in a table before return
        if(k == n) {
            dp[n].add(k, 1);
            return dp[n].get(k);
        }

        // save value in lookup table before return
        dp[n].add(k, helper(n - 1, k - 1, dp) + helper(n - 1, k, dp));

        return dp[n].get(k);
    }

    /**
     * DP - Tabulation but space-optimized
     *
     * TC: O(n * k)
     * SC: O(k)
     *
     * @param n
     * @param k
     * @return
     */
    private static int bionomialCoefficient2(int n, int k) {
        int[] C = new int[k + 1];

        C[0] = 1;

        for(int i = 1; i <= n; i++) {
            for(int j = Math.min(i, k); j > 0; j--) {
                C[j] = C[j] + C[j - 1];
            }
        }
        return C[k];
    }

    /**
     * Using recursion:
     *
     * The value of C(n, k) can be recursively calculated using the following standard formula for
     * Binomial Coefficients.
     *
     *  C(n, k) = C(n-1, k-1) + C(n-1, k)
     *  C(n, 0) = C(n, n) = 1
     *
     *  TC: O(n * max(k, n - k))
     *  SC: O(n * max(k, n - k))
     *
     * @param n
     * @param k
     * @return
     */
    private static int bionomialCoefficient1(int n, int k) {
        if(k > n) {
            return 0;
        }
        if(k == 0 || n == 0) {
            return 1;
        }

        return bionomialCoefficient1(n - 1, k - 1) + bionomialCoefficient1(n - 1, k);
    }


    /**
     * Dynamic Programming - Tabulation (bottom-up): re-computations of the same sub-problems can be
     * avoided by constructing a temporary 2D-array C[][] in a bottom-up manner.
     *
     * TC: O(n * k)
     * SC: O(n * k)
     * @param n
     * @param k
     * @return
     */
    private static int bionomialCoefficient(int n, int k) {
        int[][] C = new int[n + 1][k + 1];

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= Math.min(i, k); j++) {
                if(j == 0 || i == 0) {
                    C[i][j] = 1;
                } else {
                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
                }
            }
        }

        return C[n][k];
    }
}
