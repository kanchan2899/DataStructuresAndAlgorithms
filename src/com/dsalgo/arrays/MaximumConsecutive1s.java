package com.dsalgo.arrays;

// https://practice.geeksforgeeks.org/problems/maximum-consecutive-ones/1
public class MaximumConsecutive1s {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1};
        System.out.println(maximumConsecutiveOnes(arr));
        System.out.println(maximumConsecutiveOnes1(arr));
    }

    /**
     * The idea is to use only one loop. Initialize current_count and ones_count to 0
     * Start a loop i from 0 to n-1. If arr[i] is 0, reset the current_count to 0, else increment
     * the current_count and update ones_count to the max of ones_count and current_count.
     * Return ones_count at end.
     *
     * TC: O(n)
     * SC: O(1)
     * @param arr
     * @return
     */
    private static int maximumConsecutiveOnes1(int[] arr) {
        int ones_count = 0;
        int current_count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                current_count = 0;
            } else {
                current_count++;
                ones_count = Math.max(ones_count, current_count);
            }
        }
        return ones_count;
    }

    /**
     * Bruteforce: Initialize ones_count to 0. Start a loop i from 0 to n-1.
     * Initialize current_count to 0. Start an inner loop j from i to n-1.
     * If arr[j] == 1, update current_count, else break out of loop j. In loop i, assign the maximum
     * out of ones_count and current_count to ones_count. Return ones_count
     *
     * TC: O(n^2)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    private static int maximumConsecutiveOnes(int[] arr) {
        int ones_count = 0;
        for(int i = 0; i < arr.length; i++) {
            int current_count = 0;
            for(int j = i; j < arr.length; j++) {
                if(arr[j] == 1) {
                    current_count++;
                } else {
                    break;
                }
            }
            ones_count = Math.max(current_count, ones_count);
        }
        return ones_count;
    }
}
