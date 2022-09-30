package com.dsalgo.recursion;

public class PalindromeNumber {
    public static void main(String[] args) {
        int n = 1234321;
        System.out.println(isPalindrome(n));
    }

    private static boolean isPalindrome(int n) {
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
