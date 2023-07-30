package com.dsalgo.arrays.twoD;

public class PrintSnakePattern {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printSnakePattern(arr);
    }

    /**
     * Bruteforce: Check if the row number is even. If it is, print row from 0 to n-1. Else print
     * row from n-1 to 0
     *
     * TC: O(m * n)
     * SC: O(1)
     *
     * @param arr
     */
    private static void printSnakePattern(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(i % 2 == 0) {
                for(int j = 0; j < arr[0].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
            } else {
                for (int j = arr[0].length - 1; j >= 0; j--) {
                    System.out.print(arr[i][j] + " ");
                }
            }
        }
    }
}
