package com.dsalgo.arrays.twoD;

// https://practice.geeksforgeeks.org/problems/make-matrix-beautiful-1587115620/1
// https://www.geeksforgeeks.org/minimum-operations-required-make-row-column-matrix-equals/
public class MakeMatrixBeautiful {
    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {3, 4}};
        System.out.println("Minimum operations required to make matrix beautiful is " + minOperations(arr));
    }

    /**
     * The idea is to calculate the maximum sum of each row and each column and then perform operations
     * on the rows and cols which has sum less the maximum sum calculated.
     *
     * Algo:
     * 1. Let’s assume that maxSum is the maximum sum among all rows and columns.
     * We just need to increment some cells such that the sum of any row or column becomes ‘maxSum’.
     * 2. Let’s say Xi is the total number of operations needed to make the sum on row ‘i’ equals
     * to maxSum and Yj is the total number of operations needed to make the sum on column ‘j’
     * equal to maxSum.
     * 3. Since Xi = Yj so we need to work at any one of them according to the condition.
     * 4. In order to minimize Xi, we need to choose the maximum from rowSumi and colSumj as it
     * will surely lead to minimum operation. After that, increment ‘i’ or ‘j’ according to the
     * condition satisfied after the increment.
     *
     * @param arr
     * @return
     */
    private static int minOperations(int[][] arr) {
        int n = arr.length;
        int[] sumRow = new int[n];
        int[] sumCol = new int[n];

        // calculate sumRow[] and sumCol[] array
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sumRow[i] += arr[i][j];
                sumCol[j] += arr[i][j];
            }
        }

        // find the maximum sum value in either row or in column
        int maxSum = 0;
        for(int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, sumRow[i]);
            maxSum = Math.max(maxSum, sumCol[i]);
        }

        int count = 0;
        for(int i = 0, j = 0; i < n && j < n;) {
            // find minimum increment required in either row or column
            int diff = Math.min(maxSum - sumRow[i], maxSum - sumCol[j]);

            // add difference in corresponding cell, sumRow[] and sumCol[] array
            arr[i][j] += diff;
            sumRow[i] += diff;
            sumCol[j] += diff;

            // update the count variable
            count += diff;

            // if ith row satisfied, increment ith value for next iteration
            if(sumRow[i] == maxSum) {
                i++;
            }

            // if jth col satisfied, increment jth value for next iteration
            if(sumCol[i] == maxSum) {
                j++;
            }
        }
        return count;
    }
}
