package com.dsalgo.search.binary;

public class DescendingBinarySearch {
    public static void main(String[] args) {
        // Array is in descending order
        int[] arr = {100, 90, 87, 65, 54, 43, 32, 10, -10, -50};
        int target = 43;
        System.out.println(binarySearch(arr, target));
    }

    // Return the index
    static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            // addition of start and end index might exceed integer range if the array is too big
            //int mid = (start + end) / 2;
            int mid = start + (end - start) / 2;
            if(arr[mid] == target) return mid;
            else if (target < arr[mid]){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
