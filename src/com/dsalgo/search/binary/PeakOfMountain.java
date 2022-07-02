package com.dsalgo.search.binary;
// https://leetcode.com/problems/peak-index-in-a-mountain-array/
public class PeakOfMountain {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 8, 10, 11, 12, 14, 16, 17, 18, 20, 22, 23, 25, 27, 29, 30, 23, 21, 2, 1};
        System.out.println("Index of peak of the mountain is " + peakOfMountain(arr));
    }

    private static int peakOfMountain(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[mid + 1]){
                // In decreasing part of array
                // May be the answer, but look LHS
                // this is why end != mid - 1;
                end = mid;
            } else {
                // In ascending part of array
                start = mid + 1; // because we know that mid + 1 > mid element
            }
        }
        // In the end, start == end and pointing to the largest number
        return end;
    }
}
