package com.dsalgo.arrays.subsets;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/sum-of-all-subset-xor-totals/
public class SumOfAllSubsetXORTotals {
    public static void main(String[] args) {
        int[] nums = {2, 4, 4};
        System.out.println(sumOfAllSubsetXORTotals(nums));
        System.out.println(sumOfAllSubsetXORTotals1(nums));
    }

    private static int sumOfAllSubsetXORTotals1(int[] nums) {
        return sumOfAllSubsetsXORTotals1_helper(nums, 0, 0);
    }

    private static int sumOfAllSubsetsXORTotals1_helper(int[] nums, int index, int currentXor) {
        if(index == nums.length) return currentXor;
        int withElement = sumOfAllSubsetsXORTotals1_helper(nums, index + 1, currentXor ^ nums[index]);
        int withoutElement = sumOfAllSubsetsXORTotals1_helper(nums, index + 1, currentXor);
        return withElement + withoutElement;
    }

    private static int sumOfAllSubsetXORTotals(int[] nums) {
        int sum = 0;
        List<List<Integer>> allSubsets = subsets(nums);
        for(List<Integer> subset: allSubsets) {
            int xor = 0;
            for(int k: subset) {
                xor ^= k;
            }
            sum += xor;
        }
        return sum;
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        allSubsets.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++) {
            int n = allSubsets.size();
            for(int j = 0; j < n; j++) {
                List<Integer> sets = new ArrayList<>(allSubsets.get(j));
                sets.add(nums[i]);
                allSubsets.add(sets);
            }
        }
        return allSubsets;
    }
}
