package com.dsalgo.sort.quick;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 4, 6, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {4, 1, 3, 9, 7};
        quickSort1(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));


        int[] arr2 = {4, 1, 3, 9, 7, 6, 2};
        quickSort2(arr2, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr2));
    }

    private static void quickSort2(int[] arr, int low, int high) {
        if(low < high) {
            int pivot = partition1(arr, low, high);

            quickSort2(arr, low, pivot);
            quickSort2(arr, pivot+1, high);
        }
    }

    /**
     * Hoare's partition: Hoare’s Partition Scheme works by initializing two indexes that start
     * at two ends, the two indexes move toward each other until an inversion is (A smaller value
     * on the left side and greater value on the right side) found. When an inversion is found,
     * two values are swapped and the process is repeated.
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static int partition1(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;
        while (true) {
            // Find leftmost element greater than or equal to pivot
            do {
                i++;
            } while (arr[i] < pivot);
            // Find rightmost element smaller than or equal to pivot
            do {
                j--;
            } while (arr[j] > pivot);
            // If two pointers are met, return j
            if(i >= j) {
                return j;
            }

            // swap the greatest element on the left with the smallest element on the right
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    /**
     * Quick sort: Using lomuto's partition
     *
     * TC: O(n * log n) in average and best case, O(n^2) in worst case
     * SC: O(1)
     *
     *
     * @param arr
     * @param low
     * @param high
     */
    private static void quickSort1(int[] arr, int low, int high) {
        if(low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort1(arr, low, pivotIndex - 1);
            quickSort1(arr, pivotIndex + 1, high);
        }
    }

    /**
     * This partition function takes last element as pivot, places the pivot element at its correct
     * position in sorted array, and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right  of pivot
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static int partition(int[] arr, int low, int high) {
        // last element as pivot
        int pivot = arr[high];

        // index of smaller element
        int i = low - 1;

        for(int j = low; j <= high - 1; j++) {
            if(arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int start = low;
        int end = high;
        int m = start + (end - start) / 2;
        int pivot = arr[m];

        while (start <= end) {
            // If array is alreadyy sorted, it won't swap
            while (arr[start] < pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }
            // Swap if pivot > arr[end] && pivot < arr[start]
            if(start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        quickSort(arr, low, end);
        quickSort(arr, start, high);

    }
}
