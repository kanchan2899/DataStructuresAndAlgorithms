package com.dsalgo.sort.quick;

import java.util.Arrays;

// https://www.geeksforgeeks.org/kth-smallest-largest-element-in-unsorted-array/
public class KthSmallestElement {

    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 9, 1, 4};
        int k = 1;

        System.out.println(kthSmallestElement(arr, k));
        System.out.println(kthSmallestElement1(arr, k));
    }

    /**
     * Using Quick Select algo: The idea is, not to do complete quicksort, but stop at the point
     * where pivot itself is k’th smallest element. Also, not to recur for both left and right
     * sides of pivot, but recur for one of them according to the position of pivot.
     *
     * Run quick sort algorithm on the input array
     *  1. In this algorithm pick a pivot element and move it to it’s correct position
     *  2. Now, if index of pivot is equal to K then return the value, else if the index of pivot
     *  is greater than K, then recur for the left subarray, else recur for the right subarray
     *  3. Repeat this process until the element at index K is not found
     *
     *  TC: O(n * log n)
     *  SC: O(1)
     *
     * @param arr
     * @param k
     * @return
     */
    private static int kthSmallestElement1(int[] arr, int k) {
        return quickSelect(arr, k, 0, arr.length - 1);
    }

    private static int quickSelect(int[] arr, int k, int low, int high) {
        // If k is smaller than number of elements in array
        while (low <= high) {
            // partition the array around the last element and get position of pivot
            int pivotIndex = partition(arr, low, high);

            // if position is same as k, smallest element found
            if(pivotIndex == k - 1) {
                return arr[pivotIndex];
            }
            // if position is greater than k, check in left half
            else if(pivotIndex > k - 1) {
                high = pivotIndex - 1;
            }
            // if position is smaller than k, check in right half
            else {
               low = pivotIndex + 1;
            }
        }
        return -1;
    }

    private static int partition(int[] arr, int low, int high) {
        int x = arr[high];
        int i = low - 1;

        for(int j = low; j < high; j++) {
            if(arr[j] < x) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i;
    }

    /**
     * Bruteforce algo: sort the given array using an O(N log N) sorting algorithm like Merge Sort,
     * Heap Sort, etc, and return the element at index k-1 in the sorted array.
     *
     * TC: O(n * log n)
     * SC: O(1) if array modification is allowed else O(n)
     *
     * @param arr
     * @param k
     * @return
     */
    private static int kthSmallestElement(int[] arr, int k) {
        Arrays.sort(arr);
        if(k < arr.length)
            return arr[k - 1];
        return -1;
    }


}
