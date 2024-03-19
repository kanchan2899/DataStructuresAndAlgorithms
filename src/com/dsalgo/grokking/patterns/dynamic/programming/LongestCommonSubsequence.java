package com.dsalgo.grokking.patterns.dynamic.programming;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "freedom";
        String str2 = "redeem";
        System.out.println(longestCommonSubsequence(str1, str2));
    }

    private static int longestCommonSubsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n][m];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(str1, str2, 0, 0, dp);
    }

    private static int helper(String str1, String str2, int i, int j, int[][] dp) {
        // the sequence when at least one string is of length 0, is 0.
        if(i == str1.length() || j == str2.length()) {
            return 0;
        } else if (dp[i][j] == -1) {
            // if current character match, increment by 1
            if(str1.charAt(i) == str2.charAt(j)) {
                dp[i][j] = 1 + helper(str1, str2, i + 1, j + 1, dp);
            } else {
                // else take max of either of two possibilities
                dp[i][j] = Math.max(helper(str1, str2, i + 1, j, dp), helper(str1, str2, i, j + 1, dp));
            }
        }
        return dp[i][j];
    }
}
