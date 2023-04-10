package com.dsalgo.recursion.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

//https://www.geeksforgeeks.org/sum-triangle-from-array/
public class SumTriangleFromArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        printTriangle(a);
        long[] b = {9, 0, 8, 7, 5};
        getTriangle(b, b.length);
        System.out.println();
        getTriangle1(b, b.length);

    }

    public static long[] getTriangle(long arr[], long n)
    {
        if(n < 1)
            return arr;
        long[] a = new long[arr.length - 1];
        for(int i = 0; i < arr.length - 1; i++) {
            a[i] = arr[i] + arr[i + 1];
        }

        long[] p = getTriangle(a, a.length);

        for(int i = 0; i < arr.length; i++){

            System.out.print(arr[i] + " ");
        }

        return p;
    }

    public static long[] getTriangle1(long arr[], long n)
    {
        if(n < 1)
            return arr;
        long[] a = new long[arr.length - 1];

        helper(a, arr, 0);

        long[] p = getTriangle(a, a.length);

        for(int i = 0; i < arr.length; i++){

            System.out.print(arr[i] + " ");
        }

        return p;
    }

    private static void helper(long[] a, long[] arr, int index) {
        if(index == arr.length - 1) {
            return;
        }
        a[index] = arr[index] + arr[index + 1];
        helper(a, arr, index + 1);
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
