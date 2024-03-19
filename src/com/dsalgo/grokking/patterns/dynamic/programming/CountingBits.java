package com.dsalgo.grokking.patterns.dynamic.programming;

import java.util.Arrays;

// https://leetcode.com/problems/counting-bits/description/
public class CountingBits {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(Arrays.toString(countingBits(n)));
    }

    private static int[] countingBits(int n) {
        int[] result = new int[n + 1];

        // if n is 0, return the empty array
        if(n == 0) {
            return result;
        }

        // set the first two elements of the array
        result[0] = 0;
        result[1] = 1;

        for(int i = 2; i <= n; i++) {
            // if x is even, set the x-th element of the array to the (x / 2)-th element
            if(i % 2 == 0) {
                result[i] = result[i / 2];
            }
            // If x is odd, set the x-th element of the array to
            // the (x / 2)-th element + 1
            else {
                result[i] = result[i / 2] + 1;
            }
        }


        return result;
    }
}
