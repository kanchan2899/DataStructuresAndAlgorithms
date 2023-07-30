package com.dsalgo.sort.quick;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/binary-array-sorting-1587115620/1
public class Segregate0sAnd1s {
    public static void main(String[] args) {
        int[] arr = {0, 0};
        segregate0s1s(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Using Quick Sort's Partition algo: Increment i until arr[i] == 0. Decrement j until arr[j]
     * == 1. Then swap arr[i] and arr[j]. When i >= j, break out of the loop.
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param arr
     */
    private static void segregate0s1s(int[] arr) {
        int i = -1, j = arr.length;
        while(true) {
            do {
                i++;
            } while (i < arr.length && arr[i] == 0);

            do {
                j--;
            } while (j > 0 && arr[j] == 1);

            if(i >= j) {
                return;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

    }
}
