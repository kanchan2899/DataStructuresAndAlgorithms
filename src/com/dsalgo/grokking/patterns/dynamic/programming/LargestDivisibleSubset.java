package com.dsalgo.grokking.patterns.dynamic.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/largest-divisible-subset/description/
public class LargestDivisibleSubset {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 8};
        System.out.println(largestDivisibleSubset(nums));
    }

    private static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.sort(nums);

        int maxSize = 1, maxIndex = 0;

        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if(dp[i] > maxSize) {
                        maxSize = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }

        int num = nums[maxIndex];
        for(int i = maxIndex; i >= 0; i--) {
            if(num % nums[i] == 0 && dp[i] == maxSize) {
                subset.add(nums[i]);
                num = nums[i];
                maxSize--;
            }
        }

        return subset;
    }
}
