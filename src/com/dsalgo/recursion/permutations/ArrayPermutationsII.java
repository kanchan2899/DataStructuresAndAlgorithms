package com.dsalgo.recursion.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/permutations-ii/
public class ArrayPermutationsII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(permutationsII(nums));
    }

    private static List<List<Integer>> permutationsII(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        if(nums.length == 0) {
            return permutations;
        }
        Arrays.sort(nums);
        collectPermutations(nums, new int[nums.length], new ArrayList<Integer>(), permutations);
        return permutations;
    }

    private static void collectPermutations(int[] nums,
                                            int[] used,
                                            List<Integer> permutation,
                                            List<List<Integer>> permutations) {
         if(permutation.size() == nums.length) {
             permutations.add(permutation);
             return;
         }

         for(int i = 0; i < nums.length; i++) {
             if(used[i] == 1 || i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0)
                 continue;
             List<Integer> newPerm = new ArrayList<>(permutation);
             newPerm.add(nums[i]);
             used[i] = 1;
             collectPermutations(nums, used, newPerm, permutations);
             used[i] = 0;
         }
    }
}
