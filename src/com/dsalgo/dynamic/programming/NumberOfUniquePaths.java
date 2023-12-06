package com.dsalgo.dynamic.programming;

// https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
public class NumberOfUniquePaths {
    public static void main(String[] args) {
        int n = 3, m = 3;

        System.out.println(uniquePaths(m, n));
        System.out.println(uniquePaths1(m, n));
        System.out.println(uniquePaths2(m, n));
    }

    private static int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];

        // Count of paths to reach any cell in first column is 1
        for(int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // Count of paths to reach any cell in first row is 1
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * Using DP - Memoization: Declare a 2-D array to save the values for different states of the
     * recursive function and later on use the values of this dp array to get the answer for already
     * solved subproblems
     * 1. Declare a 2-D array of size N X M
     * 2. Create a recursive function with parameters as row and column index and 2-D array
     * 3. Call this recursive function for N-1 and M-1
     * 4. In the recursive function
     *      a. If N == 1 or M == 1 then return 1
     *      b. If the value of this recursive function is not stored in the 2-D array then call the recursive function for (N-1, M, dp) and (N, M-1, dp) and assign the sum of answers of these functions in the 2-D array and return this value
     *      c. else return the value of this function stored in the 2-D array
     * 5. Print the answer
     *
     * TC: O(m * n)
     * SC: O(m * n)
     *
     * @param m
     * @param n
     * @return
     */
    private static int uniquePaths1(int m, int n) {
        int[][] mem = new int[m + 1][n + 1];
        return helper(m, n, mem);
    }

    private static int helper(int m, int n, int[][] mem) {
        if(n == 1 || m == 1) {
            return mem[m][n] = 1;
        }
        if(mem[m][n] == 0) {
            mem[m][n] = helper(m - 1, n, mem) + helper(m, n - 1, mem);
        }
        return mem[m][n];
    }

    /**
     * Using recursion: Recursively move to right and down from the start until we reach the
     * destination and then add up all valid paths to get the answer.
     *
     * TC: O(2 ^ n)
     * SC: O(n + m)
     *
     * @param m
     * @param n
     * @return
     */
    private static int uniquePaths(int m, int n) {
        if(m == 1 || n == 1) {
            return 1;
        }
        return uniquePaths(m - 1, n) + uniquePaths(m , n - 1);
    }
}
