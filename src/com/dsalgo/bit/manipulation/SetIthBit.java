package com.dsalgo.bit.manipulation;

// https://www.geeksforgeeks.org/set-k-th-bit-given-number/
public class SetIthBit {
    public static void main(String[] args) {
        int n = 10;
        int i = 2;
        System.out.println(setIthBit(n, i));
    }

    private static int setIthBit(int n, int i) {
        return (n | (1 << i));
    }
}
