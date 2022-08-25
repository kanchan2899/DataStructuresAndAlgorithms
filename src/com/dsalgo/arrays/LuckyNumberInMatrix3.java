package com.dsalgo.arrays;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumberInMatrix3 {
    public static void main(String[] args) {
        int[][] mat = {{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}};
        System.out.println(luckyNumbers(mat));
    }

    private static List<Integer> luckyNumbers(int[][] mat) {
        List<Integer> luckyNums = new ArrayList<>();
        for(int i = 0; i < mat.length; i++){
            int min = mat[i][0];
            int index = 0;
            for(int j = 0; j < mat[i].length; j++){
                if(min > mat[i][j]){
                    min = mat[i][j];
                    index = j;
                }
            }

            int max = mat[i][index];
            for(int j = 0; j < mat.length; j++){
                if(max < mat[j][index]){
                    max = mat[j][index];
                }
            }
            if(min == max){
                luckyNums.add(max);
            }
        }
        return luckyNums;
    }
}
