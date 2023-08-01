package com.dsalgo.sort;

import java.util.*;

// https://practice.geeksforgeeks.org/problems/sort-by-absolute-difference-1587115621/1
public class SortByAbsoluteDifference {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(10, 5, 3, 9, 2);
        int k = 7;
        System.out.println(sortByAbsoluteDifference(arr, k));
    }

    /**
     * Using library functions: Use the Comparator class from java collections and pass it to the
     * Collections.sort() function
     *
     * TC: O(n * log n)
     * SC: O(1)
     *
     * @param arr
     * @param k
     * @return
     */
    private static List<Integer> sortByAbsoluteDifference(List<Integer> arr, int k) {
        Collections.sort(arr, Comparator.comparingInt(a -> Math.abs(k - a)));
        return arr;
    }
}
