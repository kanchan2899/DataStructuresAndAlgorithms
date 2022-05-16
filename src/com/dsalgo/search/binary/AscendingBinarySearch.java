package com.dsalgo.search.binary;

public class AscendingBinarySearch {
    public static void main(String[] args) {
        // Array is in descending order
        int[] arr = {-21, -12, -3, 0, 10, 32, 40, 66};
        int target = 66;
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
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
