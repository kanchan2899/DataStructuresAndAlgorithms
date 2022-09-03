package com.dsalgo.recursion;

// https://www.geeksforgeeks.org/program-check-array-sorted-not-iterative-recursive/
public class CheckIfArrayIsSorted {
    public static void main(String[] args) {
        int[] arr = {1, -1};
        System.out.println(isArraySorted(arr, arr.length));
    }

    private static boolean isArraySorted(int[] arr, int n) {
        if(n <= 1){
            return true;
        }
        if(arr[n - 1] < arr[n - 2])
            return false;
        return isArraySorted(arr, n - 1);
    }
}
