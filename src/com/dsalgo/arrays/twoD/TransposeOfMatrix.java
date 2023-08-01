package com.dsalgo.arrays.twoD;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/transpose-of-matrix-1587115621/1
public class TransposeOfMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {4, 5}, {7, 8}};
        System.out.println(Arrays.deepToString(transpose(arr)));
        int[][] arr1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(transpose1(arr1)));
    }

    /**
     * In-place and one traversal: Start a loop for row and inner loop j from i + 1 to n.
     * Swap arr[i][j] and arr[j][i]
     *
     * TC: O(n ^ 2)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    private static int[][] transpose1(int[][] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        return arr;
    }

    /**
     * Bruteforce: Create a new array with n rows and m columns. Loop through rows and columns
     * and assign temp[j][i] = arr[i][j]
     *
     * TC: O(n ^ 2)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    private static int[][] transpose(int[][] arr) {
        int[][] transpose = new int[arr[0].length][arr.length];

        for(int j = 0; j < arr[0].length; j++) {
            for(int i = 0; i < arr.length; i++) {
                transpose[j][i] = arr[i][j];
            }
        }

        return transpose;
    }
}
