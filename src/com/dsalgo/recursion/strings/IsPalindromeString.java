package com.dsalgo.recursion.strings;

public class IsPalindromeString {
    public static void main(String[] args) {
        String[] str = {"abcba", "abc", "bcddcb"};
        for (String s: str) {
            System.out.println(isPalindrome(s, 0, s.length() - 1));
        }
    }

    /**
     * TC: O(n)
     * SC: O(n)
     * @param str
     * @param start
     * @param end
     * @return
     */
    private static boolean isPalindrome(String str, int start, int end) {
        if(start >= end) {
            return true;
        }
        return (str.charAt(start) == str.charAt(end) && isPalindrome(str, start+1, end-1));
    }
}
