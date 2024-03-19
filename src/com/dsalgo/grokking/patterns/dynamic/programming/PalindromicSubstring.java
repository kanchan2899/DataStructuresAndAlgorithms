package com.dsalgo.grokking.patterns.dynamic.programming;

// https://leetcode.com/problems/palindromic-substrings/
public class PalindromicSubstring {
    public static void main(String[] args) {
        String s = "peeweep";
        System.out.println(palindromicSubstrings(s));
    }

    private static int palindromicSubstrings(String s) {
        int count = 0;

        // initialize a lookup table of dimensions len(s) * len(s)
        boolean[][] dp = new boolean[s.length()][s.length()];

        // base case: a string with one letter is always a palindrome
        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            count++;
        }
        // base case: substring of two letters
        for(int i = 0; i < s.length() - 1; i++) {
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            count += dp[i][i + 1] ? 1 : 0;
        }

        // substrings of lengths greater than 2
        for(int length = 3; length <= s.length(); length++) {
            for(int i = 0, j = length - 1; j < s.length(); i++, j++) {
                dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                count += dp[i][j] ? 1 : 0;
            }
        }
        return count;
    }
}
