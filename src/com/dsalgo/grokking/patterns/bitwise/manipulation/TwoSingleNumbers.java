package com.dsalgo.grokking.patterns.bitwise.manipulation;

import java.util.Arrays;

// https://leetcode.com/problems/single-number-iii/description/
public class TwoSingleNumbers {
    public static void main(String[] args) {
        int[] arr = {1, 1, 7, 4, 5, 5, 8, 8};
        System.out.println(Arrays.toString(twoSingleNumbers(arr)));
    }

    private static int[] twoSingleNumbers(int[] arr) {
        int bitwise = 0;

        for(int a : arr) {
            bitwise ^= a;
        }

        // the least significant bit can be found with number ^ (-number)
        int bitmask = bitwise & (-bitwise);

        // divide into two groups of numbers, here we want the group with bit set which results
        // in one of the numbers we want due to the property x ^ x = 0
        int result = 0;

        for(int i : arr) {
            if((bitmask & i) != 0) {
                result = result ^ i;
            }
        }

        int[] res = new int[2];
        res[0] = result;
        res[1] = bitwise ^ result;

        return res;
    }
}
