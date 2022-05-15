package com.dsalgo.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class TwoDArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [][] arr2D = {
                {1, 2, 3}, // 0th index
                {4, 5}, // 1st index
                {6, 7, 8, 9} // 2nd index
        };
        int[][] arr = new int[3][2];
        System.out.println("Number of rows are " + arr2D.length); // Print number of rows
        // Input
        for(int row = 0; row < arr.length; row++){
            // for each column in every row
            for(int col = 0; col < arr[row].length; col++){
                arr[row][col] = in.nextInt();
            }
        }

        for(int row = 0; row < arr.length; row++){
            // for each column in every row
            for(int col = 0; col < arr[row].length; col++){
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }

        for (int row = 0; row < arr.length; row++) {
            // for each column in every row
            System.out.println(Arrays.toString(arr[row]));
        }

        for(int[] a : arr){
            System.out.println(Arrays.toString(a));
        }
    }
}
