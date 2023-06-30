package com.dsalgo.arrays;

import java.util.Arrays;

/**
 * Given an array arr[] of size n, its prefix sum array is another array prefixSum[] of the same size,
 * such that the value of prefixSum[i] is arr[0] + arr[1] + arr[2] … arr[i].
 */
public class PrefixSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int queries[][]  = { { 2, 3 }, { 4, 6 }, { 1, 5 }, { 3, 6 } };
        int[] prefix_sum = prefix_sum(arr);

        for(int[] query: queries) {
            int l = query[0] - 1;
            int r = query[1] - 1;

            if(l - 1 > 0) {
                System.out.println(prefix_sum[r] - prefix_sum[l - 1]);
            } else {
                System.out.println(prefix_sum[r]);
            }
        }
    }

    /**
     * To fill the prefix sum array, we run through index 1 to last and
     * keep on adding the present element with the previous value in the prefix sum array.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param arr
     * @return
     */
    private static int[] prefix_sum(int[] arr) {
        int[] prefix_sum = new int[arr.length];
        prefix_sum[0] = arr[0];

        for(int i = 1; i < arr.length; i++) {
            prefix_sum[i] = prefix_sum[i - 1] + arr[i];
        }
        return prefix_sum;
    }
}
