package com.dsalgo.recursion;

public class ReverseNumber {
    static int sum = 0;
    public static void main(String[] args) {
        int n = 12345;
        reverseNumber1(n);
        System.out.println(sum);
        System.out.println(reverseNumber2(n));
    }

    private static int numberOfDigits(int n) {
        return (int)Math.log10(n) + 1;
    }

    private static int reverseNumber2(int n) {
        int numberOfDigits = (int) Math.log10(n) + 1;
        if(n == 0)
            return 0;
        int rem = n % 10;
        return rem * (int)Math.pow(10, numberOfDigits - 1) + reverseNumber2(n/10);
    }

    private static void reverseNumber1(int n) {
        if(n == 0)
            return;
        int rem = n % 10;
        sum = sum * 10 + rem;
        reverseNumber1(n / 10);
    }
}
