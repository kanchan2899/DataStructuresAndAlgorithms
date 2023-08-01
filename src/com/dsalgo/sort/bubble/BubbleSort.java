package com.dsalgo.sort.bubble;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {5, 8 ,6, 4, 2, 3, 1, 7};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("**********************");
        int arr1[] = {5, 8 ,6, 4, 2, 3, 1, 7};
        System.out.println(Arrays.toString(arr1));
        bubbleSortOptimized1(arr1);
        System.out.println(Arrays.toString(arr1));
        System.out.println("**********************");
        int arr2[] = {5, 8 ,6, 4, 2, 3, 1, 7};
        System.out.println(Arrays.toString(arr2));
        bubbleSortOptimized2(arr2);
        System.out.println(Arrays.toString(arr2));
    }



    /**
     * Bubble sort: The basic idea is to sort the array in n-1 passes and in every pass compare current
     * element with the next element and if current element is greater, swap these two elements.
     *
     * - Comparison-based algo
     * - in-place algo
     * - stable algo
     * - TC: O(n^2) in worst case when array is sorted in descending order (maximum number of swaps)
     * and O(n) in best case when array is sorted in ascending order (no swaps but n comparisons)
     * - SC: (1)
     *
     * @param arr
     */
    static void bubbleSort(int[] arr){
        // Run the steps n-1 times, i.e n-1 passes
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - 1; j++){
                // Swap if current element is greater than the next element
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


    /**
     * In previous implementation, we do comparisons till the end of array in every pass even though
     * last i elements got sorted in every pass. Hence, to optimize the number of comparisons,
     * run the j loop from 0 to n - i - 1. This will leave out the sorted elements in every pass.
     *
     *
     * @param arr
     */
    static void bubbleSortOptimized1(int[] arr){
        // Run the steps n-1 times, i.e n-1 passes
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                // Swap if current element is greater than the next element
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /**
     * Another optimization that could be done is stop the passes if the array is already sorted.
     * If the array is already sorted, it will be go into if condition at line 87. Hence, we can
     * use a false to indicate if there's any swap happened in a particular pass. If no swaps,
     * that means array got sorted now an you break out of the passes loop.
     *
     * TC: O(n) in best case when the array is already sorted
     * TC: O(n^2) in worst case when the array is sorted in opposite order
     *
     * @param arr
     */
    private static void bubbleSortOptimized2(int[] arr) {
        // Keep a flag to indicate if there's any swap in a pass.
        boolean swapped = false;
        // Run the steps n-1 times, i.e n-1 passes
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                // Swap if current element is greater than the next element
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) {
                break;
            }
        }
    }
}
