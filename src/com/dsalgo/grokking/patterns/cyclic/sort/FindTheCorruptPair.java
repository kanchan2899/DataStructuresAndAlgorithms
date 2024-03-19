package com.dsalgo.grokking.patterns.cyclic.sort;

import java.util.Arrays;

// https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
public class FindTheCorruptPair {
    public static void main(String[] args) {
        int[] arr = {3,1,2,5,2};
        System.out.println(Arrays.toString(corruptPair(arr)));
    }

    private static int[] corruptPair(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if(arr[i] <= arr.length && arr[i] != arr[correctIndex]) {
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            } else {
                i++;
            }
        }

        for(int j = 0; j < arr.length; j++) {
            if(arr[j] != j + 1) {
                int[] result = new int[2];
                result[1] = arr[j];
                result[0] = j + 1;
                return result;
            }
        }
        return new int[]{0, 0};
    }
}
