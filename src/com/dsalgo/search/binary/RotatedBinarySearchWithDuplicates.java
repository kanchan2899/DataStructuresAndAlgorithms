package com.dsalgo.search.binary;

public class RotatedBinarySearchWithDuplicates {
    public static void main(String[] args) {
        int[] arr = {6, 8, 8, 8, 9, 9, 10, 10, 10, 10, 11, 12, 12, 12, 12, 12, 12, 6, 6, 6};
        System.out.println(pivotBinarySearch(arr, 12));
    }

    static int pivotBinarySearch(int[] nums, int target){
        int pivot = findPivotWithDuplicates(nums);

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

    static int findPivotWithDuplicates(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mid < end && arr[mid] > arr[mid + 1])
                return mid;
            if(mid > start && arr[mid] < arr[mid - 1])
                return mid - 1;
            // If elements at middle, start & end are equal, then skip duplicates
            if(arr[mid] == arr[start] && arr[mid] == arr[end]){
                // Skip duplicates
                // What if these elements at start and end are pivots?
                // Therefore, check if start is pivot
                if(arr[start] > arr[start + 1]){
                    return start;
                }
                start++;

                // Check if end is pivot
                if(arr[end] < arr[end - 1]){
                    return end - 1;
                }
                end--;
            }
            // Left side is sorted, so pivot should be in right
            else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
