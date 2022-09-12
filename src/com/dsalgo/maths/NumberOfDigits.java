package com.dsalgo.maths;

// https://codeforces.com/blog/entry/56924
public class NumberOfDigits {
    public static void main(String[] args) {
        int n = 10;
        // If base is 10, it means decimal number system. If base is 2, then binary number system
        int base = 10;
        System.out.println(numOfDigitsInBinaryRepresentation(n, base));
    }

    private static int numOfDigitsInBinaryRepresentation(int n, int base) {
        return 1 + (int)(Math.log(n) / Math.log(base));
    }
}
