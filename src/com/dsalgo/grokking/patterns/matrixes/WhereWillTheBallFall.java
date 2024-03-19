package com.dsalgo.grokking.patterns.matrixes;

import java.util.Arrays;

public class WhereWillTheBallFall {
    public static void main(String[] args) {
        int[][]  matrix = {{-1, -1, -1, -1}, {1, 1, 1, 1}, {-1, -1, -1, -1}, {1, 1, 1, 1}};
        System.out.println(Arrays.toString(findExitColumn(matrix)));
    }

    /**
     * 1. Declare an array, result, of size grid.length, and initialize its elements with -1,
     * assuming that each ball will be stuck in the grid. We will change the values for the columns
     * where the balls will succeed in reaching the last row.
     * 2. Iterate the grid using nested for loops. For each column, perform the following checks:
     *  - For each row, row, do the following:
     *      - Compute nextColumn by adding currentColumn to grid[row][currentColumn].
     *      - Check if grid[row][nextColumn] has the same value as grid[row][currentColumn].
     *      If so, the ball can move to the next row.
     *      - Check if the ball is not stuck at the boundary of the grid by checking if the
     *      nextColumn is less than zero or greater than the columns of the grid.
     *      - Set the currentColumn as the nextColumn.
     *      - If this is the last row, set result[col] to nextColumn.
     *
     *
     * @param matrix
     * @return
     */
    private static int[] findExitColumn(int[][] matrix) {
        int[] result = new int[matrix[0].length];

        // fill the result array with -1
        Arrays.fill(result, -1);

        // loop through each column in the grid
        for(int col = 0; col < matrix[0].length; col++) {
            int currentCol = col;
            // loop through each row in the grid
            for(int row = 0; row < matrix.length; row++) {
                int nextColumn = currentCol + matrix[row][currentCol];

                // check if the ball is out of the grid or hit a "V" shaped pattern
                if(nextColumn < 0 || nextColumn > matrix[0].length - 1 ||
                        matrix[row][currentCol] != matrix[row][nextColumn]) {
                    break;
                }

                // check if the ball has reached the bottom
                if(row == matrix.length - 1) {
                    result[col] = nextColumn;
                }
                currentCol = nextColumn;
            }
        }

        return result;
    }
}
