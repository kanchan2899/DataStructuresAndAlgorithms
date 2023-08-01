package com.dsalgo.sort.selection;

import java.util.Arrays;


public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 3};
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("***************************");
        int[] arr1 = {4, 5, 1, 2, 3};
        System.out.println(Arrays.toString(arr1));
        selectionSort1(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    /**
     * Selection sort: It finds out the minimum element and place it at the first position (can be
     * done in a similar fashion if you like to pick the largest element in every pass). In second
     * pass, it places the second minimum element at position second and so on...
     *
     * - Comparison-based algo
     * - TC: O(n^2) in all cases
     * - Does less memory writesbas compared to Quick sort, merge sort and insertion sort etc. But
     * cycle sort is optimal in terms of memory writes. Memory writes are costly in EEP ROM.
     * - Not stable
     * - It lays out foundation for heap sort
     * - In-place algo
     *
     * @param arr
     */
    private static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            int lastIndex = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr, 0, lastIndex);
            swap(arr, maxIndex, lastIndex);
        }
    }

    private static int getMaxIndex(int[] arr, int start, int end) {
        int max = start;
        for(int i = 0; i <= end; i++){
            if(arr[max] < arr[i]){
                swap(arr, max, i);
            }
        }
        return max;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = temp;
    }

    /**
     * Selection sort using the minimum element in every pass.
     * @param arr
     */
    private static void selectionSort1(int[] arr) {
        // n-1 passes because at last maximum element will be at its correct place
        for(int i = 0; i < arr.length - 1; i++) {
            int min_index = i;
            // finds the minimum element index in i+1 to n-1 range
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            // swap the minimum element with ith position, where i keeps track of passes and correct
            // minimum element position
            swap(arr, min_index, i);
        }
    }
}
