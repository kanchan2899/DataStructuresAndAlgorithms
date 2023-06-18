package com.dsalgo.arrays;

// https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/article/MjYwMA%3D%3D
public class SumQueriesUsingPrefixSum {
    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 2, 5};
        int q = 3;
        int[][] left_right = {{0, 3}, {2, 4}, {1, 3}};

        for(int i = 0; i < q; i++) {
            range_sum(arr, left_right[i][0], left_right[i][1]);
        }
    }

    /**
     * Using Prefix sum: Calcuate the prefix sum in another array. If l == 0, return prefix_sum[r].
     * Else return the difference between prefix_sum[r] - prefix_sum[l - 1]
     *
     * TC: O(n)
     * SC: O(n) for prefix array
     * @param arr
     * @param l
     * @param r
     */
    private static void range_sum(int[] arr, int l, int r) {
        int[] prefix_sum = new int[arr.length];
        prefix_sum[0] = arr[0];
        int range_sum = 0;
        for(int i = 1; i < arr.length; i++) {
            prefix_sum[i] = prefix_sum[i - 1] + arr[i];
        }

        if(l == 0) {
            range_sum = prefix_sum[r];
        } else {
            range_sum = prefix_sum[r] - prefix_sum[l - 1];
        }
        System.out.println(range_sum);
    }
}
