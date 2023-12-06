package com.dsalgo.dynamic.programming;

// https://www.geeksforgeeks.org/program-calculate-value-ncr/
public class NCR {
    public static void main(String[] args) {
        int n = 5, r = 2;
        System.out.println(ncr(n, r));
        System.out.println(ncr1(n, r));
        System.out.println(ncr2(n, r));
    }

    private static int ncr2(int n, int r) {
        if(r > n) {
            return 0;
        }
        if(r == 0 || n == 0) {
            return 1;
        }

        return ncr2(n - 1, r - 1) + ncr2(n - 1, r);
    }

    /**
     * Using DP - Tabulation, space optimized
     * @param n
     * @param r
     * @return
     */
    private static int ncr1(int n, int r) {
        int[] c = new int[r + 1];
        c[0] = 1;

        for(int i = 1; i <= n; i++) {
            for(int j = Math.min(i, r); j > 0; j--) {
                c[j] = c[j] + c[j - 1];
            }
        }
        return c[r];
    }

    /**
     * Using DP - Tabulation
     *
     * TC: O(n * r)
     * SC: O(n * r)
     *
     * @param n
     * @param r
     * @return
     */
    private static int ncr(int n, int r) {
        int c[][] = new int[n + 1][r + 1];
        int i, j;

        for(i = 0; i <= n; i++) {
            for(j = 0; j <= Math.min(i, r); j++) {
                if(j == 0 || j == i) {
                    c[i][j] = 1;
                } else {
                    c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
                }
            }
        }
        return c[n][r];
    }
}
