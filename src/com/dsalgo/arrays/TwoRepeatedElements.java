package com.dsalgo.arrays;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/two-repeated-elements-1587115621/1
public class TwoRepeatedElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 3};
        System.out.println(Arrays.toString(twoRepeated(arr, arr.length)));
    }


    public static int[] twoRepeated(int arr[], int n)
    {
        int[] nums = new int[2];
        int k = 0;
        for(int i = 0; i < n + 2; i++) {
            if(arr[Math.abs(arr[i])] < 0) {
                nums[k++] = Math.abs(arr[i]);
            }
            arr[Math.abs(arr[i])] *= -1;
        }
        return nums;
    }
}
