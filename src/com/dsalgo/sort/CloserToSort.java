package com.dsalgo.sort;

// https://www.geeksforgeeks.org/search-almost-sorted-array/
public class CloserToSort {


    public static void main(String[] args) {
        int[] arr = {10, 3, 40, 20, 50, 80, 70};
        int key = 40;
        System.out.println(closerToSort(arr, arr.length, key));
        System.out.println(closerToSort1(arr, arr.length, key));
    }

    /**
     * Using binary search: The idea is to compare the key with middle 3 elements. If present, then
     * return the index. In not present, then compare the key with middle element to decide
     * whether to go left or right. Comparing with middle element is enough as all the elements
     * after mid + 2 must be greater than the element mid and all elements before mid - 2 must be
     * smaller than the mid element.
     *
     * TC: O(log n)
     * SC: O(1)
     *
     * @param arr
     * @param n
     * @param key
     * @return
     */
    private static int closerToSort1(int[] arr, int n, int key) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // the the element is present at one of the middle 3 positions
            if(arr[mid] == key) {
                return mid;
            }
            if(mid > low && arr[mid - 1] == key) {
                return mid - 1;
            }

            if(mid < high && arr[mid + 1] == key) {
                return mid + 1;
            }

            if(arr[mid] > key) {
                high = mid - 2;
            } else {
                low = mid + 2;
            }
        }
        return -1;
    }

    /**
     * Using linear search: Traverse through the array and check if the key is present
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param arr
     * @param n
     * @return
     */
    private static int closerToSort(int[] arr, int n, int key) {
        for(int i = 0; i < n; i++) {
            if(arr[i] == key) {
                return i;
            }
        }
        return -1;
    }


}
