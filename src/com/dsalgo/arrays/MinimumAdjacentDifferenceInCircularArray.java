package com.dsalgo.arrays;

// https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/problem/minimum-absloute-difference-between-adjacent-elements-in-a-circular-array-1587115620
public class MinimumAdjacentDifferenceInCircularArray {
    public static void main(String[] args) {
        int[] arr = {8,-8,9,-9,10,-11,12};
        System.out.println(minAdjDiff(arr, arr.length));
    }

    /**
     * Initialize min_diff to max int value. Start a loop i from 0 to n-1.
     * current_diff should be the absolute value of the different between arr[i] and arr[(i - 1 + n) % n]
     * min_diff should be the minimum of min_diff and current_diff.
     * Return min_diff at end
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param arr
     * @param n
     * @return
     */
    public static int minAdjDiff(int arr[], int n) {
        int min_difference = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int current_diff = Math.abs(arr[i] - arr[(i - 1 + n) % n]);
            min_difference = Math.min(current_diff, min_difference);
        }
        return min_difference;
    }
}
