package com.dsalgo.search.binary;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int arr[] = {3, 4, 5, 6, 7, 0, 1, 2};
        System.out.println(searchInRotatedSortedArray(arr, 3));
    }

    private static int searchInRotatedSortedArray(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            System.out.println("Start " + start + " Mid " + mid + " End " + end);
            if(arr[mid] == target) {
                return mid;
            }
            if(arr[mid] >= arr[start]) {
                if (target >= arr[start] && target <= arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(target <= arr[end] && target >= arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
