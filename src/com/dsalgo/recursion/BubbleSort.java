package com.dsalgo.recursion;

import java.util.Arrays;

// Recursive bubble sort
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(bubbleSort(arr, arr.length)));
    }

    private static int[] bubbleSort(int[] arr, int n) {
        if(n == 1){
            return arr;
        }
        for(int j = 0; j < n - 1; j++){
            if(arr[j] > arr[j+1]){
                swap(arr, j, j+1);
            }
        }
        return bubbleSort(arr, n - 1);
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
