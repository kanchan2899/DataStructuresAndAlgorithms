package com.dsalgo.sort.merge;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {6, 3, 1, 2, 4, 5};
        mergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Merge sort: is a Divide and Conquer algorithm. It divides the input array in two halves,
     * calls itself for the two halves and then merges the two sorted halves. The merge() function
     * is used for merging two halves. The merge(arr, l, m, r) is key process that assumes that
     * arr[l..m] and arr[m+1..r] are sorted and merges the two sorted sub-arrays into one in a
     * sorted manner.
     *
     * - Divide and conquer algo -> divide/conquer/merge
     * - Stable algo
     * - In-place algo
     * - TC: O(n * log n) in all cases
     * - SC: O(n) for temp array and O(log n) stack space
     * - Well suited for linked lists with O(1) space
     * - Used in external sorting
     * - For arrays, in general, quick sort outperforms merge sort
     *
     * @param arr
     * @param start
     * @param end
     */
    private static void mergeSort(int[] arr, int start, int end) {
        if(end - start == 1)
            return;
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] sortedArray = new int[end - start];
        int i = start;
        int j = mid;
        int k = 0;
        while(i < mid && j < end) {
            if(arr[i] < arr[j]) {
                sortedArray[k++] = arr[i++];
            } else {
                sortedArray[k++] = arr[j++];
            }
        }

        while(i < mid) {
            sortedArray[k++] = arr[i++];
        }

        while (j < end) {
            sortedArray[k++] = arr[j++];
        }

        for(int l = 0; l < sortedArray.length; l++) {
            arr[start + l] = sortedArray[l];
        }
    }
}
