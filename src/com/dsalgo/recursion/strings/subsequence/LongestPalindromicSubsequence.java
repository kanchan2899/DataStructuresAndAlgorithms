package com.dsalgo.recursion.strings.subsequence;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String[] str = {"bbbab", "cbbd"};
        for(String s: str) {
            System.out.println(longestPalindromicSubsequence(s));
        }
    }

    private static int longestPalindromicSubsequence(String s) {
        return helper(s, "", 0);
    }

    private static int helper(String s, String processed, int longestLength) {
        if(s.isEmpty()) {
            if(processed.length() > longestLength && isPalindromic(processed)) {
                longestLength = processed.length();
            }
            return longestLength;
        }

        int left = helper(s.substring(1), processed, longestLength);
        int right = helper(s.substring(1), processed + s.charAt(0), longestLength);

        return left > right ? left : right;
    }

    private static boolean isPalindromic(String processed) {
        if(processed.isEmpty() || processed == "") {
            return false;
        }
        int s = 0, e = processed.length() - 1;
        while (s < (processed.length()/2)) {
            if(processed.charAt(s) == processed.charAt(e)) {
                s++;
                e--;
            } else {
                return false;
            }
        }
        return true;
    }
}
