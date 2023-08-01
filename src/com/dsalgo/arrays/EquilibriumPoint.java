package com.dsalgo.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

// https://www.geeksforgeeks.org/equilibrium-index-of-an-array/?ref=gcse
public class EquilibriumPoint {
    public static void main(String[] args) {
        long[] arr = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(equilibriumPoint(arr, arr.length));
        System.out.println(equilibriumPoint1(arr, arr.length));
        System.out.println(equilibriumPoint2(arr, arr.length));
        System.out.println(equilibriumPoint3(arr, arr.length));
    }


    /**
     * Bruteforce approach: Iterate for each index i and calculate the leftsum and rightsum
     * and check whether they are equal.
     *
     *
     * TC: O(n^2)
     * SC: O(1)
     */
    private static int equilibriumPoint1(long[] arr, int length) {
        for(int i = 0; i < length; i++) {
            int left_sum = 0;
            for(int j = 0; j < i; j++) {
                left_sum += arr[j];
            }
            int right_sum = 0;
            for(int j = i + 1; j < arr.length; j++) {
                right_sum += arr[j];
            }

            if(left_sum == right_sum) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Bruteforce: Calculate the total sum first. Iterate for each index j from 1
     *  to n-1 and calculate the left_sum by just adding arr[i-1] and right_sum
     *  and check by subtracting current element and left_sum from totalSum.
     *  If left_sum == right_sum, return the index.
     *
     * TC: O(n)
     * SC: O(1)
     * @param arr
     * @param n
     * @return
     */
    public static int equilibriumPoint(long arr[], int n) {
        int equilibriumPoint = -1;
        if(n <= 1) {
            equilibriumPoint = n;
        }
        long sumLeft = 0;
        long sumRight = 0;
        long totalSum = 0;


        for(int j = 0; j < arr.length; j++) {
            totalSum += arr[j];
        }

        for(int i = 1; i < arr.length; i++) {
            sumLeft += arr[i - 1];
            sumRight = totalSum - arr[i] - sumLeft;
            if(sumRight == sumLeft) {
                equilibriumPoint = i;
            }
        }
        return equilibriumPoint;
    }

    /**
     * Using prefix sum: Calculate prefix_sum and suffix_sum.
     * Traverse the array from 1 to n-2 and check if prefix_sum[i-1] == suffix_sum[i+1].
     * If so, return i. Otherwise return -1;
     *
     * TC: O(n)
     * SC: O(n)
     *
     */
    public static int equilibriumPoint2(long arr[], int n) {
        long[] prefix_sum = new long[n];
        long[] suffix_sum = new long[n];

        prefix_sum[0] = arr[0];
        for(int i = 1; i < n; i++) {
            prefix_sum[i] = prefix_sum[i - 1] + arr[i];
        }

        suffix_sum[0] = prefix_sum[n - 1];
        for(int i = 1; i < n; i++) {
            suffix_sum[i] = suffix_sum[i - 1] - arr[i - 1];
        }

        for(int i = 1; i < n-1; i++) {
            if(prefix_sum[i-1] == suffix_sum[i+1]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Instead of prefix_sum and suffix_sum, store the total sum in a variable.
     * Initialize left_sum as 0
     * Start a loop i from 0 to n-1. Subtract current element from total_sum (to get the right sum)
     * If right_sum == left_sum, return i. Add current element to left_sum for next iteration.
     * Return -1 at the end.
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param arr
     * @param n
     * @return
     */
    public static int equilibriumPoint3(long[] arr, int n) {
        int total_sum = 0;
        for(int i = 0; i < n; i++) {
            total_sum += arr[i];
        }
        int left_sum = 0;
        for(int i = 0; i < n; i++) {
            total_sum -= arr[i];
            if(total_sum == left_sum) {
                return i;
            }
            left_sum += arr[i];
        }
        return -1;
    }
}
