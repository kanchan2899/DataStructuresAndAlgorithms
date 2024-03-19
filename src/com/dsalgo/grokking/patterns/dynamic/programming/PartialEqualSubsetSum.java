package com.dsalgo.grokking.patterns.dynamic.programming;

import java.util.Arrays;

// https://leetcode.com/problems/partition-equal-subset-sum/
public class PartialEqualSubsetSum {
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }

    private static boolean canPartition(int[] nums) {
        int arraySum = 0;

        arraySum = Arrays.stream(nums).sum();

        // if total sum is odd, it cannot be partitioned into equal sum subsets
        if(arraySum % 2 != 0) {
            return false;
        }

        // calculate the subset sum
        int subsetSum = arraySum / 2;

        // create a lookup table and fill all entries with FALSE
        boolean[][] dp = new boolean[subsetSum + 1][nums.length + 1];

        // initialize the first row as TRUE as each array has a subset whose sum is zero
        for(int i = 0; i <= nums.length; i++) {
            dp[0][i] = true;
        }

        // fill the lookup table in a bottom-up manner
        for(int i = 1; i <= subsetSum; i++) {
            for(int j = 1; j <= nums.length; j++) {
                if(nums[j - 1] > i) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - nums[j - 1]][j - 1] || dp[i][j - 1];
                }
            }
        }
        return dp[subsetSum][nums.length];
    }
}
