package com.dsalgo.sort.cycle;

import java.util.Arrays;

// Here, integer range is [1, N], so every element should be at index = value - 1
// If integer range is [0, N], every element should be at index = value
public class CycleSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 7, 6, 3, 1, 2};
        cycleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void cycleSort(int[] arr) {
        int i = 0;
        while(i < arr.length){
            int correctIndex = arr[i] - 1;
            if(arr[i] != arr[correctIndex]){
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int i, int correctIndex) {
        int temp = arr[i];
        arr[i] = arr[correctIndex];
        arr[correctIndex] = temp;
    }
}
