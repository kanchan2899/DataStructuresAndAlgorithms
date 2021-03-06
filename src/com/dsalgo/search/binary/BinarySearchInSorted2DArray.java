package com.dsalgo.search.binary;

import java.util.Arrays;

public class BinarySearchInSorted2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(Arrays.toString(search(arr, 11)));
    }

    // Search in a specific row with column start and end indexes
    static int[] binarySearch(int[][] matrix, int row, int colStart, int colEnd, int target){
        while (colStart <= colEnd){
            int mid = colStart + (colEnd - colStart) / 2;
            if(matrix[row][mid] == target){
                return new int[]{row, mid};
            }
            if(matrix[row][mid] < target){
                colStart = mid + 1;
            } else {
                colEnd = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

    static int[] search(int[][] matrix, int target){
        if(matrix.length < 1 || matrix[0].length < 1){
            return new int[]{-1, -1};
        }
        int rows = matrix.length;
        int cols = matrix[0].length; // Matrix might be empty

        if(rows == 1){
            return binarySearch(matrix, 0, 0, cols - 1, target);
        }
        int rowStart = 0;
        int rowEnd = rows - 1;
        int colMid = cols / 2;

        // Run the loop till 2 rows are remaining
        while(rowStart < (rowEnd - 1)){ // while this is true, it will have more than 2 rows
            int mid = rowStart + (rowEnd - rowStart) / 2;
            if(matrix[mid][colMid] == target){
                return new int[]{mid, colMid};
            }
            if(matrix[mid][colMid] < target){
                rowStart = mid;
            } else {
                rowEnd = mid;
            }
        }

        // Now we have 2 rows left
        if(matrix[rowStart][colMid] == target){
            return new int[] {rowStart, colMid};
        }
        if(matrix[rowStart + 1][colMid] == target){
            return new int[] {rowStart + 1, colMid};
        }

        // Search in 1st half
        if(target <= matrix[rowStart][colMid - 1]) {
            return binarySearch(matrix, rowStart, 0, colMid - 1, target);
        }
        // Search in 2nd half
        if(target >= matrix[rowStart][colMid + 1] && target <= matrix[rowStart][cols - 1]) {
            return binarySearch(matrix, rowStart, colMid + 1, cols - 1, target);
        }
        // Search in 3rd half
        if(target <= matrix[rowStart + 1][colMid - 1]) {
            return binarySearch(matrix, rowStart + 1, 0, colMid - 1, target);
        }
        // Search in 4th half
        else {
            return binarySearch(matrix, rowStart + 1, colMid + 1, cols - 1, target);
        }
    }
}
