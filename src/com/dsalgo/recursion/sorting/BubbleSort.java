package com.dsalgo.recursion.sorting;

import java.util.Arrays;

// Recursive bubble sort
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(bubbleSort1(arr, arr.length)));
        int[] arr1 = {6, 5, 4, 3, 2, 1};
        bubbleSort2(arr1, arr1.length - 1, 0);
        System.out.println(Arrays.toString(arr1));
    }

    private static void bubbleSort2(int[] arr, int row, int col) {
        if(row == 0) return;
        if(col < row) {
            if(arr[col] > arr[col + 1]) {
                swap(arr, col, col+1);
            }
            bubbleSort2(arr, row, col + 1);
        } else {
            bubbleSort2(arr, row - 1, 0);
        }
    }

    private static int[] bubbleSort1(int[] arr, int n) {
        if(n == 1){
            return arr;
        }
        for(int j = 0; j < n - 1; j++){
            if(arr[j] > arr[j+1]){
                swap(arr, j, j+1);
            }
        }
        return bubbleSort1(arr, n - 1);
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
