package com.dsalgo.sort.quick;

import java.util.Arrays;

public class HoaresPartition {
    public static void main(String[] args) {
        int[] arr = {11, 8, 6, 12, 10, 7, 6, 9};
        // Hoare's partition assumes partition at last index

        System.out.println(Arrays.toString(hoaresPartition(arr, 0, arr.length - 1)));
    }

    /**
     * Hoare's partition: Hoare’s Partition Scheme works by initializing two indexes that start
     * at two ends, the two indexes move toward each other until an inversion is
     * (A smaller value on the left side and a greater value on the right side) found.
     * When an inversion is found, two values are swapped and the process is repeated.
     *
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private static int[] hoaresPartition(int[] arr, int start, int end) {
        int pivot = arr[start];

        int i = start - 1;
        int j = end + 1;

        while (true) {
            // Find leftmost element greater than or equal to pivot
            do {
                i++;
            } while (arr[i] < pivot);

            //  Find rightmost element smaller than or equal to pivot
            do {
                j--;
            } while (arr[j] > pivot);

            // if two pointers are met
            if(i >= j) {
                return arr;
            }

            // swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
