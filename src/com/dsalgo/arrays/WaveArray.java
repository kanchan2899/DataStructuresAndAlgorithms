package com.dsalgo.arrays;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/wave-array-1587115621/1
public class WaveArray {
    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 8, 9};
        convertToWave(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void convertToWave(int[] arr, int n) {
        int k = n % 2 == 0 ? n - 1 : n - 2;

        for(int i = 0; i < k; i += 2) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }
}
