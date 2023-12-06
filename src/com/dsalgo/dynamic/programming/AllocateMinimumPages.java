package com.dsalgo.dynamic.programming;

// https://www.geeksforgeeks.org/allocate-minimum-number-pages/
public class AllocateMinimumPages {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        int k = 2;
        System.out.println(minPages(arr, arr.length, k));
        System.out.println(minPages1(arr, arr.length, k));
    }

    private static int minPages1(int[] arr, int n, int k) {
        int[][] dp = new int[k + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            dp[1][i] = sum(arr, 0, i - 1);
        }

        for(int i = 1; i <= k; i++) {
            dp[i][1] = arr[0];
        }

        for(int i = 2; i <= k; i++) {
            for(int j = 2; j <= n; j++) {
                int minPages = Integer.MAX_VALUE;
                for(int p = 1; p < j; p++) {
                    minPages = Math.min(minPages, Math.max(dp[i - 1][p], sum(arr, p, j - 1)));
                }
                dp[i][j] = minPages;
            }
        }
        return dp[k][n];
    }

    private static int minPages(int[] arr, int n, int k) {
        if(k == 1) {
            return sum(arr, 0, n - 1);
        }
        if(n == 1) {
            return arr[0];
        }
        int minPages = Integer.MAX_VALUE;

        for(int i = 1; i < n; i++) {
            minPages = Math.min(minPages, Math.max(minPages(arr, i, k - 1), sum(arr, i, n - 1)));
        }

        return minPages;
    }

    private static int sum(int[] arr, int i, int j) {
        int s = 0;
        for(int k = i; k <= j; k++) {
            s += arr[i];
        }
        return s;
    }


}
