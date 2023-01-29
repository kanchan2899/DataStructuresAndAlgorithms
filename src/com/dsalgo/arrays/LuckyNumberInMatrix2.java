package com.dsalgo.arrays;


import java.util.ArrayList;
import java.util.List;

public class LuckyNumberInMatrix2 {
    public static void main(String[] args) {
        int[][] mat = {{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}};
        System.out.println(luckyNumbers(mat));
    }

    private static List<Integer> luckyNumbers(int[][] mat) {
        List<Integer> luckyNums = new ArrayList<>();
        int[] minimums = new int[mat.length];
        int minIndex = 0;
        for(int i = 0; i < mat.length; i++){
            int min = mat[i][0];
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] < min){
                    min = mat[i][j];
                    minIndex = j;
                }
            }
            minimums[i] = minIndex;
        }

        for(int i = 0; i < minimums.length; i++){
            int max = mat[i][minimums[i]];
            for(int j = 0; j < mat.length; j++){
                if(mat[j][minimums[i]] > max){
                    max = mat[j][minimums[i]];
                }
            }
            if(max == mat[i][minimums[i]]){
                luckyNums.add(max);
            }
        }
        return luckyNums;
    }
}
