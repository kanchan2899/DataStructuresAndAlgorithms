package com.dsalgo.arrays;

import java.sql.SQLOutput;
import java.util.Arrays;

// https://leetcode.com/problems/flipping-an-image/
public class FlippingAnImage {
    public static void main(String[] args) {
        int[][] x = {{1, 0, 0}, {1, 1, 1}, {0, 0, 1}};
        System.out.println(Arrays.deepToString(flipAndInvertImage(x)));
    }
    public static int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n/2; j++){
                swap(image[i], j, n-j-1);
            }
            for(int j = 0; j < n; j++){
                image[i][j] = image[i][j] ^ 1;
            }
        }
        return image;
    }

    static void swap(int[] x, int a, int b){
        int temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }
}
