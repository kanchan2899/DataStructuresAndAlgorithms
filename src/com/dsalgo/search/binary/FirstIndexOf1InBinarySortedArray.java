package com.dsalgo.search.binary;

public class FirstIndexOf1InBinarySortedArray {
    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0, 0, 0, 0, 1, 1};
        System.out.println(first1(arr, 0, arr.length - 1));
    }

    private static int first1(int[] arr, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(arr[mid] == 1 && (mid == 0 || arr[mid - 1] == 0)) {
                return mid;
            }
            if(arr[mid] == 1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
