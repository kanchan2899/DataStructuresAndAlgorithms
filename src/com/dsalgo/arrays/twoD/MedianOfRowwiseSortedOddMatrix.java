package com.dsalgo.arrays.twoD;

import java.lang.reflect.Array;
import java.util.Arrays;

// https://www.geeksforgeeks.org/find-median-row-wise-sorted-matrix/
public class MedianOfRowwiseSortedOddMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 10, 20}, {15, 25, 35}, {5, 30, 40}};
        System.out.println("Median is " + median(arr));
        System.out.println("Median is " + median1(arr));
    }

    /**
     * Using Binary Search:
     *
     * 1. Find the min element in the first column
     * 2. Find the max element in the last column
     * 3. Then we use binary search on our range of numbers from minimum to maximum,
     * we find the mid of the min and max and get a count of numbers less than or equal to our mid.
     * And accordingly change the min or max.
     * 4. If the mid position is less than the median position, means median lies on the right side
     * 5. Otherwise, median lies on the left side.
     * 6. Keep finding the median until min == max
     * 7. Return min / max
     *
     * TC: O(log c * r * log(max - min)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    private static int median1(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;
        int min = arr[0][0];
        int max = arr[0][c - 1];

        // find the min and max element in the matrix
        for(int i = 1; i < r; i++) {
            min = Math.min(arr[i][0], min);
            max = Math.max(arr[i][c - 1], max);
        }

        int medianPos = (r * c + 1) / 2;

        // Binary search to find the median in range of min and max
        while (min < max) {
            int mid = (min + max) / 2;
            int midPos = 0;     // to compare mid position with median position

            // find the position of mid element by makign use of the fact that every row is sorted
            for(int i = 0; i < r; i++) {
                int pos = Arrays.binarySearch(arr[i], mid) + 1;
                midPos += Math.abs(pos);
            }

            if(midPos < medianPos) {
                min = mid + 1;
            } else {
                max = mid;
            }

        }
        return min;
    }


    /**
     * Bruteforce:
     *
     * 1. Put all elements in a 1D array
     * 2. Sort the 1D array
     * 3. Return the middle element of sorted array
     *
     * TC: O(r * c * log (r * c))
     * SC: O(r * c)
     * @param arr
     * @return
     */
    private static int median(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;
        int medianPos = (r * c) / 2;

        int[] a = new int[r * c];
        int index = 0;

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                a[index++] = arr[i][j];
            }
        }

        Arrays.sort(a);

        return a[medianPos];

    }
}
