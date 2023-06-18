package com.dsalgo.arrays;

public class LargestSumSubarray {
    public static void main(String[] args) {
        int[] arr = {-3, 4, -1, -2, 1, 5};
        System.out.println(largestSumSubarray(arr));
    }

    /**
     * The idea is to look for all the contiguous segments of the array (max_ending_here)
     * and keep the track of max sum contiguous segment among all the positive segments (max_so_far).
     * Each time we get a +ve sum, compare it with max_so_far and if it is greater than max_so_far,
     * update max_so_far
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    private static int largestSumSubarray(int[] arr) {

        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        for(int i = 0; i < arr.length; i++) {
            max_ending_here += arr[i];

            if(max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
            }

            if(max_ending_here < 0) {
                max_ending_here = 0;
            }
        }
        return max_so_far;
    }
}
