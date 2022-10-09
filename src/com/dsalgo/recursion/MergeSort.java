package com.dsalgo.recursion;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 1, 2, 6, 7};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    private static int[] mergeSort(int[] arr) {
        if(arr.length == 1)
            return arr;

        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        
        return merge(left, right);
    }

    private static int[] merge(int[] leftArray, int[] rightArray) {
        int[] sortedArray = new int[leftArray.length + rightArray.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < leftArray.length && j < rightArray.length) {
            if(leftArray[i] < rightArray[j]) {
                sortedArray[k++] = leftArray[i++];
            } else {
                sortedArray[k++] = rightArray[j++];
            }
        }

        while(i < leftArray.length) {
            sortedArray[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            sortedArray[k++] = rightArray[j++];
        }
        return sortedArray;
    }
}
