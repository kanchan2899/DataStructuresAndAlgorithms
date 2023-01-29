package com.dsalgo.arrays.twoD;

// https://leetcode.com/problems/toeplitz-matrix/
public class ToeplitxMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        System.out.println(toeplitzMatrix(arr));
    }

    private static boolean toeplitzMatrix(int[][] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr[0].length - 1; j++) {
                if(arr[i][j] != arr[i+1][j+1])
                    return false;
            }
        }
        return true;
    }
}
