package com.dsalgo.arrays.twoD;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RotateMatrixAntiClockwiseBy90 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(Arrays.deepToString(rotateBy90(arr)));
        System.out.println(Arrays.deepToString(rotateBy901(arr)));
    }

    /**
     * Efficient solution: First find transpose of matrix then reverse each column data
     *
     * TC: O(n ^ 2)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    private static int[][] rotateBy901(int[][] arr) {
        int n = arr.length;
        // transpose of matrix
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        // reverse each column data
        for(int i = 0; i < n; i++) {
            int low = 0, high = n - 1;
            while (low < high) {
                int temp = arr[low][i];
                arr[low][i] = arr[high][i];
                arr[high][i] = temp;
                low++;
                high--;
            }
        }

        return arr;
    }

    /**
     * Using Bruteforce: Create a temp array and assign arr[i][j] to temp[n - j - 1][i]
     *
     * TC: O(n ^ 2)
     * SC: O(n ^ 2)
     *
     * @param arr
     * @return
     */
    private static int[][] rotateBy90(int[][] arr) {
        int n = arr.length;
        int[][] temp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                temp[n - j - 1][i] = arr[i][j];
            }
        }
        return temp;
    }


}
