package com.dsalgo.arrays;

import java.util.Arrays;

class Convert1DArrayTo2D {
    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.deepToString(construct2DArray(x, 3, 3)));
        System.out.println(Arrays.deepToString(construct2DArray(x, 3, 2)));
        System.out.println(Arrays.deepToString(construct2DArray(x, 2, 3)));
        System.out.println(Arrays.deepToString(construct2DArray(x, 1, 5)));
        System.out.println(Arrays.deepToString(construct2DArray(x, 1, 1)));
    }
    public static int[][] construct2DArray(int[] original, int m, int n) {
        int[][] x = new int[m][n];
        int k = 0;
        if((m * n > original.length) || m * n < original.length){
            return new int[][]{};
        }
        for(int i = 0; i < x.length; i++){
            for(int j = 0; j < x[0].length; j++){
                x[i][j] = original[k++];
            }
        }
        return x;
    }
}
