package com.dsalgo.recursion.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 1, 3, 8, 7, 6};
        selectionSort1(arr, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {4, 1, 3, 6, 7, 9, 5, 10};
        selectionSort2(arr1, arr1.length - 1, 0, 0);
        System.out.println(Arrays.toString(arr1));
    }

    private static void selectionSort2(int[] arr, int row, int col, int max_index) {
        if(row == 0) return;
        if(col < row) {
            if(arr[col] > arr[max_index]) {
                selectionSort2(arr, row, col + 1, col);
            } else {
                selectionSort2(arr, row, col + 1, max_index);
            }
        } else {
            int temp = arr[max_index];
            arr[max_index] = arr[row - 1];
            arr[row - 1] = temp;
            selectionSort2(arr, row - 1, 0, 0);
        }
    }

    private static void selectionSort1(int[] arr, int lastIndex) {
        if(lastIndex == 0)
            return;
        int maxIndex = maxIndex(arr, lastIndex);
        swap(arr, maxIndex, lastIndex);

        selectionSort1(arr, lastIndex - 1);
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
