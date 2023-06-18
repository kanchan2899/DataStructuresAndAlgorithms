package com.dsalgo.arrays;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately-1587115620/1
public class RearrangeArrayAlternately {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        rearrangeArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * The idea is to store 2 values at a single index in an array and higher values are at even
     * position and lower values are at odd index.
     *
     * Initialize min_index to 0, max_index to n-1 and max_element to max element of the array + 1
     * (so the modulo never become zero).
     *
     * TC: O(n)
     * SC: O(1)
     * @param arr
     */
    private static void rearrangeArray(int[] arr) {
        int min_index = 0;
        int max_index = arr.length - 1;
        int max_element = arr[arr.length - 1] + 1;

        for(int i = 0; i < arr.length; i++) {
            if(i % 2 == 0) {
                arr[i] = (arr[max_index] % max_element) * max_element + arr[i];
                max_index--;
            } else {
                arr[i] = (arr[min_index] % max_element) * max_element + arr[i];
                min_index++;
            }
        }

        for(int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / max_element;
        }
    }
}
