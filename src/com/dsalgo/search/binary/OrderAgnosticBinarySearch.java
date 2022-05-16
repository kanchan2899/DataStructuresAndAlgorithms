package com.dsalgo.search.binary;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        // Array is in descending order
        int[] arr = {3, 3, 3, 5, 5, 10, 14, 20, 33};
        int[] arr1 = {100, 98, 76, 54, 32, 20, 10, 8, 2};
        int target = 20;
        System.out.println(binarySearch(arr, target));
        System.out.println(binarySearch(arr1, target));
    }

    // Return the index
    static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        // Check if array is in ascending or descending order
        boolean isAscending;
        if(arr[start] < arr[end]){
            isAscending = true;
        } else
            isAscending = false;

        while (start <= end){
            // addition of start and end index might exceed integer range if the array is too big
            //int mid = (start + end) / 2;
            int mid = start + (end - start) / 2;

            if(arr[mid] == target) return mid;

            if(!isAscending){
                if (target < arr[mid]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
