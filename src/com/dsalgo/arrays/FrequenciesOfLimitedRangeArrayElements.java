package com.dsalgo.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://practice.geeksforgeeks.org/problems/frequency-of-array-elements-1587115620/1
public class FrequenciesOfLimitedRangeArrayElements {
    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 3, 5};
        int p = 5;
        frequencyCount(arr, arr.length, p);
        frequencyCount1(arr, arr.length, p);
    }

    /**
     * The idea is to store 2 values at an index in array. Initialize pMax to the maximum value of p
     * plus 1. Start a loop from 0 to n-1. Calculate a by doing arr[i] mod pMax.
     * If a <= n, then update (a - 1)th index to arr[a - 1] + pMax.
     * Start another loop to extract the values by dividing the element value by pMax.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param arr
     * @param n
     * @param p
     */
    private static void frequencyCount1(int[] arr, int n, int p) {
        int pMax = 40001;

        int a;
        for(int i = 0; i < n; i++) {
            a = arr[i] % pMax;
            if(a <= n) {
                arr[a - 1] += pMax;
            }
        }

        for(int i = 0; i < n; i++) {
            arr[i] = arr[i] / pMax;
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Using HashMap: Store the frequency of elements in a hash map. Start a loop i from 1 to n
     * If map contains the i, print that. Else, print 0.
     *
     * TC: O(n)
     * SC: O(n)
     * @param arr
     * @param n
     * @param p
     */
    public static void frequencyCount(int arr[], int n, int p) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for(int i = 1; i <= n; i++) {
            if(map.containsKey(i)) {
                System.out.print(map.get(i) + " ");
            } else {
                System.out.print(0 + " ");
            }
        }
    }
}
