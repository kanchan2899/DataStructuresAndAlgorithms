package com.dsalgo.search.binary;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(min(arr));
    }

    private static int min(int[] arr) {
        int s = 0;
        int e = arr.length - 1;

        while (s < e) {
            int m = s + (e - s) / 2;
            if(m < e && arr[m] > arr[m + 1]) {
                return arr[m + 1];
            }
            if(m > s && arr[m] < arr[m - 1]) {
                return arr[m];
            }
            if(arr[e] > arr[m]) {
                e = m;
            } else {
                s = m + 1;
            }
        }
        return arr[s];
    }
}
