package com.dsalgo.arrays;

import java.util.Arrays;

// https://leetcode.com/problems/spiral-matrix-ii/
public class SpiralMatrixII {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(Arrays.deepToString(generateMatrix(n)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int val = 1, startRow = 0, endRow = n - 1, startCol = 0, endCol = n - 1;
        int square = n * n;

        while (val <= square) {
            for (int i = startCol; i <= endCol && val <= square; i++) {
                matrix[startRow][i] = val++;
            }
            startRow++;
            for (int i = startRow; i <= endRow && val <= square; i++) {
                matrix[i][endCol] = val++;
            }
            endCol--;
            for (int i = endCol; i >= startCol && val <= square; i--) {
                matrix[endRow][i] = val++;
            }
            endRow--;

            for (int i = endRow; i >= startRow && val <= square; i--) {
                matrix[i][startCol] = val++;
            }
            startCol++;
        }

        return matrix;
    }
}
