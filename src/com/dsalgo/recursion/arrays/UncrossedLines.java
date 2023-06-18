package com.dsalgo.recursion.arrays;

import java.util.Arrays;

public class UncrossedLines {
    public static void main(String[] args) {
        int[] a = {1, 4, 2};
        int[] b = {1, 2, 4};

        System.out.println(uncrossedLines(a, b));
        System.out.println(uncrossedLines1(a, b));
    }

    private static int uncrossedLines1(int[] a, int[] b) {
        int[][] dp = new int[a.length][b.length];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return helper1(a, b, 0, 0, dp);
    }

    private static int helper1(int[] a, int[] b, int i, int j, int[][] dp) {
        if(i == a.length || j == b.length) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        int count = 0;
        if(a[i] == b[j]) {
            count = 1 + helper1(a, b, i+1, j+1, dp);
        } else {
            count += Math.max(helper1(a, b, i+1, j, dp), helper1(a, b, i, j+1, dp));
        }
        dp[i][j] = count;
        return dp[i][j];
    }

    private static int uncrossedLines(int[] a, int[] b) {
        return helper(a, b, 0, 0);
    }

    private static int helper(int[] a, int[] b, int i, int j) {
        if(i == a.length || j == b.length)
            return 0;
        int count = 0;
        if(a[i] == b[j]) {
            count = 1 + helper(a, b, i+1, j+1);
        } else {
            count += Math.max(helper(a, b, i+1, j), helper(a, b, i, j+1));
        }
        return count;
    }
}
