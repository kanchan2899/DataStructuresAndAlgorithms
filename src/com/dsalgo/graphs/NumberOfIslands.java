package com.dsalgo.graphs;

// https://www.geeksforgeeks.org/find-the-number-of-islands-using-dfs/
public class NumberOfIslands {
    public static void main(String[] args) {
        int[][] adjacencyMatrix = { { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };

        System.out.println(numberOfIslands(adjacencyMatrix));
    }

    /**
     * Using DFS:
     *
     * 1. Initialize count = 0, to store the answer.
     * 2. Traverse a loop from 0 till ROW
     *  - Traverse a nested loop from 0 to COL
     *      - If the value of the current cell in the given matrix is 1
     *          - Increment count by 1
     *          - Call DFS function
     *              - If the cell exceeds the boundary or the value at the current cell is 0
     *                  - Return.
     *              - Update the value at the current cell as 0.
     *              - Call DFS on the neighbor recursively
     * 3. Return count as the final answer.
     * @param adjacencyMatrix
     * @return
     */
    private static int numberOfIslands(int[][] adjacencyMatrix) {
        int n = adjacencyMatrix.length;
        int m = adjacencyMatrix[0].length;

        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(adjacencyMatrix[i][j] == 1) {
                    count++;
                    dfs(adjacencyMatrix, i, j, n, m);
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] adjacencyMatrix, int i, int j, int n, int m) {
        if(i < 0 || i > n - 1 || j < 0 || j > m - 1 || adjacencyMatrix[i][j] != 1) {
            return;
        }
        if(adjacencyMatrix[i][j] == 1) {
            adjacencyMatrix[i][j] = 0;

            // right traversal
            dfs(adjacencyMatrix, i + 1, j, n, m);

            // left traversal
            dfs(adjacencyMatrix, i - 1, j, n, m);

            // upward traversal
            dfs(adjacencyMatrix, i, j + 1, n, m);

            // downward traversal
            dfs(adjacencyMatrix, i, j - 1, n, m);

            // upward-right traversal
            dfs(adjacencyMatrix, i + 1, j + 1, n, m);

            // downward-left traversal
            dfs(adjacencyMatrix, i - 1, j - 1, n, m);

            // downward-right traversal
            dfs(adjacencyMatrix, i + 1, j - 1, n, m);

            // upward-left traversal
            dfs(adjacencyMatrix, i - 1, j + 1, n, m);
        }
    }
}
