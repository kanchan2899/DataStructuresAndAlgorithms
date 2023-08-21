package com.dsalgo.strings;

public class PalindromeString {
    public static void main(String[] args) {
        String str = "ABCDCBA";
        System.out.println(isPalindrome(str));
        System.out.println(isPalindrome1(str));
    }

    /**
     * Efficient solution: Traverse from the start and last characters. If they are not equal, return
     * false. Otherwise, increment start index and decrement end index.
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param str
     * @return
     */
    private static boolean isPalindrome1(String str) {
        int begin = 0;
        int end = str.length() - 1;

        while (begin < end) {
            if(str.charAt(begin) != str.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    /**
     * Bruteforce: Create a new string and copy the original string to it. Reverse the new string.
     * Return the result of comparison of these two strings
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param str
     * @return
     */
    private static boolean isPalindrome(String str) {
        StringBuilder reverse = new StringBuilder(str);
        reverse.reverse();
        return str.equals(reverse);
    }
}
