package com.dsalgo.search.binary;

public class FindMinimumInRotatedSortedArrayWithDuplicates {
    public static void main(String[] args) {
        int[][] arr = {
                        {0, 1, 2, 2, 2},
                        {2, 0, 1, 2, 2},
                        {2, 2, 0, 1, 2},
                        {2, 2, 2, 0, 1},
                        {1, 2, 2, 2, 0}
                        };
        for(int[] a : arr) {
            System.out.println(minimum(a));
        }
    }

    private static int minimum(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(end > mid && arr[mid] > arr[mid + 1]) {
                return arr[mid + 1];
            }
            if(start < mid && arr[mid] < arr[mid - 1]) {
                return arr[mid];
            }
            if(arr[start] == arr[mid] && arr[end] == arr[mid]){
                start += 1;
                end -= 1;
            }
            if((arr[start] <= arr[mid] && arr[end] >= arr[mid]) || (arr[mid] < arr[start])) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        return arr[start];
    }
}
