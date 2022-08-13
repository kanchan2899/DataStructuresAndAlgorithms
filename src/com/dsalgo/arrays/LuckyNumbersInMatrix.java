package com.dsalgo.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// https://leetcode.com/problems/lucky-numbers-in-a-matrix
public class LuckyNumbersInMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}};
        System.out.println(luckyNumbers(mat));
    }
    public static List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> maxListInCols = findMaxInColumns(matrix);
        List<Integer> minListInRows = findMinInRows(matrix);
        return intersectionOfMinsAndMaxs(minListInRows, maxListInCols);
    }

    private static List<Integer> intersectionOfMinsAndMaxs(List<Integer> minListInRows, List<Integer> maxListInCols) {
        List<Integer> commonElements = minListInRows.stream()
                                        .filter(maxListInCols :: contains)
                                        .collect(Collectors.toList());
        if(!commonElements.isEmpty()){
            return commonElements;
        }
        return Collections.emptyList();
    }

    private static List<Integer> findMinInRows(int[][] matrix) {
        List<Integer> minList = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                }
            }
            minList.add(min);
        }
        return minList;
    }

    public static List<Integer> findMaxInColumns(int[][] matrix){
        List<Integer> maxList = new ArrayList<>();
        for(int i = 0; i < matrix[0].length; i++){
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < matrix.length; j++){
                if(matrix[j][i] > max){
                    max = matrix[j][i];
                }
            }
            maxList.add(max);
        }
        return maxList;
    }
}
