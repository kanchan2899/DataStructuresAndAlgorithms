package com.dsalgo.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://practice.geeksforgeeks.org/problems/smallest-positive-missing-number-1587115621/1
public class SmallestPositiveMissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("The missing number is " + missingNumber(arr, arr.length));
        System.out.println("The missing number is " + missingNumber1(arr, arr.length));
    }

    /**
     * Create a set and add all elements to the set. Initialize count to 1.
     * Start a while loop till count <= size. If set contains count, increment count. Else, break
     * the loop. Return count.
     *
     * TC: O(n)
     * SC: O(n)
     * @param arr
     * @param n
     * @return
     */
    private static int missingNumber1(int[] arr, int n) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(arr[i]);
        }
        int count = 1;
        while (count <= n) {
            if(!set.contains(count)) {
                break;
            } else {
                count++;
            }
        }
        return count;
    }

    /**
     * Bruteforce: Sort the array and initialize current = 1. Start a loop i from 0 to n-1.
     * If arr[i] == current, increment current. Otherwise, continue the loop.
     * Return the current value'
     *
     * TC: O(n * log n)
     * SC: O(1)
     * @param arr
     * @param n
     * @return
     */
    static int missingNumber(int arr[], int n) {
        int current = 1;
        Arrays.sort(arr);
        for(int i = 0; i < n; i++) {
            if(arr[i] == current) {
                current++;
            } else {
                continue;
            }
        }
        return current;
    }
}
