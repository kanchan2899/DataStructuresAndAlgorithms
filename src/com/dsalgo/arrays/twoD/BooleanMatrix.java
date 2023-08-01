package com.dsalgo.arrays.twoD;

import java.util.Arrays;

// https://www.geeksforgeeks.org/a-boolean-matrix-question/?ref=gcse
public class BooleanMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {0, 0, 0}};
        booleanMatrix(arr);
        System.out.println(Arrays.deepToString(arr));
        int[][] arr1 = {{1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {0, 0, 0}};
        booleanMatrix1(arr1);
        System.out.println(Arrays.deepToString(arr1));
    }

    /**
     * Using extra space:
     *
     * 1. Create two temporary arrays row[M] and col[N]. Initialize all values of row[] and col[] as 0.
     * 2. Traverse the input matrix mat[M][N]. If you see an entry mat[i][j] as true, then mark
     * row[i] and col[j] as true.
     * 3. Traverse the input matrix mat[M][N] again. For each entry mat[i][j], check the values
     * of row[i] and col[j]. If any of the two values (row[i] or col[j]) is true, then mark mat[i][j] as true.
     *
     *
     * @param arr
     */
    private static void booleanMatrix1(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;
        int row[] = new int[r];
        int col[] = new int[c];

        // store the rows and columns to be marked as 1 in row[] and col[] arrays respectively
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(arr[i][j] == 1) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        // modify the input matrix using the above constructed row[] and col[] arrays
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(row[i] == 1 || col[j] == 1) {
                    arr[i][j] = 1;
                }
            }
        }
    }

    /**
     * Using bruteforce: Traverse through the matrix and if you find an element with value 1, then change
     * all the elements in its row and column to -1, except when an element is 1. The reason for
     * not changing other elements to 1, but -1, is because that might affect other columns and rows.
     * Now traverse through the matrix again and if an element is -1, change it to 1
     *
     * TC: O(n * m * (n + m)
     * SC: O(1)
     *
     * @param arr
     */
    private static void booleanMatrix(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        // iterate through each element of the matrix
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // if the element is 1, mark its corresponding row and column using -1
                if(arr[i][j] == 1) {
                    // mark all elements in the same column as -1, except for other -1's
                    int index = i - 1;
                    while (index >= 0) {
                        if(arr[index][j] != 1) {
                            arr[index][j] = -1;
                        }
                        index--;
                    }
                    index = i + 1;
                    while (index < rows) {
                        if(arr[index][j] != 1) {
                            arr[index][j] = -1;
                        }
                        index++;
                    }

                    // mark all elements in the same row as -1, except for other -1's
                    index = j - 1;
                    while (index >= 0) {
                        if(arr[i][index] != 1) {
                            arr[i][index] = -1;
                        }
                        index--;
                    }
                    index = j + 1;
                    while (index < cols) {
                        if(arr[i][index] != 1) {
                            arr[i][index] = -1;
                        }
                        index++;
                    }
                }
            }
        }
        // iterate through the matrix again, setting all -1's to 1
        for (int i= 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(arr[i][j] == -1) {
                    arr[i][j] = 1;
                }
            }
        }
    }
}
