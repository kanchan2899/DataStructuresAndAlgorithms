package com.dsalgo.grokking.patterns.dynamic.programming;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/
public class CombinationSum {
    public static void main(String[] args) {
        int[] nums = {20, 25, 30, 35, 40};
        int target = 60;
        System.out.println(combinationSum(nums, target));
    }

    private static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<List<Integer>>> dp = new ArrayList<>(target + 1);
        dp.add(new ArrayList<>());
        dp.get(0).add(new ArrayList<>());

        // for each value from 1 to target
        for(int i = 1; i <= target; i++) {
            dp.add(new ArrayList<>());
            for(int j = 0; j < nums.length; j++) {
                if(nums[j] <= i) {
                    // checking previous results from dp
                    for(List<Integer> prev : dp.get(i - nums[j])) {
                        List<Integer> temp = new ArrayList<>(prev);
                        temp.add(nums[j]);
                        temp.sort(null);

                        // if the new combination is not already in dp
                        if(!dp.get(i).contains(temp)) {
                            dp.get(i).add(temp);
                        }
                    }
                }
            }
        }
       return dp.get(target);
    }
}
