package com.dsalgo.sort;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
public class ChocolateDistributionProblem {

    public static void main(String[] args) {
        int[] arr = {1, 7, 2, 5, 4, 9, 12, 46};
        int m = 3;

        System.out.println(minDifference(arr, m));
    }

    /**
     * Using sorting: Sort the array first. for every m elements, check the min difference.
     *
     * TC: O(n * log n)
     * SC: O(1)
     * @param arr
     * @param m
     * @return
     */
    private static int minDifference(int[] arr, int m) {
        // if there is no chocolates or number of students is 0
        if(m == 0 || arr.length == 0) {
            return 0;
        }

        // number of students can't be more than number of packets
        if(m > arr.length) {
            return -1;
        }

        Arrays.sort(arr);

        int minDiff = arr[m-1] - arr[0];

        for(int i = 1; i+m-1 < arr.length; i++) {
            int diff = arr[i+m-1] - arr[i];
            minDiff = Math.min(diff, minDiff);
        }

        return minDiff;
    }
}
