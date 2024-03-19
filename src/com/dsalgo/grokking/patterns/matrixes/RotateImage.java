package com.dsalgo.grokking.patterns.matrixes;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] image = {{2, 14, 8}, {12, 7, 14}, {3, 3, 7}};
        System.out.println(Arrays.deepToString(rotateImage(image)));
    }

    /**
     * 1. We run a loop where row ranges from 0 to n / 2.
     *   - Within this loop, we run a nested loop where col ranges from row to n - row - 1.
     *   These loops traverse the groups of four cells in the matrix. In this nested loop,
     *   we perform three swaps:
     *      - The value of the top-left cell is swapped with the value of the top-right cell.
     *      - The value of the top-left cell is swapped with the value of the bottom-right cell.
     *      - The value of the top-left cell is swapped with the value of the bottom-left cell.
     *
     *   - The current group of four cells has been rotated by 90 degrees. We now move to the next
     * iteration of the outer loop to rotate the next group.
     * 2. We repeat the process above until the whole matrix has been rotated.
     *
     * TC: O(m * n)
     *
     * @param image
     * @return
     */
    private static int[][] rotateImage(int[][] image) {
        int n = image.length;

        for(int row = 0; row < n / 2; row++) {
            for(int col = row; col < n - row - 1; col++) {
                // swap the top-left and top-right cells in the current group
                int temp = image[row][col];
                image[row][col] = image[col][n - 1 - row];
                image[col][n - 1 - row] = temp;

                // swap the top-left and bottom-right cells in the current group
                temp = image[row][col];
                image[row][col] = image[n - 1 - row][n - 1 - col];
                image[n - 1 - row][n - 1 - col] = temp;

                // swap the top-left and bottom-left cells in the current group
                temp = image[row][col];
                image[row][col] = image[n - 1 - col][row];
                image[n - 1 - col][row] = temp;
            }
        }
        return image;
    }
}
