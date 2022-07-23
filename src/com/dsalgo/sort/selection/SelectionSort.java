package com.dsalgo.sort.selection;

import java.util.Arrays;


public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 3};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            int lastIndex = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr, 0, lastIndex);
            swap(arr, maxIndex, lastIndex);
        }
    }

    private static int getMaxIndex(int[] arr, int start, int end) {
        int max = start;
        for(int i = 0; i <= end; i++){
            if(arr[max] < arr[i]){
                swap(arr, max, i);
            }
        }
        return max;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = temp;
    }
}
