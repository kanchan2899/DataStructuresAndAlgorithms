package com.dsalgo.arrays;

// https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
public class SubarrayWithSum {
    public static void main(String[] args) {
        int[] arr = {3, 2, 0, 4, 7};
        int sum = 6;
        System.out.println(doesSubarrayWithGivenSumExist(arr, sum));
        System.out.println(doesSubarrayWithGivenSumExist1(arr, sum));
    }

    /**
     * Bruteforce: Traverse all elements with loop i from 0 to n-1. Initialize current_sum to 0.
     * Start another loop j from i to n-1. Add arr[j] to current_sum. If current_sum == sum, return
     * true. Return false at the end.
     *
     * TC: O(n^2)
     * SC: O(1)
     * @param arr
     * @param sum
     * @return
     */
    private static boolean doesSubarrayWithGivenSumExist(int[] arr, int sum) {

        for(int i = 0; i < arr.length; i++) {
            int current_sum = 0;
            for(int j = i; j < arr.length; j++) {
                current_sum += arr[j];
                if(current_sum == sum) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Sliding Window: Initalize start and current_sum as 0.
     * Start a loop end from 0 to n-1. Add arr[end] to current_sum.
     * Start a while loop till sum > current_sum, remove arr[start] from current_sum and do start++
     * if current_sum == sum, return true. Return false at the end
     *
     * TC: O(n)
     * SC: O(1)
     * @param arr
     * @param sum
     * @return
     */
    private static boolean doesSubarrayWithGivenSumExist1(int[] arr, int sum) {
        int start = 0;
        int current_sum = 0;
        for(int end = 0; end < arr.length; end++) {
            current_sum += arr[end];
            while (sum < current_sum) {
                current_sum -= arr[start];
                start++;
            }
            if(current_sum == sum) {
                return true;
            }
        }
        return false;
    }
}
