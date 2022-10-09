package com.dsalgo.arrays.subsets;

import java.util.ArrayList;
import java.util.List;

// TC : O(n * 2^n) -> 2^n = number of subsets
// SC : O(2^n * n)

public class ArraysSubsets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> allSubsets = subsets(arr);
        for(List<Integer> list: allSubsets) {
            System.out.println(list);
        }
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
