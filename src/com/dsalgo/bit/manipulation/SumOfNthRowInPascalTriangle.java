package com.dsalgo.bit.manipulation;

// https://www.geeksforgeeks.org/sum-of-all-elements-up-to-nth-row-in-a-pascals-triangle/
public class SumOfNthRowInPascalTriangle {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(sum(n));
    }

    private static int sum(int n) {
        return 1 << (n - 1);
    }
}
