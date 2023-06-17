package com.dsalgo.arrays;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/rearrange-an-array-with-o1-extra-space3142/1
public class RearrangeArray {
    public static void main(String[] args) {
        long[] arr = {4,0,2,1,3};
        arrange(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Start a loop i from 0 to n.
     *
     * TC: O(n)
     * SC: O(1)
     * @param arr
     * @param n
     */
    static void arrange(long arr[], int n){
        for(int i = 0; i < n; i++) {
            arr[i] = (int) arr[i] + ((arr[(int) arr[i]]) % n) * n;
        }
        for(int i = 0; i < n; i++) {
            arr[i] = arr[i] / n;
        }
    }
}
