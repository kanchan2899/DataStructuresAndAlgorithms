package com.dsalgo.grokking.patterns.modified.binary.search;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {15, 16, 17, 19, 20, 25, 1,3, 4, 5, 7, 10, 14};
        int target = 25;

        System.out.println(search(arr, target));
    }

    private static int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(arr[mid] == target) {
                return mid;
            }

            if (arr[start] <= arr[mid]) {
                // target is within the sorted first half of the array
                if(arr[start] <= target && target < arr[mid]) {
                    end = mid - 1;
                }
                // target is not within the sorted first half, so let’s examine the unsorted second half
                else {
                    start = mid + 1;
                }
            } else {
                // target is within the sorted second half of the array
                if(arr[mid] < target && target <= arr[end]) {
                    start = mid + 1;
                }
                // target is not within the sorted second half, so let’s examine the unsorted first half
                else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
