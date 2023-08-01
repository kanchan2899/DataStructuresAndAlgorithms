package com.dsalgo.arrays.twoD;

// https://www.geeksforgeeks.org/print-boundary-elements-of-a-given-matrix-in-clockwise-manner/?ref=gcse
public class PrintBoundaryElements {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printBoundaryElements(arr);
    }

    /**
     * Use 4 for loops separately: Traverse first row all columns, then traverse last columns
     * all rows, then traverse from c - 1 column to 0 columns last row, then traverse r - 1 to 1 rows first column.
     *
     * Handle single row and single columns cases separately as these 4 loops will print duplicate
     * elements
     *
     * TC: O(m + n)
     * SC: O(1)
     *
     * @param mat
     */
    private static void printBoundaryElements(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        if(r == 1) {
            for(int i = 0; i < c; i++) {
                System.out.print(mat[0][i] + " ");
            }
        }
        else if(c == 1) {
            for(int i = 0; i < r; i++) {
                System.out.print(mat[i][0] + " ");
            }
        }
        else {
            for(int i = 0; i < c; i++) {
                System.out.print(mat[0][i] + " ");
            }
            for(int i = 1; i < r; i++) {
                System.out.print(mat[i][c - 1] + " ");
            }
            for(int i = c - 2; i >= 0; i--) {
                System.out.print(mat[r - 1][i] + " ");
            }
            for(int i = r - 2; i >= 1; i--) {
                System.out.print(mat[i][0] + " ");
            }
        }
    }
}
