package com.dsalgo.sort.merge;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {6, 3, 1, 2, 4, 5};
        mergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

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
