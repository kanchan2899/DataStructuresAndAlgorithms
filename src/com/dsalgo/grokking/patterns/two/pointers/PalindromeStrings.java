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
     * Time complexity: O(n)
     * Space complexity: O(1)
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
     * Using Two-Pointer approach: Traverse the array from the start and the end at the same time
     * until you reach the middle of the string. Compare the char at start and end index.
     * Return true if all char at start and end are equal, else return false.
     *
     * Algorithm:
     *
     * 1. Initialize start pointer to 0 (start index) and end point to s.length() - 1 (last index).
     * 2. Start a loop until start <= end
     * 3. If s.charAt(start) == s.charAt(end), increment start and decrement end.
     * 4. Otherwise, break out of the loop and return false.
     * 5. If traversed all the chars in the string till mid of the string, return true.
     *
     * Time complexity: O(n) - logically traversing till mid of the array, not its length
     * Space complexity: O(1)
     *
     * @param s, input string
     * @return true if s is palindrome, else false
     */
    private static boolean isPalindrome2(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
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
