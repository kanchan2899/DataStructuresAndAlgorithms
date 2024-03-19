package com.dsalgo.grokking.patterns.matrixes;

import java.util.Arrays;

// https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1, 1, 1}, {0, 0, 1, 1, 1}, {1, 1, 1, 1, 0}, {1, 1, 1, 1, 1}};
        System.out.println(Arrays.deepToString(setMatrixZeroes(matrix)));
    }

    /**
     * 1. Calculate the number of rows and columns of the mat.
     * 2. Set fcol and frow to FALSE.
     * 3. Check the first column and first row. If any element from the first row or first column
     * is 0, set frow or fcol to TRUE, respectively.
     * 4. Check all the elements row-wise by ignoring the first row and first column. If a 0 is
     * found, we set the first element in that row and column to 0.
     * 5. Check every row’s first element, starting from the second row, and if it is 0, set all
     * values in that row to 0.
     * 6. Check every column’s first element, starting from the second column, and if it’s 0, set
     * all values in that row to 0.
     * 7. If frow is TRUE, set 0 in the first row.
     * 8. If fcol is TRUE, set 0 in the first column.
     *
     * TC: O(m * n)
     * SC: O(1)
     * Return mat.
     * @param matrix
     * @return
     */
    private static int[][] setMatrixZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean fcol = false;
        boolean frow = false;

        // check if there is a zero in the first column, set fcol to true
        for(int i = 0; i < rows; i++) {
            if(matrix[i][0] == 0) {
                fcol = true;
                break;
            }
        }

        // check if there is a zero in the first row, set frow to true
        for(int i = 0; i < cols; i++) {
            if(matrix[0][i] == 0) {
                frow = true;
                break;
            }
        }

        // check row elements (by ignoring the first row and column). If zero is found, set the
        // corresponding row's and column's first element to zero
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // check every row's first element starting from the second row
        // set the complete row to zero if zero is found
        for(int i = 1; i < rows; i++) {
            if(matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }

        // check every column's first element starting from the second column
        // set the complete column to zero if zero is found
        for(int j = 1; j < cols; j++) {
            if(matrix[0][j] == 0) {
                for(int i = 1; i < rows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // if fcol is true, set the first column to zero
        if(fcol) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }

        // if frow is true, set the first row to zero
        if(frow) {
            Arrays.fill(matrix[0], 0);
        }
        return matrix;
    }

}
