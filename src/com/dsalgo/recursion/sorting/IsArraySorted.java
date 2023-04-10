package com.dsalgo.recursion.sorting;

public class IsArraySorted {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 7};
        System.out.println(isArraySorted(arr, 0));
    }

    private static boolean isArraySorted(int[] arr, int startIndex) {
        if(startIndex + 1 == arr.length)
            return true;
        return (arr[startIndex] < arr[startIndex + 1]) && isArraySorted(arr, startIndex + 1);
    }
}
