package com.dsalgo.arrays;

public class IsArraySorted {
    public static void main(String[] args) {
        int[] arr = {10, 10, 11, 20};
        System.out.println("Is array sorted?: " + isSorted(arr));
        System.out.println("Is array sorted?: " + isSorted1(arr));
    }

    /**
     * Linear solution: Start a loop from 1 to n. If arr[i] < arr[i - 1], array is not sorted.
     * Else array is sorted.
     *
     * TC: O(n)
     * SC: O(1)
     * @param arr
     * @return
     */
    private static boolean isSorted(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            if(arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Bruteforce: Start a loop i from 0 to n and start another loop j from i + 1 to n.
     * If arr[i] > arr[j], array is not sorted. Else, it is.
     *
     * TC: O(n^2)
     * SC: O(1)
     * @param arr
     * @return
     */
    private static boolean isSorted1(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
