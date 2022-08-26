package com.dsalgo.arrays;

import java.util.Arrays;

// https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
public class CellsWithOddValuesInMatrix {
    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int[][] indices = {{0, 1}, {1, 1}};
        System.out.println(oddCells(m, n, indices));
    }

    private static int oddCells(int m, int n, int[][] indices) {
        int count = 0;
        int[][] arr = new int[m][n];
        for(int i = 0; i < indices.length; i++){
            int x = indices[i][0];
            int y = indices[i][1];
            for(int k = 0; k < n; k++){
                arr[x][k] += 1;
            }
            for(int k = 0; k < m; k++){
                arr[k][y] += 1;
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] % 2 != 0){
                    count++;
                }
            }
        }

        System.out.println(Arrays.deepToString(arr));
        return count;
    }
}
