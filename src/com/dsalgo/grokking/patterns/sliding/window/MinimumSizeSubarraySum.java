package com.dsalgo.grokking.patterns.sliding.window;

// https://leetcode.com/problems/minimum-size-subarray-sum/
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(arr, target));
    }

    private static int minSubArrayLen(int[] arr, int target) {
        // Initializing windowSize to a max number
        int windowSize = Integer.MAX_VALUE;
        int currentSubArraySize = 0;

        int start = 0, sum = 0;

        // iterate over the input array
        for(int end = 0; end < arr.length; end++) {
            sum += arr[end];

            // check if we can remove elements from the start of the subarray while still satisfying
            // the target condition

            while (sum >= target) {
                // finding size of current subarray
                currentSubArraySize = (end + 1) - start;
                windowSize = Math.min(windowSize, currentSubArraySize);
                sum -= arr[start];
                start += 1;
            }
        }

        if(windowSize != Integer.MAX_VALUE) {
            return windowSize;
        }
        return 0;
    }
}
