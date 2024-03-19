package com.dsalgo.grokking.patterns.modified.binary.search;


// https://leetcode.com/problems/single-element-in-a-sorted-array/
public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5};
        System.out.println(singleElement(arr));
    }

    private static int singleElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // if mid is odd, decrement it to make it even
            if(mid % 2 == 1) {
                mid--;
            }

            // if the elements at mid and mid + 1 are the same,
            // then the single element must appear after the midpoint
            if(arr[mid] == arr[mid + 1]) {
                start = mid + 2;
            }

            // otherwise, search for the single element before the midpoint
            else {
                end = mid;
            }
        }
        return arr[start];
    }
}
