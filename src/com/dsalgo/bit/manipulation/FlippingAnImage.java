package com.dsalgo.bit.manipulation;

import java.util.Arrays;

// https://leetcode.com/problems/flipping-an-image/
public class FlippingAnImage {
    public static void main(String[] args) {
        int[][] arr = {{1, 0, 0}, {1, 1, 0}, {0, 1, 0}};
        System.out.println(Arrays.deepToString(flippingAnImage(arr)));
    }

    private static int[][] flippingAnImage(int[][] arr) {
        for(int[] row: arr) {
            // Reverse array
            for(int i = 0; i < (arr[0].length + 1) / 2; i++) {
                // Swap
                int temp = row[i] ^ 1;
                row[i] = row[arr[i].length - i - 1] ^ 1;
                row[arr[i].length - i - 1] = temp;
            }
        }
        return arr;
    }
}
