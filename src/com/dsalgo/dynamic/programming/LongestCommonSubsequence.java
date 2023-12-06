package com.dsalgo.dynamic.programming;

import java.util.Arrays;

// https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(lcs(s1, s2, s1.length() - 1, s2.length() - 1));
        System.out.println(lcs1(s1, s2, s1.length() - 1, s2.length() - 1));
        System.out.println(lcs2(s1, s2, s1.length() - 1, s2.length() - 1));
    }

    /**
     * Using DP - Tabulation:
     *
     * 1. Create a 2D array dp[][] with rows and columns equal to the length of each input string
     * plus 1 [the number of rows indicates the indices of S1 and the columns indicate the indices
     * of S2].
     * 2. Initialize the first row and column of the dp array to 0.
     * 3. Iterate through the rows of the dp array, starting from 1 (say using iterator i).
     *  - For each i, iterate all the columns from j = 1 to n:
     *      a. If S1[i-1] is equal to S2[j-1], set the current element of the dp array to the
     *      value of the element to (dp[i-1][j-1] + 1).
     *      b. Else, set the current element of the dp array to the maximum value of dp[i-1][j]
     *      and dp[i][j-1].
     * 4. After the nested loops, the last element of the dp array will contain the length of
     * the LCS.
     *
     * TC: O(m * n)
     * SC: O(m * n)
     * @param s1
     * @param s2
     * @param m
     * @param n
     * @return
     */
    private static int lcs2(String s1, String s2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        for(int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        for(int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * Using DP - Memoization:
     *
     * TC: O(m * n)
     * SC: O(m * n)
     *
     * @param s1
     * @param s2
     * @param m
     * @param n
     * @return
     */
    private static int lcs1(String s1, String s2, int m, int n) {
        int[][] mem = new int[m + 1][n + 1];

        for(int[] mm : mem) {
            Arrays.fill(mm, -1);
        }

        return helper(s1, s2, m, n, mem);
    }

    private static  int helper(String s1, String s2, int m, int n, int[][] mem) {
        if(mem[m][n] != -1) {
            return mem[m][n];
        }
        if(m == 0 || n == 0) {
            mem[m][n] = 0;
        } else {
            if(s1.charAt(m - 1) == s2.charAt(n - 1)) {
                mem[m][n] = 1 + helper(s1, s2, m - 1, n - 1, mem);
            } else {
                mem[m][n] = Math.max(helper(s1, s2, m - 1, n, mem), helper(s1, s2, m, n - 1, mem));
            }
        }
        return mem[m][n];
    }

    /**
     * Using recursion: Generate all the possible subsequences and find the longest among them that
     * is present in both strings using recursion.
     *
     * 1. Create a recursive function [say lcs()].
     * 2. Check the relation between the First characters of the strings that are not yet processed.
     *      a. Depending on the relation call the next recursive function as mentioned above.
     * 3. Return the length of the LCS received as the answer.
     *
     * TC: O(2 ^ (m * n))
     * SC: O(1)
     *
     * @param s1
     * @param s2
     * @param m
     * @param n
     * @return
     */
    private static int lcs(String s1, String s2, int m, int n) {
        if(m == 0 || n == 0) {
            return 0;
        }

        if(s1.charAt(m) == s2.charAt(n)) {
            return 1 + lcs(s1, s2, m - 1, n - 1);
        } else {
            return Math.max(lcs(s1, s2, m - 1, n), lcs(s1, s2, m, n - 1));
        }
    }
}
