package com.dsalgo.grokking.patterns.two.pointers;

// https://www.geeksforgeeks.org/remove-character-string-make-palindrome/
public class ValidPalindromeII {
    public static void main(String[] args) {
        String str = "abbccca";
        System.out.println(validPalindromeII(str));
    }

    private static boolean validPalindromeII(String str) {
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if(str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            } else {
                if(isPalin(str, start + 1, end) || isPalin(str, start, end - 1)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    private static boolean isPalin(String str, int i, int j) {
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
