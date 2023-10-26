package com.dsalgo.graphs;

// https://practice.geeksforgeeks.org/problems/length-of-largest-region-of-1s-1587115620/1
public class UnitAreaOfLargestRegionOf1s {

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,0},{0,0,1,0},{0,0,0,1}};
        System.out.println(findMaxArea(grid));
    }
    public static int findMaxArea(int[][] grid)
    {
        int area = 0;
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    area = Math.max(area, dfs(grid, i, j));
                }
            }
        }

        return area;
    }

    static int dfs(int[][] grid, int i, int j) {
        int[] row = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] col = {-1, -1, 0, 1, 1, 1, 0, -1};

        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0) {
            return 0;
        }

        else if(grid[i][j] == 1) {
            int area = 1;
            for(int p = 0; p < 8; p++) {
                int newi = i + row[p];
                int newj = j + col[p];

                grid[i][j] = 0;

                area += dfs(grid, newi, newj);
            }
            return area;
        }

        return 0;
    }
}
