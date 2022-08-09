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
        int[] y = new int[x.length * x[0].length];
        int k = 0;
        for(int i = 0; i < x.length; i++){
            for(int j = 0; j < x[i].length; j++){
                y[k] = x[i][j];
                k++;
            }
        }
        return y;
    }
}
