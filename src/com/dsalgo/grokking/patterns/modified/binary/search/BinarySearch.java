package com.dsalgo.grokking.patterns.modified.binary.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {11,22,33,44,55,66,77};
        int target = 33;

        System.out.println(binarySearch(arr, target));
    }

    public static int binarySearch(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        // return -1;
        return start;
    }
}
