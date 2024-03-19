package com.dsalgo.grokking.patterns.matrixes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/where-will-the-ball-fall/description/
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{2, 14, 8}, {12, 7, 14}};
        System.out.println(spiralMatrix(matrix));
    }

    private static List<Integer> spiralMatrix(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();

        // calculate the total number of rows and col
        int rows = matrix.length;
        int cols = matrix[0].length;

        // set up pointers to traverse the matrix
        int row = 0;
        int col = -1;

        // set the initial direction to 1 for moving left to right
        int direction = 1;

        // traverse the matrix in a spiral order
        while (rows > 0 && cols > 0) {
            // move horizontally in one of two directions:
            // 1. left to right (if direction  == 1)
            // 2. right to left (if direction == -1)
            // increment the col pointer to move horizontally

            for(int i = 0; i < cols; i++) {
                col += direction;
                spiral.add(matrix[row][col]);
            }
            rows--;

            // move vertically in one of two directions
            // 1. top to bottom if direction == 1;
            // 2. bottom to top if direction  == -1
            // increment the row pointer to move vertically
            for(int i = 0 ; i < rows; i++) {
                row += direction;
                spiral.add(matrix[row][col]);
            }
            cols--;

            // flip the direction for the next traversal
            direction *= -1;
        }

        return spiral;
    }
}
