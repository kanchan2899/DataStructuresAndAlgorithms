package com.dsalgo.hashing;

import java.util.HashMap;

/*  I/P: a[] = {5, 8, -4, -4, 9, -2, 2}, sum = 0
    O/P = 3 {8, -4, -4}

    I/P: a[] = {3, 1, 0, 1, 8, 2, 3, 6}, sum = 5
    O/P: 4 {3, 1, 0, 1}

    I/P: a[] = {8, 3, 7}, sum = 15
    O/P: 0

    https://www.geeksforgeeks.org/longest-sub-array-sum-k/
 */
public class LongestSubArrayWithGivenSum {
    public static void main(String[] args) {
        int[][] arr = {
                {-13, 0, 6, 15, 16, 2, 15, -12, 17, -16, 0, -3, 19, -3, 2, -9, -6},
                {5, 8, -4, 0, -4, 9, -2, 2},
                {3, 1, 0, 1, 8, 2, 3, 6},
                {8, 3, 7}
        };
        int[] sum = {
                0,
                5,
                15,
                15
        };

        for(int i = 0; i < arr.length; i++) {
            System.out.println("Using Bruteforce: " + largestSubarrayWithSum1(arr[i], sum[i]));
            System.out.println("Using HashSet: " + largestSubarrayWithSum2(arr[i], sum[i]));
            System.out.println("*********************");
        }
    }

    /**
     * Using Bruteforce: Initialize largest_subarray_len to 0.
     * Start a loop i from 0 to n - 1. Initialize current_count to 0 to keep track of current sum.
     * Start another loop j from i to n - 1. Add arr[j] to cuurent_sum. If current_sum == sum and
     * (j - i + 1) > largest_subarray_len, assign (j - i + 1) to largest_subarray_len as it represents
     * the length of the current_sum, which may be the largest subarray with current_sum == sum.
     *
     * Time complexity = O(n^2)
     * Space complexity = O(1)
     *
     * @param arr contains real numbers.
     * @param sum
     * @return the largest subarray length with sum
     */
    private static int largestSubarrayWithSum1(int[] arr, int sum) {
        int largestSubarrayLength = 0;
        for(int i = 0; i < arr.length; i++) {
            int current_sum = 0;
            for(int j = i; j < arr.length; j++) {
                current_sum += arr[j];
                if(current_sum == sum && (j - i + 1 > largestSubarrayLength)) {
                        largestSubarrayLength = j - i + 1;
                }
            }
        }

        return largestSubarrayLength;
    }


    private static int largestSubarrayWithSum2(int[] arr, int sum) {
        int largest_subarray_len = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int current_sum = 0;
        for(int i = 0; i < arr.length; i++) {
            current_sum += arr[i];
            if(current_sum == sum) {
                largest_subarray_len = i + 1;
            }
            if(!hashMap.containsKey(current_sum)) {
                hashMap.put(current_sum, i);
            }
            if(hashMap.containsKey(current_sum - sum)) {
                largest_subarray_len = Math.max(largest_subarray_len, i - hashMap.get(current_sum - sum));
            }
        }
        return largest_subarray_len;
    }
}
