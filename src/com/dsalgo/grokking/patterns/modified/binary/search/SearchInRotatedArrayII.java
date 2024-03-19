package com.dsalgo.grokking.patterns.modified.binary.search;

// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
public class SearchInRotatedArrayII {
    public static void main(String[] args) {
        int[] arr = {2,5,6,0,0,1,2};
        int target =0;

        System.out.println(searchInRotatedArray(arr, target));
    }

    private static boolean searchInRotatedArray(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(arr[mid] == target) {
                return true;
            }
            else if(arr[mid] > arr[start]) {
                if(target >= arr[start] && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (arr[mid] < arr[start]){
                if(target > arr[mid] && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                start += 1;
            }
        }
        return false;
    }
}
