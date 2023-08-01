package com.dsalgo.arrays.twoD;

import java.util.Arrays;

public class ExchangeMatrixColumns {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        exhangeColumns(arr);
        System.out.println(Arrays.deepToString(arr));
    }

    /**
     * Exchange first and last columns
     *
     * TC: O(c)
     * @param arr
     */
    private static void exhangeColumns(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;

        for(int i = 0; i < r; i++) {
            int temp = arr[i][0];
            arr[i][0] = arr[i][c - 1];
            arr[i][c - 1] = temp;
        }
    }
}
