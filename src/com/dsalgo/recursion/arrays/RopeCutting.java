package com.dsalgo.recursion.arrays;


public class RopeCutting {
    public static void main(String[] args) {
        int n = 24, a = 2, b = 2, c = 2;
        System.out.println(maxRopes(n, a, b, c));
    }

    /**
     * TC: O(3^n)
     * SC: O(n)
     *
     * @param n
     * @param a
     * @param b
     * @param c
     * @return
     */
    private static int maxRopes(int n, int a, int b, int c) {
        if(n == 0)
            return 0;
        if(n == -1)
            return -1;

        int res = Math.max(Math.max(maxRopes(n - a, a, b, c),
                        maxRopes(n - b, a, b, c)),
                maxRopes(n - c, a, b, c));

        if(res == -1) {
            return -1;
        }

        return res + 1;
    }
}
