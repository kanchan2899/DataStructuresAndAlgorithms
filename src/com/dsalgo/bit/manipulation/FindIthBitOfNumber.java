package com.dsalgo.bit.manipulation;

// Given a binary number, find ith bit of that number
// https://www.geeksforgeeks.org/find-value-k-th-bit-binary-representation/
public class FindIthBitOfNumber {
    public static void main(String[] args) {
        int a = 13;
        int i = 4;
        System.out.println("a = " + a);
        System.out.println(findIthBit1(a, i));
        System.out.println(findIthBit2(a, i));
    }

    private static int findIthBit2(int a, int i) {
        return ((a >> (i - 1)) % 2);
    }

    private static int findIthBit1(int a, int i) {
        return (a & (1 << (i - 1))) >> (i - 1);
    }
}
