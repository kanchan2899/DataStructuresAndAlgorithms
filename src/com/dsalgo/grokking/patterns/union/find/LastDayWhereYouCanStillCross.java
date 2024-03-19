package com.dsalgo.grokking.patterns.union.find;

// https://leetcode.com/problems/last-day-where-you-can-still-cross/
class UnionFind4 {
    private int[] reps;

    public UnionFind4(int n) {
        reps = new int[n];

        for(int i = 0; i < n; i++) {
            reps[i] = i;
        }
    }

    public int find(int x) {
        if(reps[x] != x) {
            reps[x] = find(reps[x]);
        }
        return reps[x];
    }

    public void union(int v1, int v2) {
        reps[find(v1)] = find(v2);
    }
}
public class LastDayWhereYouCanStillCross {
    public static void main(String[] args) {
        int[][] allWaterCells = {{1, 5}, {2, 5}, {2, 4}, {2, 3}, {2, 2}, {3, 2}, {4, 2}, {4, 1}, {3, 1}, {2, 1},
                {1, 1}, {1, 2}, {1, 3}, {1, 4}, {3, 3}, {3, 5}, {3, 4}, {4, 5}, {4, 3}, {4, 4}};
        int rows = 4;
        int cols = 5;
        System.out.println(lastDayToCross(rows, cols, allWaterCells));
    }

    private static int lastDayToCross(int rows, int cols, int[][] waterCells) {
        int day = 0;
        int[][] matrix = new int[rows][cols];
        int leftNode = 0;
        int rightNode = rows * cols + 1;

        int[][] waterDirections = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int[][] convertedWaterCells = new int[waterCells.length][2];

        for(int i = 0; i < waterCells.length; i++) {
            convertedWaterCells[i] = new int[]{waterCells[i][0] - 1, waterCells[i][1] - 1};
        }

        UnionFind4 uf = new UnionFind4(rows * cols + 2);

        for(int [] cell : convertedWaterCells) {
            int row = cell[0];
            int col = cell[1];

            matrix[row][col]  = 1;

            for(int[] direction: waterDirections) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if(withinBounds(newRow, newCol, rows, cols) && matrix[newRow][newCol] == 1) {
                    uf.union(findIndex(row, col, cols), findIndex(newRow, newCol, cols));
                }
            }
            if(col == 0) {
                uf.union(findIndex(row, col, cols), leftNode);
            }

            if(col == cols - 1) {
                uf.union(findIndex(row, col, cols), rightNode);
            }

            if(uf.find(leftNode) == uf.find(rightNode)) {
                break;
            }
            day++;
        }
        return day;
    }

    // maps the index of the element in 2-D matrix to an index of the 1-D array (reps)
    public static int findIndex(int currentRow, int currentCol, int cols) {
        return currentRow * cols + (currentCol + 1);
    }

    // checks whether the water cells to be connected are within the bounds of the matrix as per given dimensions
    public static boolean withinBounds(int row, int col, int rows, int cols) {
        return col >= 0 && col < cols && row >= 0 && row < rows;
    }
}
