package com.dsalgo.grokking.patterns.backtracking;

import java.util.Arrays;

// https://leetcode.com/problems/flood-fill/description/
public class FloodFill {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 1},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0}};
        int sr = 4, sc = 3, target = 3;

        System.out.println(Arrays.deepToString(floodFill(grid, sr, sc, target)));
    }

    private static int[][] floodFill(int[][] grid, int sr, int sc, int target) {
        // if the source cell already has the same value as target, return the original grid
        // we don't need to iterate through the whole grid in this case
        if(grid[sr][sc] == target) {
            return grid;
        } else {
            // storing the original value of the starting cell in old_target, this will help
            // in matching the values of the neighbouring cells
            int oldTarget = grid[sr][sc];

            // replace the value of the starting cell with the specified target
            grid[sr][sc] = target;

            // call the dfs() function on the starting cell to replace the values of all connected cells
            dfs(grid, sr, sc, oldTarget, target);

            return grid;
        }
    }

    private static void dfs(int[][] grid, int row, int col, int oldTarget, int target) {
        int[][] adjacentCells = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        // get the length of the grid and the length of each row
        int gridLength = grid.length;
        int totalCells = grid[0].length;

        // for each cell in the list of adjacent cells
        for(int[] cellValue: adjacentCells) {
            // calculate the row and column indices of the adjacent cells
            int i = row + cellValue[0];
            int j = col + cellValue[1];

            // if the adjacent cell is within the bounds of the grid and has the same value as
            // the starting cell
            if(i < gridLength && i >= 0 && j < totalCells && j >= 0 && grid[i][j] == oldTarget) {
                // replace the value of the adjacent cell with the specified target
                grid[i][j] = target;

                // recursively call dfs() on the adjacent cell to repeat the process
                dfs(grid, i, j, oldTarget, target);
            }
        }
    }
}
