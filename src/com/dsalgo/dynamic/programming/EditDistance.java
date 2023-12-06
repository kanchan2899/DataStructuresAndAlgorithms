package com.dsalgo.dynamic.programming;

import java.util.Arrays;

// https://www.geeksforgeeks.org/edit-distance-dp-5/
public class EditDistance {
    public static void main(String[] args) {
        String a = "sunday";
        String b = "saturday";

        System.out.println(editDistance(a, b, a.length(), b.length()));
        System.out.println(editDistance1(a, b, a.length(), b.length()));
        System.out.println(editDistance2(a, b, a.length(), b.length()));
    }

    /**
     * Using DP - memoization:
     * @param a
     * @param b
     * @param m
     * @param n
     * @return
     */
    private static int editDistance2(String a, String b, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++)
            Arrays.fill(dp[i], -1);
        return helper(a, b, m, n, dp);
    }

    private static int helper(String a, String b, int m, int n, int[][] dp) {
        if(m == 0) {
            return n;
        }

        if(n == 0) {
            return m;
        }

        if(dp[m][n] != -1) {
            return dp[m][n];
        }

        // If characters are equal, execute recursive function for n-1, m-1
        if(a.charAt(m - 1) == b.charAt(n - 1)) {
            return dp[m][n] = helper(a, b, m - 1, n - 1, dp);
        } else {
            int insert, del, replace;

            insert = helper(a, b, m, n - 1, dp);
            del = helper(a, b, m - 1, n, dp);
            replace = helper(a, b, m - 1, n - 1, dp);

            return dp[m][n] = 1 + Math.min(insert, Math.min(del, replace));
        }
    }

    /**
     *
     * Using DP - Tabulation: Use a table to store solutions of subproblems to avoiding recalculate
     * the same subproblems multiple times. By doing this, if same subproblems repeated during,
     * we retrieve the solutions from the table itself.
     *
     *
     *
     * TC: O(m * n)
     * SC: O(m * n)
     *
     * @param a
     * @param b
     * @param m
     * @param n
     * @return
     */
    private static int editDistance1(String a, String b, int m, int n) {
        // Create a table to store results of subproblems
        int[][] dp = new int[m + 1][n + 1];

        // Fill dp[][] in bottom up manner
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                // If first string is empty, only option is to insert all characters of second string
                if(i == 0) {
                    dp[i][j] = j;       // min operations = j
                }

                // If second string is empty, only option is to remove all characters of first string
                else if(j == 0) {
                    dp[i][j] = i;       // min operations = i
                }

                // If last characters are same, ignore last char and recur for remaining string
                else if(a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // If the last character is different,  consider all possibilities and find the minimum
                else {
                    dp[i][j] = 1 + min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * Using Recursion: The idea is to process all characters one by one starting from either from left
     * or right sides of both strings. There are two possibilities for every pair of character
     * being traversed.
     *
     * m: Length of str1 (first string)
     * n: Length of str2 (second string)
     *
     * If last characters of two strings are same, nothing much to do. Ignore last characters and
     * get count for remaining strings. So we recur for lengths m-1 and n-1.
     * Else (If last characters are not same), we consider all operations on 'str1', consider all
     * three operations on last character of first string, recursively compute minimum cost for all
     * three operations and take minimum of three values.
     * 1. Insert: Recur for m and n-1
     * 2. Remove: Recur for m-1 and n
     * 3. Replace: Recur for m-1 and n-1
     *
     * TC: O(3 ^ m)
     *
     * @param a
     * @param b
     * @param m
     * @param n
     * @return
     */
    private static int editDistance(String a, String b, int m, int n) {
        // If first string is empty, the only option is to insert all characters of second
        // string into first
        if(m == 0) {
            return n;
        }

        // If second string is empty, the only option is to remove all characters of first string
        if(n == 0) {
            return m;
        }

        // If last characters of two strings are same, nothing much to do. Ignore last characters
        // and get count for remaining strings.
        if(a.charAt(m - 1) == b.charAt(n - 1)) {
            return editDistance(a, b, m - 1, n - 1);
        }

        // If last characters are not same, consider all three operations on last character of first
        // string, recursively compute minimum cost for all three operations and take minimum of
        // three values.
        return (1 + min(editDistance(a, b, m, n - 1),      // insert
                editDistance(a, b, m - 1, n),             // remove
                editDistance(a, b, m - 1, n - 1))      // replace
                );

    }

    private static int min(int x, int y, int z) {
        if(x <= y && x <= z) {
            return x;
        }
        if(y <= z && y <= z) {
            return y;
        } else {
            return z;
        }
    }
}
