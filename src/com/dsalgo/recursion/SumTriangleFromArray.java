package com.dsalgo.recursion;

import java.lang.reflect.Array;
import java.util.Arrays;

//https://www.geeksforgeeks.org/sum-triangle-from-array/
public class SumTriangleFromArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        printTriangle(a);
    }

    private static void printTriangle(int[] a) {
        if(a.length < 1) return;
        int[] arr = new int[a.length - 1];
        for(int i = 0; i < a.length - 1; i++){
            arr[i] = a[i] + a[i + 1];
        }
        printTriangle(arr);
        System.out.println(Arrays.toString(a));
    }
}
