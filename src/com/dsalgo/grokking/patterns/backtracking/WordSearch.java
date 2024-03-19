package com.dsalgo.grokking.patterns.backtracking;


// https://leetcode.com/problems/word-search/
public class WordSearch {
    public static void main(String[] args) {
        String word = "EDUCATIE";
        char[][] grid = {{'E', 'D', 'X', 'I', 'W'},
                        {'P', 'U', 'F', 'M', 'Q'},
                        {'I', 'C', 'Q', 'R', 'F'},
                        {'M', 'A', 'L', 'C', 'A'},
                        {'J', 'T', 'I', 'V', 'E'}};
        System.out.println(wordSearch(grid, word));
    }

    private static boolean wordSearch(char[][] grid, String word) {
        int n = grid.length;
        int m = grid[0].length;

        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                if(depthFirstSearch(row, col, word, grid)) {
                    return true;
                }
            }
        }
        return false;
    }

    // apply backtracking on every element to search the required word
    private static boolean depthFirstSearch(int row, int col, String word, char[][] grid) {
        // base case
        if(word.length() == 0) {
            return true;
        }
        // check if the cell is not out of bounds or particular grid element is not among required chars
        if(row < 0 || row == grid.length || col < 0 || col == grid[0].length || grid[row][col] != word.charAt(0)) {
            return false;
        }

        boolean result = false;

        // mark the cell as visited
        grid[row][col] = '*';

        // explore the four neighbouring directions that is right, left, up, down by adding
        // (0, 1), (1, 0), (0, -1), (-1, 0) indices respectively
        int[][] offsets = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for(int[] offset : offsets) {
            int rowOffset = offset[0];
            int colOffset = offset[1];

            result = depthFirstSearch(row + rowOffset, col + colOffset, word.substring(1), grid);

            if(result) {
                break;
            }
        }

        grid[row][col] = word.charAt(0);

        return result;
    }
}
