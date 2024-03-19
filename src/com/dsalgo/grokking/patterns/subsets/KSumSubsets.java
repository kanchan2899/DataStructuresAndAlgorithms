package com.dsalgo.grokking.patterns.subsets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://www.codingninjas.com/studio/problems/subset-sum-equal-to-k_1550954
public class KSumSubsets {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 2, 4};
        int k = 4;
        System.out.println(kSumSubsets(arr, k));
    }

    private static List<List<Integer>> kSumSubsets(int[] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> subsets = subsets(arr);

        for (List<Integer> subset: subsets) {
            int sum = subset.stream().mapToInt(Integer::intValue).sum();
            if(sum == k) {
                result.add(subset);
            }
        }
        return result;
    }

    static List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> allSubsetsList = new ArrayList<>();
        allSubsetsList.add(new ArrayList<>()); // For null subset

        for(int num : arr) {
            int n = allSubsetsList.size();
            for(int i = 0; i < n; i++) {
                List<Integer> subList = new ArrayList<>(allSubsetsList.get(i));
                subList.add(num);
                allSubsetsList.add(subList);
            }
        }
        return allSubsetsList;
    }
}
