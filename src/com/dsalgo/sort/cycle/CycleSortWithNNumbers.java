package com.dsalgo.sort.cycle;

import java.util.Arrays;

// Here, integer range is [1, N], so every element should be at index = value - 1
// If integer range is [0, N], every element should be at index = value
public class CycleSortWithNNumbers {
    public static void main(String[] args) {
        int[] arr = {5, 4, 7, 6, 3, 1, 2};
        cycleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Modified Cycle sort for 1 to N range array elements: This method is only applicable when given
     * array values or elements are in the range of 1 to N or 0 to N. In this method, we do not need
     * to rotate the array. If the range is 1 to N, then every element's correct position will be
     * the index == value - 1. Similarly, for 0 to N range, correct position will be the element value
     *
     * TC: O(n) in all cases
     * SC: O(1)
     *
     * @param arr
     */
    private static void cycleSort(int[] arr) {
        int i = 0;
        while(i < arr.length){
            // as array is of 1-based indexing, so the correct position or index number of each
            // element is element - 1
            int correctIndex = arr[i] - 1;
            if(arr[i] < arr.length && arr[i] != arr[correctIndex]){
                // if array element should be lesser than size and array element should not be
                // at its correct position then only swap with its correct position or index value
                swap(arr, i, correctIndex);
            } else {
                // if element is at its correct position just increment i and check for remaining
                // array elements
                i++;
            }
        }
    }

    private static void swap(int[] arr, int i, int correctIndex) {
        int temp = arr[i];
        arr[i] = arr[correctIndex];
        arr[correctIndex] = temp;
    }
}
