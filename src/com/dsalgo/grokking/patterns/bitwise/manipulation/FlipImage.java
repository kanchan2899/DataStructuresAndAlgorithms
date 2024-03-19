package com.dsalgo.grokking.patterns.bitwise.manipulation;

import java.util.Arrays;

// https://leetcode.com/problems/flipping-an-image/description/
public class FlipImage {
    public static void main(String[] args) {
        int[][] image = {{1, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 0}};
        System.out.println(Arrays.deepToString(flipImage(image)));
    }

    private static int[][] flipImage(int[][] image) {
        // get the row and column count
        int row = image.length;
        int col = image[0].length;

        // calculate the middle index of the rows
        int mid = (row + 1) / 2;

        // iterate over all rows
        for(int[] r : image) {
            for(int i = 0; i < mid; i++) {
                // store the inverted value of the current in a temporary variable
                int temp = r[i] ^ 1;
                // update the current element with the inverted value of the corresponding element
                // from the second half
                r[i] = r[r.length - 1 - i] ^ 1;

                // update the corresponding element from the second half with the inverted value
                // stored in the temporary variable
                r[r.length - 1 - i] = temp;
            }
        }
        return image;
    }
}
