package com.dsalgo.recursion.sorting;

// https://www.geeksforgeeks.org/program-check-array-sorted-not-iterative-recursive/
public class CheckIfArrayIsSorted {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 4, 5};
        System.out.println(isArraySorted1(arr, arr.length));
        System.out.println(isArraySorted2(arr, 0));

    }

    private static boolean isArraySorted2(int[] arr, int index) {
        if(index == arr.length - 1) {
            return true;
        }
        return arr[index] <= arr[index + 1] && isArraySorted2(arr, index + 1);
    }

    private static boolean isArraySorted1(int[] arr, int n) {
        if(n <= 1){
            return true;
        }
        if(arr[n - 1] < arr[n - 2])
            return false;
        return isArraySorted1(arr, n - 1);
    }
}
