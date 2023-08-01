package com.dsalgo.search.binary;

// https://www.geeksforgeeks.org/check-for-majority-element-in-a-sorted-array/
public class MajorityElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        int x = 2;
        System.out.println(majorityElement(arr, x));
        System.out.println(majorityElement1(arr, x));
    }

    /**
     * Using linear search: Linearly search for the first occurrence of the element, once you find
     * it, say at index i, check element at index i + n/2. If the element is present at i + n/2,
     * return 1 else return 0.
     *
     * TC: O(n)
     * SC: O(1)
     * @param arr
     * @return
     */
    private static boolean majorityElement(int[] arr, int x) {
        int i, last_index = 0;
        int n = arr.length;

        // get the last index according to n (even or odd)
        last_index = n % 2 == 0 ? n / 2 : n + 1;

        // search for first occurrence of x in arr
        for(i = 0; i < last_index; i++) {
            if(arr[i] == x && arr[i + n/2] == x) {
                return true;
            }
        }
        return false;
    }

    /**
     * Using Binary Search: First find the first occurrence of the element using binary search.
     * Then check if arr[i + n/2] == x. If so, return true, else return false.
     *
     * TC: O(log n)
     * SC: O(log n) - for binary search
     */
    private static boolean majorityElement1(int[] arr, int x) {
        int n = arr.length;
        int i = binarySearch(arr, x, 0, n - 1);

        // if element is not present at all, return false
        if(i == -1) {
            return false;
        }

        // check if element is present more than n/2 times
        if(((i + n/2) <= (n-1)) && (arr[i + n/2] == x)) {
            return true;
        }
        return false;
    }

    static int binarySearch(int[] arr, int x, int low, int high) {
        if(high >= low) {
            int mid = (high + low) / 2;

            // Check if arr[mid] is the first occurrence of x if below is true:
            // 1. mid == 0 and arr[mid] == x
            // 2. arr[mid - 1] < x and arr[mid] == x
            if(mid == 0 || (x > arr[mid - 1] && arr[mid] == x)) {
                return mid;
            }
            if(x > arr[mid]) {
                return binarySearch(arr, x, mid + 1, high);
            }
            else {
                return binarySearch(arr, x, low, mid - 1);
            }
        }
        return -1;
    }
}
