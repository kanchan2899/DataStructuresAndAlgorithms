package com.dsalgo.hashing;

import java.util.HashSet;

// https://practice.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1
/*
    I/P: a = [4, 2, -3, 1, 6]
    O/P: Yes

    I/P: a = [4, 2, 0, 1, 6]
    O/P: Yes

    I/P: a = [3, 1, -2, 5, 6]
    O/P: No
 */
public class SubarrayWithZeroSum {
    public static void main(String[] args) {
        int[][] arr = {{4, 2, -3, 1, 6}, {4, 2, 0, 1, 6}, {3, 1, -2, 5, 6}};
        for(int[] a : arr) {
            System.out.println("Using Bruteforce: " + subarrayWithZeroSum1(a));
            System.out.println("Using HashSet: " + subarrayWithZeroSum2(a));
            System.out.println("************************");
        }
    }


    /**
     * Using Bruteforce: Start loop i from 0 to n. Initialize current_sum to 0
     * Start another loop j from i to n. Add value of a[j] to current_sum and check if it is equal to 0
     * If it is, return true. Else return false.
     *
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     *
     * @param a array
     * @return true if subarray sum is zero, else false.
     */
    private static boolean subarrayWithZeroSum1(int[] a) {
        for(int i = 0; i < a.length; i++) {
            int current_sum = 0;
            for(int j = i; j < a.length; j++){
                current_sum += a[j];
                if(current_sum == 0) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     *
     * Using Prefix sum and hashing: Create a hashset and initialize prefix_sum to 0.
     * Loop through array a and add a[i] to prefix_sum.
     * If hashset contains prefix_sum, return true. Else add prefix_sum to the hashset.
     * In the end, return false - meaning that no subarray exists with sum equals 0.
     *
     * Prefix Sum: a[0], a[1], ..., a[i-1], a[i], a[i+1], ...., a[j] ...., a[n-1]
     * prefix_sum1 = a[0] + a[1] + a[2] + ... + a[i-1]
     * prefix_sum2 = a[i] + a[i+1] ... + a[j]
     * If prefix_sum1 == prefix_sum2, that means a subarray exists with sum 0
     *
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param a that may contain negative values
     * @return if the subarray exists with sum=0
     */

    private static boolean subarrayWithZeroSum2(int[] a) {
        HashSet<Integer> prefix_sums = new HashSet<>();
        int prefix_sum = 0;
        for(int i = 0; i < a.length; i++) {
            prefix_sum += a[i];
            if(prefix_sums.contains(prefix_sum)) {
                return true;
            }
            // If prefix sum itself is 0, return true. To handle cases like {-3, 2, 1, 4}
            if(prefix_sum == 0) {
                return true;
            }
            prefix_sums.add(prefix_sum);
        }
        return false;
    }
}
