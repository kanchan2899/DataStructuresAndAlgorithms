package com.dsalgo.arrays.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// When you find a duplicate element, only add it in the newly created subset of previous step.
// Because of above point, duplicates have to be together (sorted array)
public class ArraysSubsetsWithDuplicates {
    public static void main(String[] args) {
        int[] arr = {2,4,4};
        List<List<Integer>> subsets = subsetsDuplicates(arr);
        List<List<Integer>> emptySubsets = new ArrayList<>();
//        List<List<Integer>> subsets1 = subsetsDuplicatesRecursive(arr, 0, new ArrayList<>(), emptySubsets);
        for(List<Integer> sub : subsets) {
            System.out.println(sub);
        }
//        for(List<Integer> sub : subsets1) {
//            System.out.println(sub);
//        }

    }

    private static void subsetsDuplicatesRecursive(int[] arr, int index, List<Integer> subsets, List<List<Integer>> allSubsets) {


    }

    private static List<List<Integer>> subsetsDuplicates(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> allSubsetsList = new ArrayList<>();
        allSubsetsList.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for(int j = 0; j < arr.length; j++) {
            start = 0;
            // If current and previous elements are same, s = e + 1
            if(j > 0 && arr[j] == arr[j - 1]) {
                start = end + 1;
            }
            end = allSubsetsList.size() - 1;
            int n = allSubsetsList.size();
            for(int i = start; i < n; i++) {
                List<Integer> subsets = new ArrayList<>(allSubsetsList.get(i));
                subsets.add(arr[j]);
                allSubsetsList.add(subsets);
            }
        }
        return allSubsetsList;
    }
}
