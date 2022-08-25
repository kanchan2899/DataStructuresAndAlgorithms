package com.dsalgo.arrays;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] arr1 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}};
        int[][] arr2 = {{1, 2, 3, 4, 5}};
        int[][] arr3 = {{1}, {2}, {3}, {4}};
        System.out.println(spiralOrder(arr));
        System.out.println(spiralOrder(arr1));
        System.out.println(spiralOrder(arr2));
        System.out.println(spiralOrder(arr3));
    }
    public static List<Integer> spiralOrder(int[][] arr) {
        List<Integer> list = new ArrayList<>(arr.length * arr[0].length);
        int endRow = arr.length - 1;
        int endCol = arr[0].length - 1;
        int startRow = 0, startCol = 0, count = 0;
        int total = (arr.length) * (arr[0].length);

        while(count < total){
            for(int i = startCol; i <= endCol && count < total; i++){
                list.add(arr[startRow][i]);
                count++;
            }
            startRow++;
            for(int i = startRow; i <= endRow && count < total; i++){
                list.add(arr[i][endCol]);
                count++;
            }
            endCol--;
            for(int i = endCol; i >= startCol && count < total; i--){
                list.add(arr[endRow][i]);
                count++;
            }
            endRow--;
            for(int i = endRow; i >= startRow && count < total; i--){
                list.add(arr[i][startCol]);
                count++;
            }
            startCol++;
        }
        return list;
    }
}
