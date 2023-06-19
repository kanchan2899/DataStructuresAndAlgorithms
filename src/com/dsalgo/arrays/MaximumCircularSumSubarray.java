package com.dsalgo.arrays;

//https://practice.geeksforgeeks.org/problems/max-circular-subarray-sum-1587115620/1
public class MaximumCircularSumSubarray {
    public static void main(String[] args) {
        int[] arr = {8, -8, 9, -9, 10, -11, 12};
        System.out.println(maxCircularSum(arr));
        System.out.println(maxCircularSum1(arr));
    }

    private static int normalSum(int[] arr) {
        int max_sum = arr[0];
        int max_ending = arr[0];

        for(int i = 1; i < arr.length; i++) {
            max_ending = Math.max(arr[i], max_ending + arr[i]);
            max_sum = Math.max(max_ending, max_sum);
        }
        return max_sum;
    }


    /**
     * Using Kadanes' algo: The maximum of below two is the maximum circular sum of the subarray:
     * 1. Max sum of the normal subarray (Kadane's algo)
     * 2. Max sum of a circular subarray
     *
     * TC: O(n)
     * SC:O(1)
     *
     * @param arr
     * @return
     */
    private static int maxCircularSum1(int[] arr) {
        int max_normal = normalSum(arr);

        // If all elements are negative, normalSum will give the maximum value (sum)
        // Important condition if all elements are negative, because the below code will invert the
        // array and arr_sum is always 0. Max of negative number and 0 is 0, which is incorrect.
        if(max_normal < 0) {
            return max_normal;
        }

        // To calculate the circular sum.
        int arr_sum = 0;

        // Invert the array elements to find out the minimum sum in the original array
        for(int i = 0; i < arr.length; i++) {
            arr_sum += arr[i];
            arr[i] = -arr[i];
        }
        // Instead of subtracting the minimum sum, add the normal sum of the inverted array
        int max_circular = arr_sum + normalSum(arr);

        return Math.max(max_circular, max_normal);
    }

    /**
     * Bruteforce algo: For every element in loop i, start a loop j from 1 to n-1.
     * index of first starting element will be (i + j) % n. Find the current_max using this index
     * instead of j.
     *
     * TC: O(n^2)
     * SC: O(1)
     * @param arr
     * @return
     */
    private static int maxCircularSum(int[] arr) {
        int max_sum = arr[0];
        for(int i = 0; i < arr.length; i++) {
            int current_sum = arr[i];
            int current_max = arr[i];

            for(int j = 1; j < arr.length; j++) {
                int index = (i + j) % arr.length;
                current_sum += arr[index];
                current_max = Math.max(current_max, current_sum);
            }
            max_sum = Math.max(max_sum, current_max);
        }
        return max_sum;
    }
}
