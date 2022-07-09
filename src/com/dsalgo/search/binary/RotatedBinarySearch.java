package com.dsalgo.search.binary;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = {9, 11, 12, 14, 16, 17, 18, 19, 20, 22, 23, 24, 25, 7, 5, 4, 3, 2};
        System.out.println(pivotBinarySearch(arr, 17));
    }

    static int pivotBinarySearch(int[] nums, int target){
        int pivot = findPivot(nums);

        // if pivot is not found, it means the array is not rotated
        if(pivot == -1){
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        // if pivot is found, we have 2 sorted arrays on left and right of pivot
        if(nums[pivot] == target)
            return pivot;
        if(nums[0] <= target)
            return binarySearch(nums, target, 0, pivot - 1);
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

    static int binarySearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target){
                start = mid + 1;
            } else
                end = mid - 1;
        }
        return -1;
    }

    // This will not work with duplicate values
    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            // 4 cases
            if(mid < end && arr[mid] > arr[mid + 1])
                return mid;
            if(mid > start && arr[mid] < arr[mid - 1])
                return mid - 1;
            if(arr[mid] <= arr[start])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
}
