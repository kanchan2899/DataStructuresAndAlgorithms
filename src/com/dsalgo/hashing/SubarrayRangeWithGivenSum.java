package com.dsalgo.hashing;

import java.util.HashMap;

// https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/
public class SubarrayRangeWithGivenSum {
    public static void main(String[] args) {
        int[][] arr = {{1, 4, 20, 3, 5}, {10, 2, -2, -20, 10}, {-10, 0, 2, -2, -20, 10}};
        int[] sum = {33, -10, 20};
        for(int i = 0; i < arr.length; i++) {
            System.out.println("Number of subarrays with sum " + sum[i] + " is "
                    + subArraySum(arr[i], sum[i]));
            System.out.println("Number of subarrays with sum " + sum[i] + " is "
                    + subArraySum1(arr[i], sum[i]));
            System.out.println("******************");
        }
    }

    private static int subArraySum1(int[] arr, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefix_sum = 0, count = 0;
        for(int i = 0; i < arr.length; i++) {
            prefix_sum += arr[i];
            if(prefix_sum == sum) {
                count++;
            }

            if(map.containsKey(prefix_sum - sum)) {
                count += map.get(prefix_sum - sum);
            }

            map.put(prefix_sum, map.getOrDefault(prefix_sum, 0) + 1);
        }
        return count;
    }

    /**
     * Using Bruteforce: Use two loops and find sum for each subarrays. Increment count accordingly
     *
     * TC: O(n^2)
     * SC: O(1)
     *
     * @param arr
     * @param sum
     * @return
     */
    static int subArraySum(int arr[], int sum) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            int current_sum = 0;
            for(int j = i; j < arr.length; j++) {
                current_sum += arr[j];
                if(current_sum == sum) {
                    count++;
                }
            }
        }
        return count;
    }
}
