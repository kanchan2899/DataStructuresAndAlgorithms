package com.dsalgo.recursion.bits;

// https://leetcode.com/problems/number-of-1-bits/
public class NumberOf1Bits {
    public static void main(String[] args) {
        int[] n = { 00000000000000000000000000001011,
                    00000000000000000000000010000000,
                    00000000000000000000000010011011};
        for(int x : n) {
            System.out.println("Hamming Weight of " + x + " is " + hammingWeight(x));
        }
    }
    public static int hammingWeight(int n) {
        if(n == 0) {
            return 0;
        }
        return ((n & 1) == 1 ? 1 : 0) + hammingWeight(n >>> 1);
    }
}
