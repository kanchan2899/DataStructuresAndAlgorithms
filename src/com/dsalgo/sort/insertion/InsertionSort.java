package com.dsalgo.sort.insertion;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 3, 5, 6, -1, 0};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Insertion sort: . The array is virtually split into a sorted and an unsorted part.
     * Values from the unsorted part are picked and placed at the correct position in the
     * sorted part.
     *
     *
     * Make 2 partitions in the array i.e. sorted and unsorted.
     * First element is always in the sorted subarray. So start with 1st index and place the 1st index
     * element in the sorted array and repeat for the rest of the elements.
     *
     * - TC: O(n^2) in worst case when array is reverse sorted and O(n) in best case when array is sorted
     * - In-place algo
     * - stable algo
     * - Widely used for small inputs
     * - Used by Tim and Intro sorts
     *
     * Steps:
     * 1. Iterate from arr[1] to arr[N] over the array.
     * 2. Compare the current element (key) to its predecessor.
     * 3. If the key element is smaller than its predecessor, compare it to the elements before.
     * Move the greater elements one position up to make space for the swapped element.
     *
     * @param arr
     */
    private static void insertionSort(int[] arr) {
        // First element is already at its place in the sorted subarray
        for(int i = 1; i < arr.length; i++){
            // Save the next element right after the sorted subarray
            int key = arr[i];
            // find the correct position of key in the left sorted array
            int j = i - 1;
            // arr[j] > key makes sures the stability of the algo.
            // If it was arr[j] >= key, then we would have place the same element at a position before
            // the same element in the sorted array
            while(j >= 0 && arr[j] > key){
                // shift greater elements to right to make space for key
                arr[j + 1] = arr[j];
                j--;
            }
            // Place key at the correct position in the sorted array
            arr[j + 1] = key;
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
