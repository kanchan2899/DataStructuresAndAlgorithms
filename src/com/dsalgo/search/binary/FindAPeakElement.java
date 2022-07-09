package com.dsalgo.search.binary;

// https://leetcode.com/problems/find-peak-element/
public class FindAPeakElement {
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,5,6,4}; // Answer could be 1 or 5
        System.out.println("A peak element in mountain array is " + findAPeakElement(arr));
    }

    private static int findAPeakElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[mid+1]){
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start; // return end
    }
}
