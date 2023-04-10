package com.dsalgo.recursion.sorting;

import java.util.Arrays;

// Recursive Insertion Sort
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(insertionSort(arr, 1)));
    }

    private static int[] insertionSort(int[] arr, int pass) {
        if(pass >= arr.length){
            return arr;
        }
        int key = arr[pass];
        int j = pass - 1;
        while(j >= 0 && arr[j] > key){
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
        return insertionSort(arr, pass + 1);
    }
}
