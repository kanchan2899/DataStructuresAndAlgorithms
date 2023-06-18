package com.dsalgo.arrays;

// https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/problem/check-if-array-is-sorted-and-rotated-clockwise-1587115620

// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
public class IsArraySortedAndRotated {
    public static void main(String[] args) {
        int[] arr = {10, 20, 14};
        System.out.println("Is array sorted and rotated? " + isSortedAndRotated(arr));
        System.out.println("Is array sorted and rotated? " + isSortedAndRotated1(arr));
    }

    /**
     * GFG Problem
     *
     * TC: O(n)
     * @param arr
     * @return
     */
    private static boolean isSortedAndRotated1(int[] arr) {
        int sortedAndRotatedCount = 0;
        int sortedAndNotRotatedCount = 0;
        int n = arr.length;

        for(int i = 0; i < n - 1; i++) {
            if(arr[i] > arr[i + 1] && arr[0] > arr[n - 1]) {
                sortedAndRotatedCount++;
            }
            if(arr[i] < arr[i + 1] && arr[0] < arr[n - 1]) {
                sortedAndNotRotatedCount++;
            }
            if(sortedAndNotRotatedCount > 1 || sortedAndRotatedCount > 1) {
                return false;
            }
        }

        if(sortedAndNotRotatedCount == 1 || sortedAndRotatedCount == 1) {
            return true;
        }
        return false;
    }

    /**
     * Leetcode problem
     * TC: O(n)
     * @param arr
     * @return
     */
    private static boolean isSortedAndRotated(int[] arr) {
        int k = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > arr[(i + 1) % arr.length]) {
                k++;
            }
            if(k > 1) {
                return false;
            }
        }
        return true;
    }
}
