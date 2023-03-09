package com.dsalgo.grokking.patterns.two.pointers;

/*
    https://www.geeksforgeeks.org/c-program-check-given-string-palindrome/

 */
public class PalindromeStrings {
    public static void main(String[] args) {
        String[] arr = {"abccba", "abc", "", "a", "abcba"};
        for(String a: arr) {
            System.out.println("********************************");
            System.out.println("Is '" + a + "' a palindrome string? " + isPalindrome1(a));
            System.out.println("Is '" + a + "' a palindrome string? " + isPalindrome2(a));
        }
    }

    /**
     * Using Bruteforce: Reverse the input string and compare with equals method if they
     * are equal. If so, return true. Else return false.
     *
     * @param a, input string
     * @return true if s is palindrome, else false
     */
    private static boolean isPalindrome1(String a) {
        String reverse = "";
        for(char c: a.toCharArray()) {
            reverse = c + reverse;
        }
        return a.equals(reverse);
    }

    /**
     * Using Two-Pointer approach: Initialize start pointer to 0 (start index)
     * and end point to s.length() - 1 (last index). Start a loop until start <= end
     * If s.charAt(start) == s.charAt(end), increment start and decrement end. Otherwise, break
     * out of the loop and return false. If traversed all the chars in the string till mid of the
     * string, return true.
     *
     * @param s, input string
     * @return true if s is palindrome, else false
     */
    private static boolean isPalindrome2(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i <= j) {
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
