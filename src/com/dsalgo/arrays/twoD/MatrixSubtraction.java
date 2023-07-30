package com.dsalgo.arrays.twoD;

import java.util.Arrays;

public class MatrixSubtraction {
    public static void main(String[] args) {
        int[][] a = {{1, 2,}, {4, 5}};
        int[][] b = {{5, 6}, {8, 9}};
        System.out.println(Arrays.deepToString(matrixSubtraction(a, b)));
    }

    /**
     * Matrix subtraction: Loop through rows and columns and subtract a[i][j] and b[i][j] to
     * get c[i][j]
     *
     * Order of a == Order of b == Order of (a - b)
     *
     * TC: O(n * m)
     * SC: O(n * m)
     * @param a
     * @param b
     * @return
     */
    private static int[][] matrixSubtraction(int[][] a, int[][] b) {
        if(a.length != b.length || a[0].length != b[0].length) {
            int[][] r = new int[1][1];
            r[0][0] = -1;
            return r;
        }
        int[][] c = new int[a.length][a[0].length];

        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                c[i][j] = Math.abs(a[i][j] - b[i][j]);
            }
        }

        return c;
    }
}
