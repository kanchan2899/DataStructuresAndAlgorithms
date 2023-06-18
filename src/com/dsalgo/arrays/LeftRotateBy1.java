package com.dsalgo.arrays;

import java.util.Arrays;

public class LeftRotateBy1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        leftRotateByOne(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void leftRotateByOne(int[] arr) {
        int temp = arr[0];
        for(int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;
    }
}
