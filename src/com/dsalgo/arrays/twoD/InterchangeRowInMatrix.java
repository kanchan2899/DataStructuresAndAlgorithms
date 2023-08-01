package com.dsalgo.arrays.twoD;

import java.util.Arrays;

public class InterchangeRowInMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        interchangeRow(arr);
        System.out.println(Arrays.deepToString(arr));
    }

    private static void interchangeRow(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;

        for(int i = 0; i < r/2; i++) {
            for(int j = 0; j < c; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[r - i - 1][j];
                arr[r - i - 1][j] = temp;
            }
        }
    }
}
