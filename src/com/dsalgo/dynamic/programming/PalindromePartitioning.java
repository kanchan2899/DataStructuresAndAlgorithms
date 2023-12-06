package com.dsalgo.dynamic.programming;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String str = "abbacdaaba";
        System.out.println(palindromePartitioning(str, 0, str.length() - 1));
        System.out.println(palindromePartitioning1(str));
    }

    /**
     * Using DP - Tabulation
     *
     * TC: O(n ^ 3)
     * SC: O(n ^ 2)
     *
     * @param str
     * @return
     */
    private static int palindromePartitioning1(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        for(int gap = 1; gap < n; gap++) {
            for(int i = 0; i + gap < n; i++) {
                int j = i + gap;
                if(isPalindrome(str, i, j)) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i][k] + dp[k + 1][j]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    /**
     * Using Recursion
     *
     * 1. If the current string is a palindrome, then we simply return true, as Palindrome Partitioning is possible.
     * 2. Else we try making cuts at all possible places,
     *      - recursively calculate the cost for each cut
     * 3. return the minimum value.
     *
     *
     * @param str
     * @param i
     * @param j
     * @return
     */
    private static int palindromePartitioning(String str, int i, int j) {
        if(i >= j || isPalindrome(str, i, j)) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) {
            res = Math.min(res, 1 + palindromePartitioning(str, i, k) +
                    palindromePartitioning(str, k + 1, j));
        }
        return res;
    }

    private static boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
