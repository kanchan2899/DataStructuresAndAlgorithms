package com.dsalgo.grokking.patterns.dynamic.programming;

// https://leetcode.com/problems/maximum-product-subarray/description/
public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4, -4};
        System.out.println(maxProductSubarray(nums));
    }

    private static int maxProductSubarray(int[] nums) {
        // check if the input array is empty, return 0 if it is
        if(nums.length == 0) {
            return 0;
        }

        // initialize maxSoFar and minSoFar with the first element in the array, and result with maxSoFar
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = maxSoFar;


        // loop through the rest of the elements in the array
        for(int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            // update maxSoFar and minSoFar with the maximum and minimum of curr, maxSoFar * curr
            // and minSoFar * curr, tempSoFar is used to store the value of maxSoFar so that it does
            // not get updated while calculating minSoFar
            int tempSoFar = Math.max(curr, Math.max(maxSoFar * curr, minSoFar * curr));
            minSoFar = Math.min(curr, Math.min(maxSoFar * curr, minSoFar * curr));
            maxSoFar = tempSoFar;

            // update the result with the maximum of maxSoFar and result
            result = Math.max(maxSoFar, result);
        }

        return result;
    }
}
