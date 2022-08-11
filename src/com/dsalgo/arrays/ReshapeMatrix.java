package com.dsalgo.arrays;

import java.util.Arrays;
// https://leetcode.com/problems/reshape-the-matrix/
public class ReshapeMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3, 4}};
        int r = 1;
        int c = 4;
        System.out.println(Arrays.deepToString(reshapeMatrix(mat, r, c)));
    }

    private static int[][] reshapeMatrix(int[][] mat, int r, int c) {
        int row = 0;
        int col = 0;
        int m = 0;
        int n = 0;
        int numOfElements = mat.length * mat[0].length;
        int[][] reshapedMat = new int[r][c];
        for(int i = 0; i < numOfElements; i++){
            reshapedMat[row][col++] = mat[m][n++];
            if(col == c){
                col = 0;
                row++;
            }
            if(n == mat[0].length){
                n = 0;
                m++;
            }
        }
        return reshapedMat;
    }
}
