package com.dsalgo.grokking.patterns.dynamic.programming;

import java.util.Arrays;

// https://leetcode.com/problems/01-matrix/
public class _01Matrix {
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 1}, {0, 1, 1}, {1, 0, 1}};
        System.out.println(Arrays.deepToString(updateMatrix(matrix)));
    }

    private static int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // first pass: top-left to bottom-right
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // check if the element is greater than 1
                if(matrix[i][j] > 0) {
                    // check if the element above, if there is no element above, set to infinity
                    int up = (i > 0) ? matrix[i - 1][j] : Integer.MAX_VALUE - 10000;

                    // check if the left element, if there is no left element, set to infinity
                    int left = (j > 0) ? matrix[i][j - 1] : Integer.MAX_VALUE - 10000;

                    // update the current element with the minimum of element above and to its left, +1
                    matrix[i][j] = Math.min(up, left) + 1;
                }
            }
        }

        // second pass: bottom-right to top-left
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                // check if the element is greater than 0
                if(matrix[i][j] > 0) {
                    // check the element below, if there is no element below, set to infinity
                    int down = (i < m - 1) ? matrix[i + 1][j] : Integer.MAX_VALUE - 10000;

                    // check the right element, if there is no right element, set to infinity
                    int right = (j < n - 1) ? matrix[i][j + 1] : Integer.MAX_VALUE - 10000;

                    // update the current element with the minimum of its value, element below
                    // and to its right,  +1
                    matrix[i][j] = Math.min(matrix[i][j], Math.min(down + 1, right + 1));
                }

            }
        }
        return matrix;
    }
}
