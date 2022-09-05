package com.dsalgo.recursion;

// https://www.geeksforgeeks.org/recursive-programs-to-find-minimum-and-maximum-elements-of-array/
public class MinimumAndMaximum {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, -5, -4, 8, 6};
        System.out.println(minimum(arr, 0, arr.length - 1, arr[0]));
        System.out.println(minimum1(arr, arr.length - 1));
        System.out.println(maximum(arr, 0, arr.length - 1, arr[0]));
        System.out.println(maximum1(arr, arr.length - 1));
    }

    private static int maximum1(int[] arr, int n) {
        if(n < 1) return arr[0];
        return Math.max(arr[n], maximum1(arr, n - 1));
    }

    private static int minimum1(int[] arr, int n) {
        if(n < 1) return arr[0];
        return Math.min(arr[n], minimum1(arr, n - 1));
    }

    private static int minimum(int[] arr, int start, int end, int min){
        if(end < start){
            return min;
        }
        return minimum(arr, start+1, end, Math.min(min, arr[start]));
    }

    private static int maximum(int[] arr, int start, int end, int max){
        if(end < start){
            return max;
        }
        return maximum(arr, start+1, end, Math.max(max, arr[start]));
    }
}
