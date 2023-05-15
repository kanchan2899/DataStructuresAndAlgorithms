package com.dsalgo.recursion.strings;


import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/count-ways-to-build-good-strings/
public class CountWaysToBuildGoodStrings {
    public static void main(String[] args) {
        int low = 2, high = 3, zero = 1, one = 2;
        System.out.println(countGoodStrings(low, high, zero, one));
    }


    public static int countGoodStrings(int low, int high, int zero, int one) {
        return helper(low, high, zero, one, 0);
    }

    private static int helper(int low, int high, int zero, int one, int i) {
        if(i > high) {
            return 0;
        }
        int count = 0;

        if(low <= i && i <= high) {
            count = 1;
        }

        int left = helper(low, high, zero, one, i + zero);
        int right = helper(low, high, zero, one, i + one);

        return count + left + right;
    }
}
