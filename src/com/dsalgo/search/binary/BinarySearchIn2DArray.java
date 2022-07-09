package com.dsalgo.search.binary;

import java.util.Arrays;

public class BinarySearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {10, 20, 30, 40, 50},
                {15, 25, 35, 45, 51},
                {28, 29, 37, 49, 52},
                {33, 34, 38, 50, 55}
        };
        System.out.println(Arrays.toString(search(arr, 55)));
    }

    static int[] search(int[][] matrix, int target){
        int rowCount = 0;
        int colCount = matrix[0].length - 1;

        while( rowCount < matrix.length && colCount >= 0){
            if(matrix[rowCount][colCount] == target){
                return new int[]{rowCount, colCount};
            }
            if(matrix[rowCount][colCount] < target){
                rowCount++;
            } else {
                colCount--;
            }
        }
        return new int[]{-1, -1};
    }
}
