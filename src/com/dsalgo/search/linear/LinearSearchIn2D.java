package com.dsalgo.search.linear;

import java.util.ArrayList;
import java.util.Arrays;

public class LinearSearchIn2D {
    public static void main(String[] args) {
        int[][] arr = {
                {23, 4, 6},
                {5, 87, 10, 63},
                {12, 37},
                {98, 76, 41, 80}
        };
        System.out.println(Arrays.toString(search(arr, 41)));
    }

    private static int[] search(int[][] arr, int element) {
        for (int row = 0; row < arr.length; row++){
            for (int col = 0; col< arr[row].length; col++){
                if(element == arr[row][col]){
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
