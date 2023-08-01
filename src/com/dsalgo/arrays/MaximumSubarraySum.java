package com.dsalgo.arrays;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/maximum-sub-array5443/1
public class MaximumSubarraySum {
    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(maxSum(arr));
        System.out.println(maxSum1(arr));
        maxSumWithIndexes(arr);
    }

    /**
     * Kadane's algorithm to find the index of subarray.
     *
     * 1. Initialize 3 variables endIndex to 0, currMax, and
     * globalMax to first value of the input array.
     * 2. For each element in the array starting from index(say i) 1,
     * update currMax to max(nums[i], nums[i] + currMax) and
     * globalMax and endIndex to i only if currMax > globalMax.
     * 3. To find the start index, iterate from endIndex in the left direction and keep decrementing the value of globalMax until it becomes 0. The point at which it becomes 0 is the start index.
     * 4. Now print the subarray between [start, end].
     * @param arr
     */
    private static void maxSumWithIndexes(int[] arr) {
        int end_index = 0, current_max = arr[0];
        int global_max = arr[0];


        for(int i = 1; i < arr.length; i++) {
            current_max = Math.max(arr[i], arr[i] + current_max);
            if(current_max > global_max) {
                global_max = current_max;
                end_index = i;
            }
        }
        int start_index = end_index;
        while (start_index >= 0) {
            global_max -= arr[start_index];
            if(global_max == 0) {
                break;
            }
            start_index--;
        }

        for(int i = start_index; i <= end_index; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * The idea is to use Kadane's algorithm to find the maximum subarray sum and store the start
     * and end index of the subarray having maximum.
     * Initialize max_sum and max_ending to arr[0]
     * Start a loop i from 1 to n-1. max_ending should be the max of sum of previous elements and
     * the current element. Then update max_sum to the max of max_ending and max_sum.
     * Return max_sum
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    private static int maxSum1(int[] arr) {
        int max_sum = arr[0], max_ending = arr[0];
        for(int i = 1; i < arr.length; i++) {
            max_ending = Math.max(arr[i], max_ending + arr[i]);
            max_sum = Math.max(max_ending, max_sum);
        }
        return max_sum;
    }

    /**
     * Bruteforce: Initialize max_sum to arr[0]. Start a loop i from 0 to n-1.
     * Initialize current_sum to 0. Start an inner loop j from i to n-1.
     * update current_sum by adding arr[j] and assign the maximum
     * out of current_sum and max_sum to max_sum. Return max_sum
     *
     * TC: O(n^2)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    private static int maxSum(int[] arr) {
        int max_sum = arr[0];
        for(int i = 0; i < arr.length; i++) {
            int current_sum = 0;
            for(int j = i; j < arr.length; j++) {
                current_sum = current_sum + arr[j];
                max_sum = Math.max(max_sum, current_sum);
            }
        }
        return max_sum;
    }
}
