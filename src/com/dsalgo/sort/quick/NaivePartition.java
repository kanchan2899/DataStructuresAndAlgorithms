package com.dsalgo.sort.quick;

import java.util.Arrays;

public class NaivePartition {
    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 12, 10, 7, 6, 9};
        int pIndex = arr.length - 1; // index of pivot, which is the last element in this case

        System.out.println(Arrays.toString(naivePartition(arr, 0, arr.length - 1, pIndex)));
    }

    /**
     * Naive Partition: In this partition helps to maintain the relative order of the elements
     * but this partition takes O(n) extra space.
     *
     * 1. Make a Temporary array temp[r-l+1] length
     * 2. Choose last element as a pivot element
     * 3. Run two loops:
     *     -> Store all the elements in the temp array that are less than pivot element
     *     -> Store the pivot element
     *     -> Store all the elements in the temp array that are greater than pivot element.
     * 4.Update all the elements of arr[] with the temp[] array
     *
     * TC: O(n) -> 3 traversals
     * SC: O(n)
     *
     * @param arr
     * @param start
     * @param end
     * @param pIndex
     * @return
     */
    private static int[] naivePartition(int[] arr, int start, int end, int pIndex) {
        // Creating temporary array
        int[] temp = new int[end - start + 1];

        // Choosing pivot
        int pivot = arr[pIndex];
        int index = 0;

        // Place smaller numbers in temp array
        for(int i = start; i <= end; i++) {
            if(arr[i] < pivot) {
                temp[index++] = arr[i];
            }
        }
        // pivot position
        int position = index;

        //  Placing the pivot to its original position
        temp[index++] = pivot;

        // Place greater numbers in temp array
        for(int i = start; i <= end; i++) {
            if(arr[i] > pivot) {
                temp[index++] = arr[i];
            }
        }

        // Change the original array
        for(int i = start; i <= end; i++) {
            arr[i] = temp[i - start];
        }

        // Return the modified array
        return arr;
    }
}
