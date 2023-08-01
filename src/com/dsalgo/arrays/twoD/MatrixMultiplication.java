package com.dsalgo.arrays.twoD;

import java.util.Arrays;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] b = {{1, 2,}, {4, 5}};
        int[][] a = {{5, 6}, {8, 9}};
        System.out.println(Arrays.deepToString(matrixMultiplication(a, b)));
    }

    /**
     * Matrix multiplication: 3 loops required to do the multiplication c[i][j] += a[i][k] + b[k][j]
     *
     * Order of a = m * n
     * Order of b = n * p
     * Oder of a * b = m * p
     *
     * TC: O(m * n * p)
     * SC: O(m * p)
     *
     * @param a
     * @param b
     * @return
     */
    private static int[][] matrixMultiplication(int[][] a, int[][] b) {
        int n1 = a.length;
        int m1 = a[0].length;
        int n2 = b.length;
        int m2 = b[0].length;

        if(m1 != n2) {
            return new int[0][0];
        }
        int[][] c = new int[a.length][b[0].length];

        // traversing the number of rows of a
        for(int i = 0; i < n1; i++) {
            // traversing the number of columns of b
            for(int j = 0; j < m2; j++) {
                c[i][j] = 0;

                // traversing the number of columns of a
                for(int k = 0; k < m1; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }
}
