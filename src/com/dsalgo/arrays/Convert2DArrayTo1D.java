package com.dsalgo.arrays;

import java.util.Arrays;

public class Convert2DArrayTo1D {
    public static void main(String[] args) {
        int[][][] x = {{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                        {{1, 2}, {5, 6}, {8, 9}},
                        {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}}};
        for(int i = 0; i < x.length; i++){
            System.out.println(Arrays.toString(convert2DArray(x[i])));
        }
    }

    public static int[] convert2DArray(int[][] x){
        int n = x.length * x[0].length;
        int[] y = new int[n];
        int row = 0;
        int col = 0;
        for(int i = 0; i < n; i++){
            y[i] = x[row][col++];
            if(col == x[0].length){
                col = 0;
                row++;
            }
        }
        return y;
    }
}
