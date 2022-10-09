package com.dsalgo.recursion;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 1, 3, 8, 7, 6};
        selectionSort(arr, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr, int lastIndex) {
        if(lastIndex == 0)
            return;
        int maxIndex = maxIndex(arr, lastIndex);
        swap(arr, maxIndex, lastIndex);

        selectionSort(arr, lastIndex - 1);
    }

    private static void swap(int[] arr, int maxIndex, int lastIndex) {
        int temp = arr[maxIndex];
        arr[maxIndex] = arr[lastIndex];
        arr[lastIndex] = temp;
    }

    private static int maxIndex(int[] arr, int endIndex) {
        int max = Integer.MIN_VALUE;
        int j = -1;
        for(int i = 0; i <= endIndex; i++){
            if(max < arr[i]) {
                max = arr[i];
                j = i;
            }
        }
        return j;
    }
}
