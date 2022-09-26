package com.dsalgo.bit.manipulation;

// https://www.geeksforgeeks.org/program-to-clear-k-th-bit-of-a-number-n/
public class ResetIthBit {
    public static void main(String[] args) {
        int n = 5;
        int  i = 1;

        System.out.println(resetIthBit(n, i));
    }

    private static int resetIthBit(int n, int i) {
        return (n & ~(1 << (i - 1)));
    }
}
