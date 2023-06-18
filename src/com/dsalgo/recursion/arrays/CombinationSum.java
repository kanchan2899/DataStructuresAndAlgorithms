package com.dsalgo.recursion.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/combination-sum/description/
public class CombinationSum {
    public static void main(String[] args) {
        int[] nums = {2, 3};
        int target = 6;
        System.out.println(combinationSum(nums, target));
        System.out.println(combinationSum1(nums, target));
    }

    private static List<List<Integer>> combinationSum1(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        helper1(nums, target, list, new ArrayList<>(), 0);
        return list;
    }

    private static void helper1(int[] nums,
                                               int target,
                                               List<List<Integer>> list,
                                               ArrayList<Integer> temp,
                                               int startIndex) {
        if(startIndex >= nums.length || target < 0) {
            return;
        }

        if(target == 0 && !list.contains(temp)) {
            list.add(new ArrayList<>(temp));
        }

        // Not taking the ith element
        helper1(nums, target, list, temp, startIndex+1);

        // Taking the ith element
        temp.add(nums[startIndex]);
        helper1(nums, target - nums[startIndex], list, temp, startIndex);
        temp.remove(temp.size() - 1);
    }

    private static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, target, list, new ArrayList<>(), 0);
        return list;
    }

    private static void helper(int[] nums,
                               int remainingTarget,
                               List<List<Integer>> list,
                               List<Integer> tempList,
                               int start) {
        if(remainingTarget < 0) {
            return;
        }
        else if(remainingTarget == 0) {
            list.add(new ArrayList<>(tempList));
        }
        for(int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            helper(nums, remainingTarget - nums[i], list, tempList, i);
            tempList.remove(tempList.size() - 1);
        }
    }

}
