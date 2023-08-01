package com.dsalgo.arrays.twoD;

import java.util.Arrays;

// https://www.geeksforgeeks.org/program-to-reverse-columns-in-given-2d-array-matrix/?ref=gcse
public class ReverseColumnsOfMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {11, 10, 9, 12}, {13, 14, 15, 16}};
        reverseColumns(arr);
        System.out.println(Arrays.deepToString(arr));
    }

    private static void reverseColumns(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c/2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][c - j - 1];
                arr[i][c - j - 1] = temp;
            }
        }
    }
}
