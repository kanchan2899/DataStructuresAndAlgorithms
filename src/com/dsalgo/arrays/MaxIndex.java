package com.dsalgo.arrays;

// https://practice.geeksforgeeks.org/problems/maximum-index-1587115620/1
public class MaxIndex {
    public static void main(String[] args) {
        int[] arr = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        System.out.println(maxIndexDiff(arr));
        System.out.println(maxIndexDiff1(arr));
    }

    static int maxIndexDiff(int[] arr) {
        int maxDiff = 0;
        int low_end = 0, high_end = arr.length - 1;
        while (low_end < high_end) {
            if(arr[low_end] <= arr[high_end]) {
                maxDiff = Math.max(maxDiff, high_end - low_end);
                low_end++;
                high_end = arr.length - 1;
            } else {
                high_end--;
                if(high_end - low_end == 0) {
                    low_end++;
                    high_end = arr.length - 1;
                }
            }
        }
        return maxDiff;
    }

    static int maxIndexDiff1(int[] arr) {
        int n = arr.length;
        int lmin[] = new int[n];
        int rmax[] = new int[n];

        lmin[0] = arr[0];
        rmax[n - 1] = arr[n - 1];

        for(int i = 1; i < n; i++) {
            lmin[i] = Math.min(lmin[i - 1], arr[i]);
        }

        for(int i = n - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i+1], arr[i]);
        }

        int max = -1;
        int i = 0, j = 0;

        while (i < n && j < n) {
            if(lmin[i] <= rmax[j]) {
                max = Math.max(max, j - i);
                j++;
            } else {
                i++;
            }
        }
        return max;
    }
}
