package com.dsalgo.sort.quick;

import java.util.Arrays;

// https://www.geeksforgeeks.org/three-way-partitioning-of-an-array-around-a-given-range/
public class ThreeWayPartition {
    public static void main(String[] args) {
        int[] arr = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
        int lowVal = 10;
        int highVal = 20;

        threeWayPartitioning(arr, lowVal, highVal);

        System.out.println(Arrays.toString(arr));
    }

    private static void threeWayPartitioning(int[] arr, int lowVal, int highVal) {
        int n = arr.length - 1;
        int start = 0, end = n - 1;

        for(int i = 0; i <= end;) {
            // if current element is smaller than range, then put it on next available smaller position
            if(arr[i] < lowVal) {
                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                start++;
                i++;
            }
            // If current element is greater than put it on next available greater position
            else if(arr[i] > highVal) {
                int temp = arr[end];
                arr[end] = arr[i];
                arr[i] = temp;
                end--;
            }
            // If current element is within the lowVal and highVal range, don't do anything
            else {
                i++;
            }
        }
    }
}
