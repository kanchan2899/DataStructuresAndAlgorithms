package com.dsalgo.recursion.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/target-sum/description/
public class TargetSum {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        int target = 1;
        System.out.println(findTargetSumWays(arr, target));
    }

    private static int findTargetSumWays(int[] arr, int target) {
        return helper(arr, target, 0, 0);
    }

    private static int helper(int[] arr, int target, int i, int sum) {
        if(i == arr.length) {
            if(sum == target)
                return 1;
            return 0;
        }

        int positive = helper(arr, target, i + 1, sum + arr[i]);
        int negative = helper(arr, target, i + 1, sum - arr[i]);
        return positive + negative;
    }


}
