package com.dsalgo.sort.insertion;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 3, 5, 6, -1, 0};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++){
            int j = i + 1;
            while(j > 0){
                if(arr[j] < arr[j - 1]){
                    swap(arr, j, j-1);
                } else {
                    break;
                }
                j--;
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
