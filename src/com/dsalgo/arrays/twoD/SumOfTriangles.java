package com.dsalgo.arrays.twoD;

import java.util.ArrayList;


// https://www.geeksforgeeks.org/sum-upper-triangle-lower-triangle/?ref=gcse
public class SumOfTriangles {
    public static void main(String[] args) {
        int[][] arr = {{6, 5, 4}, {1, 2, 5}, {7, 9, 7}};
        System.out.println(sumOfTriangles(arr));
    }

    private static ArrayList<Integer> sumOfTriangles(int[][] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int lowerSum = 0, upperSum = 0;

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(i >= j) {
                    lowerSum += arr[i][j];
                }
                if(i <= j) {
                    upperSum += arr[i][j];
                }
            }
        }
        list.add(upperSum);
        list.add(lowerSum);

        return list;
    }
}
