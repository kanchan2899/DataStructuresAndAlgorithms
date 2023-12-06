package com.dsalgo.dynamic.programming;

import java.util.Arrays;

// https://www.geeksforgeeks.org/shortest-common-supersequence/?ref=header_search
public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        String str1 = "AGGTAB", str2 = "GXTXAYB";
        System.out.println(shortestCommonSupersequence(str1, str2));
        System.out.println(shortestCommonSupersequence1(str1, str2, str1.length(), str2.length()));
        System.out.println(shortestCommonSupersequence2(str1, str2, str1.length(), str2.length()));
        System.out.println(shortestCommonSupersequence3(str1, str2, str1.length(), str2.length()));
    }

    private static int shortestCommonSupersequence3(String str1, String str2, int m, int n) {
        int[][] lookup = new int[m + 1][n + 1];
        return helper(str1, str2, m, n, lookup);
    }

    private static int helper(String str1, String str2, int m, int n, int[][] lookup) {
        if(m == 0 || n == 0) {
            return lookup[m][n] = n + m;
        }

        if(lookup[m][n] == 0) {
            if(str1.charAt(m - 1) == str2.charAt(n - 1)) {
                lookup[m][n] = 1 + helper(str1, str2, m - 1, n - 1, lookup);
            } else {
                lookup[m][n] = Math.min(helper(str1, str2, m, n - 1, lookup) + 1,
                                        helper(str1, str2, m - 1, n, lookup) + 1);
            }
        }
        return lookup[m][n];
    }

    /**
     * Using DP - Tabulation
     *
     * TC: O(m * n)
     * SC: O(m * n)
     *
     * @param str1
     * @param str2
     * @param m
     * @param n
     * @return
     */
    private static int shortestCommonSupersequence2(String str1, String str2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0) {
                    dp[i][j] = j;
                } else if(j == 0) {
                    dp[i][j] = i;
                } else if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * Using recursion
     *
     *   if (m == 0) return n;
     *   if (n == 0) return m;
     *
     *   // If last characters are same, then
     *   // add 1 to result and
     *   // recur for X[]
     *   if (X[m - 1] == Y[n - 1])
     *      return 1 + SCS(X, Y, m - 1, n - 1);
     *
     *   // Else find shortest of following two
     *   //  a) Remove last character from X and recur
     *   //  b) Remove last character from Y and recur
     *   else
     *     return 1 + min( SCS(X, Y, m - 1, n), SCS(X, Y, m, n - 1) );
     *
     *  TC: O(2 ^ (min(m, n)))
     *  SC: O(min(m, n))
     *
     * @param str1
     * @param str2
     * @param m
     * @param n
     *
     * @return
     */
    private static int shortestCommonSupersequence1(String str1, String str2, int m, int n) {
       if(m == 0) {
           return n;
       }
       if(n == 0) {
           return m;
       }

       if(str1.charAt(m - 1) == str2.charAt(n - 1)) {
           return 1 + shortestCommonSupersequence1(str1, str2, m - 1, n - 1);
       }

       return 1 + Math.min(shortestCommonSupersequence1(str1, str2, m - 1, n),
                            shortestCommonSupersequence1(str1, str2, m, n -1));
    }

    /**
     * Using LCS:
     *
     * 1. Find Longest Common Subsequence (lcs) of two given strings.
     * 2. Insert non-lcs characters (in their original order in strings) to the lcs found above,
     * and return the result. So “ek” becomes “geeke” which is shortest common supersequence.
     *
     * How does this work?
     * We need to find a string that has both strings as subsequences and is the shortest such string.
     * If both strings have all characters different, then result is sum of lengths of two given
     * strings. If there are common characters, then we don’t want them multiple times as the task
     * is to minimize length. Therefore, we first find the longest common subsequence, take one
     * occurrence of this subsequence and add extra characters.
     *
     * Length of the shortest supersequence = (Sum of lengths of given two strings) -
     *                                          (Length of LCS of two given strings)
     *
     * TC = O(m * n)
     * SC = O(m * n)
     *
     * @param str1
     * @param str2
     * @return
     */
    private static int shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int lcs = lcs(str1, str2, m, n);

        // Result is sum of input string lengths - length of lcs
        return (m + n - lcs);
    }

    // Returns length of LCS for X[0..m - 1], Y[0..n - 1]
    private static int lcs(String str1, String str2, int m, int n) {
        int[][] lcs = new int[m + 1][n + 1];
        int i, j;

        // Note that L[i][j] contains length of LCS of X[0..i - 1]and Y[0..j - 1]
        for(i = 0; i <= m; i++) {
            for (j = 0; j <= n; j++) {
                if(i == 0 || j == 0) {
                    lcs[i][j] = 0;
                }
                else if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        return lcs[m][n];
    }



}
