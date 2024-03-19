package com.dsalgo.grokking.patterns.bitwise.manipulation;

import java.util.Map;

// https://leetcode.com/problems/complement-of-base-10-integer/description/
public class ComplementOfBase10Integers {
    public static void main(String[] args) {
        int x = 42;
        System.out.println(complement(x));
    }

    private static int complement(int x) {
        // if the number is 0, return 1
        if(x == 0) {
            return 1;
        }

        // converting the value into its binary representation and counting the number of
        // bits required by this number
        int bitCount = (int) Math.floor((int) (Math.log(x) / Math.log(2))) + 1;

        // compute the all bits set of the number
        int allBitsSet = (int) Math.pow(2, bitCount) - 1;

        // flip all bits of number by taking xor with allSetBits
        return x ^ allBitsSet;
    }
}
