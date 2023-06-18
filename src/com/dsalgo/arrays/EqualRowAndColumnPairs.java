package com.dsalgo.arrays;

// https://leetcode.com/problems/equal-row-and-column-pairs/
public class EqualRowAndColumnPairs {
    public static void main(String[] args) {
        int[][] arr = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        System.out.println(equalPairs(arr));
    }
    public static int equalPairs(int[][] grid) {

        int count = 0;
        int iterations = 0;
        while (iterations < grid.length) {
            for(int i = 0; i < grid.length; i++) {
                int j = 0;
                for(; j < grid.length; j++) {
                    if(grid[iterations][j] != grid[j][i]) {
                        break;
                    }
                }
                count += j == grid.length ? 1 : 0;
            }
            iterations++;
        }
        return count;
    }
}
