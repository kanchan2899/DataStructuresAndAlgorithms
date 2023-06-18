package com.dsalgo.arrays;

// https://practice.geeksforgeeks.org/problems/largest-sum-subarray-of-size-at-least-k3121/1
public class LargestSumSubarrayOfSizeAtleastK {
    public static void main(String[] args) {
        long[] arr = {1, 1, 1, 1, 1, 1};
        int k = 2;
        System.out.println(maxSumWithK(arr, k));
    }

    public static long maxSumWithK(long a[], long k) {
        long max_sum = Integer.MIN_VALUE;
        int i, j = 0;
        for(i = 0; i < a.length; i++) {
            int curr_sum = 0;
            for(j = 0; j <= i; j++) {
                curr_sum += a[j];
                max_sum = Math.max(max_sum, curr_sum);
            }
        }
        if((j - i + 1) >= k) {
            return max_sum;
        }
        return -1;
    }
}
