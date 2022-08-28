package com.dsalgo.recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 7, 9, 11, 12};
        int target = 1;
        System.out.println(binarySearch(arr, target, 0, arr.length - 1));
    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
        // Target not found
        if(start > end){
            return -1;
        }
        int mid = start + (end - start) / 2;
        if(arr[mid] > target){
            return binarySearch(arr, target, start, mid - 1);
        } else if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, end);
        }
        return mid;
    }
}
