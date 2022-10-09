package com.dsalgo.sort.quick;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 4, 6, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
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
