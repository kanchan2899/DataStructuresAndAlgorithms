package com.dsalgo.graphs;

// https://www.geeksforgeeks.org/find-the-number-of-x-total-shapes/
public class TotalXShapes {
    public static void main(String[] args) {
        char[][] grid = { { 'X', 'O', 'X' },
            { 'O', 'X', 'O' },
            { 'X', 'X', 'X' } };

        System.out.println(xShape(grid));

    }

    /**
     * Using DFS: The idea is to apply dfs from every cell having ‘X’ and not visited, mark all its
     * adjacent cells visited if their value is X and increase the answer by one.
     *
     * 1. Instead of using an extra vector vis of size n*m to keep track of what cell is visited and
     * not, we can simply convert a visited cell having ‘X’ to ‘O’
     * 2. Initialize variable ans with 0, it will keep count of connected components having only ‘X‘.
     * 3. Make a function dfs(x, y) to mark the whole connected component having only ‘X’ as visited
     * by converting all ‘X’ to ‘O’.
     * 4. Run 2 nested loops for iterating over the whole grid
     *      a. Check if the current cell is having ‘X‘, then run a dfs from it and convert all cells
     *      in its connected component as ‘O’ and
     *      b. Increase the variable ans by 1.
     * 5. Return variable ans as the answer.
     *
     * TC: O(n * m)
     * SC: O(n * m)
     *
     * @param grid
     * @return
     */
    private static int xShape(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int i, j, count = 0;

        for(i = 0; i < n; i++) {
            for(j = 0; j < m; j++) {
                if(grid[i][j] == 'X') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }

        if(grid[i][j] == 'X') {
            grid[i][j] = 'O';
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }
}
