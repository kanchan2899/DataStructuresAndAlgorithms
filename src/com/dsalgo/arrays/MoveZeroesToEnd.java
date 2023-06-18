package com.dsalgo.arrays;

import java.util.Arrays;

/* GFG: arr = {5, 0, 8, 9, 0, 10, 12, 0}
    Move zeroes in the array to the end while keeping the order of non-zeroes same.
    o/p = {5, 8, 9, 10, 12, 0, 0, 0}
 */
public class MoveZeroesToEnd {
    public static void main(String[] args) {
        int[] arr = {5, 0, 8, 9, 0, 10, 12, 0};
        moveZeroesToEnd(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {5, 0, 8, 9, 0, 10, 12, 0};
        moveZeroesToEnd1(arr1);
        System.out.println(Arrays.toString(arr1));}

    /**
     *  Optimizer solution: Initialize count of non-zero elements to 0 (consider it as an index of
     *  current non-zeroes elements)
     *  Start a loop i from 0 to n. If you encounter a non-zero element, swap the current element
     *  with index count and increment count. No need to do anything for zero elements
     *
     *  TC: O(n)
     *  SC: O(1)
     *
     * @param arr
     */
    private static void moveZeroesToEnd1(int[] arr) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                arr[count++] = arr[i];
            }
        }

        for(int j = count; j < arr.length; j++) {
            arr[j] = 0;
        }
    }

    /**
     * Bruteforce: Start a loop i from 0 to n. If element is zero, start another loop j from i + 1
     * to n and check a non-zero element in the rest of the array. If any non-zero element found,
     * swap arr[i] and arr[j]
     *
     * TC: O(n^2)
     * SC: O(1)
     *
     * @param arr
     */
    private static void moveZeroesToEnd(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                for(int j = i + 1; j < arr.length; j++) {
                    if(arr[j] != 0) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        break;
                    }
                }
            }
        }
    }
}
