package com.dsalgo.hashing;

import java.util.HashSet;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[][] arr = {{5, 8, 6, 13, 3, -1}, {15, 2, 8, 10, -5, -8, 6}, {3, 2, 5, 6}};
        int[] sum = {22, 3, 10};

        for(int i = 0; i < arr.length; i++) {
            System.out.println("Using Bruteforce: " + subarrayWithGivenSum1(arr[i], sum[i]));
            System.out.println("Using HashSet: " + subarrayWithGivenSum2(arr[i], sum[i]));
            System.out.println("************************");
        }
    }

    /**
     * Using Bruteforce: Start a loop i from 0 to n. Initialize current_sum = 0;
     * Start another loop j from i + 1 to n, keep adding a[j] to current_sun and check if current_sum == sum.
     * If it is, return true. Else return false
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     *
     * @param arr with unsorted elements
     * @param sum
     * @return true if arr contains a contiguous subarray a[i...j] with sum == sum
     */
    private static boolean subarrayWithGivenSum1(int[] arr, int sum) {
        for(int i = 0; i < arr.length; i++) {
            int current_sum = 0;
            for(int j = i; j < arr.length; j++) {
                current_sum += arr[j];
                if(current_sum == sum) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Using HashSet: Start a loop i from 0 to n. Initialize prefix_sum = 0;
     * Add the current element to prefix_sum and check if sum-prefix_sum already in the hashset.
     * If so, return true. Else, add the prefix_sum to the hashset.
     *
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param arr with unsorted elements
     * @param sum
     * @return true if arr contains a contiguous subarray a[i...j] with sum == sum
     */
    private static boolean subarrayWithGivenSum2(int[] arr, int sum) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(0);
        int prefix_sum = 0;
        for(int i : arr) {
            prefix_sum += i;
            if(prefix_sum == sum) return true;
            if(hashSet.contains(prefix_sum - sum)) {
                return true;
            }
            hashSet.add(prefix_sum);
        }
        return false;
    }
}
