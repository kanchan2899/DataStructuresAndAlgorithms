package com.dsalgo.arrays;

// https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/video/MTQwMw%3D%3D

/**
 * arr = {5, 10, 20, 6, 3, 8} -> 3
 * Return the maximum length of even odd subarray.
 * Subarray starting element can be either even or odd.
 */
public class LongestEvenOddSubarray {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 5, 4, 1};
        System.out.println(maxEvenOdd(arr));
        System.out.println(maxEvenOdd1(arr));
    }

    /**
     * Kadane's algorithm: By simply storing the nature of the previous element we encounter
     * ( odd or even) and comparing it with the next element.
     *
     * 1. Initialize a variable maxLength to 0, to keep the track of maximum length of the
     * alternating subarray obtained.
     * 2. Initialize a variable currLen to 1 considering first element
     * as the part of alternating subarray.
     * 3. Starting with element at index 1, compare every element with it’s previous.
     * If there nature are different, increment the currLen variable.
     * 4. Otherwise, reset the currLen to 1 again so that,
     * this current element is considered in new alternating subarray.
     * 5. Keep storing the max length of subarray in maxLength before resetting the currLen.
     * 6. Return the found max length of subarray.
     * @param arr
     * @return
     */
    private static int maxEvenOdd1(int[] arr) {
        int max_length = 1;
        int current_length = 1;

        for(int i = 1; i < arr.length; i++) {
            if((arr[i] % 2 == 0 && arr[i - 1] % 2 != 0) || arr[i] % 2 != 0 && arr[i - 1] % 2 == 0) {
                current_length++;
                max_length = Math.max(current_length, max_length);
            } else {
                current_length = 1;
            }
        }
        return max_length;
    }

    /**
     * Bruteforce:
     * 1. Iterate for every subarray from i = 0
     * 2. Make a nested loop, iterate from j = i + 1
     * 3. Now, check if a[j – 1] is even and a[j] is odd or a[j – 1] is odd and a[j] is even then increment count
     * 4. Maintain an answer variable which calculates max count so far
     *
     * TC: O(n^2)
     * SC: O(1)
     * @param arr
     * @return
     */
    private static int maxEvenOdd(int[] arr) {
        int max_length = 1;

        for(int i = 0; i < arr.length; i++) {
            int current_length = 1;
            for(int j = i + 1; j < arr.length; j++) {
                if((arr[j] % 2 == 0 && arr[j-1] % 2 != 0) || (arr[j] % 2 != 0 && arr[j-1] % 2 == 0)) {
                    current_length++;
                }
            }
            max_length = Math.max(current_length, max_length);
        }
        return max_length;
    }
}
