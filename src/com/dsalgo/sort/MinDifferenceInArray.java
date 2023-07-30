package com.dsalgo.sort;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/minimum-difference-pair5444/1
public class MinDifferenceInArray {
    public static void main(String[] args) {
        int[] arr = {10, 3, 20, 12};
        System.out.println(minDifference(arr));
        System.out.println(minDifference1(arr));
    }


    /**
     * Using sorting: Sort the array and traverse the array to compare the difference
     * between the current element and previous element.
     *
     *
     * TC: O(n * log n)
     * SC: O(1)
     * @param arr
     * @return
     */
    private static int minDifference1(int[] arr) {
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i = 1; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - arr[i-1]);
            minDiff = Math.min(diff, minDiff);
        }
        return minDiff;
    }

    /**
     * Bruteforce: use two loops two generate every pair of elements and compare them to get
     * the minimum difference
     *
     * TC: O(n^2)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    private static int minDifference(int[] arr) {
        int minDifference = Integer.MAX_VALUE;
        for(int i = 1; i < arr.length; i++) {
            for(int j = 0; j < i; j++) {
                minDifference = Math.min(minDifference, Math.abs((arr[i] - arr[j])));
            }
        }
        return minDifference;
    }
}
