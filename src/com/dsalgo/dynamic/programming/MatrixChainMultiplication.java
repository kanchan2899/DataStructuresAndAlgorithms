package com.dsalgo.dynamic.programming;

import java.util.Arrays;

// https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        System.out.println(matrixChainMultiplication(arr, 1, arr.length - 1));
        System.out.println(matrixChainMultiplication1(arr));
        System.out.println(matrixChainMultiplication2(arr, arr.length));
    }

    private static int matrixChainMultiplication2(int[] arr, int n) {
        int[][] dp = new int[n][n];
        int i, j, k, L, q;

        /* m[i, j] = Minimum number of scalar
        multiplications needed to compute the matrix
        A[i]A[i+1]...A[j] = A[i..j] where
        dimension of A[i] is p[i-1] x p[i] */

        for(i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // L is the chain length
        for(L = 2; L < n; L++) {
            for(i = 1; i < n - L + 1; i++) {
                j = i + L - 1;
                if(j == n) {
                    continue;
                }
                dp[i][j] = Integer.MAX_VALUE;
                for(k = i; k <= j - 1; k++) {
                    // q = cost / scalar multiplications
                    q = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    if(q < dp[i][j]) {
                        dp[i][j] = q;
                    }
                }
            }
        }
        return dp[1][n - 1];
    }

    /**
     * Using DP - Memoization:
     *
     * 1. Build a matrix dp[][] of size N*N for memoization purposes.
     * 2. Use the same recursive call as done in the above approach:
     *      - When we find a range (i, j) for which the value is already calculated, return the
     *      minimum value for that range (i.e., dp[i][j]).
     *      - Otherwise, perform the recursive calls as mentioned earlier.
     * 3. The value stored at dp[0][N-1] is the required answer.
     *
     * TC: O(n ^ 3)
     * SC: O(n ^ 2)
     *
     * @param arr

     * @return
     */
    private static int matrixChainMultiplication1(int[] arr) {
        int[][] dp = new int[100][100];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int i = 1, j = arr.length - 1;

        return helper(arr, i, j, dp);
    }

    private static int helper(int[] arr, int i, int j, int[][] dp) {
        if(i == j) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        dp[i][j] = Integer.MAX_VALUE;

        for(int k = i; k < j; k++) {
            dp[i][j] = Math.min(dp[i][j],
                    helper(arr, i, k, dp) + helper(arr, k + 1, j, dp) + arr[i - 1] * arr[j] * arr[k]);
        }
        return dp[i][j];
    }

    /**
     * Using Recursion:
     *
     * 1. Create a recursive function that takes i and j as parameters that determines the range
     * of a group.
     *      - Iterate from k = i to j to partition the given range into two groups.
     *      - Call the recursive function for these groups.
     *      - Return the minimum value among all the partitions as the required minimum number of
     *      multiplications to multiply all the matrices of this group.
     * 2. The minimum value returned for the range 0 to N-1 is the required answer.
     *
     * @param arr
     * @param i
     * @param j
     * @return
     */
    private static int matrixChainMultiplication(int[] arr, int i, int j) {
        if(i == j)
            return 0;
        int min = Integer.MAX_VALUE;

        for(int k = i; k < j; k++) {
            int count = matrixChainMultiplication(arr, i, k) +
                    matrixChainMultiplication(arr, k + 1, j) +
                    arr[i - 1] * arr[k] * arr[j];

            if(count < min) {
                min = count;
            }
        }
        return min;
    }
}
