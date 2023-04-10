package com.dsalgo.recursion.permutations;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

// https://leetcode.com/problems/permutations/
public class ArrayPermutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> processed = new ArrayList<>();
        processed.add(new ArrayList<Integer>());
//        List<List<Integer>> permutations = permutations(nums);
//        System.out.println(permutations);
        List<List<Integer>> perms = new ArrayList<>();
        List<List<Integer>> permutations = permute(nums);
        System.out.println(permutations);
    }

    private static List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        permutations.add(new ArrayList<Integer>());
        for(int n: nums) {
            ListIterator<List<Integer>> iterator = permutations.listIterator();
            while (iterator.hasNext()) {
                List<Integer> perm = iterator.next();
                iterator.remove();
                int size = perm.size();
                for(int i = 0; i <= size; i++) {
                    List<Integer> newPerm = new ArrayList<>(perm);
                    newPerm.add(i, n);
                    iterator.add(newPerm);
                }
            }
        }

        return permutations;
    }

    private static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> permutations = new ArrayList<>();
        if(nums.length == 0) {
            return permutations;
        }
        collectPermutations(nums, 0, new ArrayList<>(), permutations);
        return permutations;
    }

    private static void collectPermutations(int[] nums,
                                            int start,
                                            List<Integer> permutation,
                                            List<List<Integer>> permutations) {
        if(permutation.size() == nums.length) {
            permutations.add(permutation);
            return;
        }
        for(int i = 0; i <= permutation.size(); i++) {
            List<Integer> newPermutation = new ArrayList<>(permutation);
            newPermutation.add(i, nums[start]);
            collectPermutations(nums, start+1, newPermutation, permutations);
        }
    }


}
