package com.dsalgo.recursion.numbers;

public class PalindromeNumber {
    public static void main(String[] args) {
        int n = 101;
        System.out.println(isPalindrome1(n));
        System.out.println(isPalindrome2(n));
    }

    private static boolean isPalindrome2(int n) {
        String num = Integer.toString(n);
        return palindrome2_helper(num, 0, num.length() - 1);
    }

    private static boolean palindrome2_helper(String num, int start, int end) {
        if(start >= end)
            return num.charAt(start) == num.charAt(end);
        return num.charAt(start) == num.charAt(end) && palindrome2_helper(num, start+1, end-1);
    }

    private static boolean isPalindrome1(int n) {
        return n == reverseNumber(n);
    }

    private static int reverseNumber(int n) {
        if(n == 0)
            return 0;
        int numOfDigits = (int) Math.log10(n) + 1;
        int rem = n % 10;
        return rem * (int) Math.pow(10, numOfDigits - 1) + reverseNumber(n / 10);
    }
}
