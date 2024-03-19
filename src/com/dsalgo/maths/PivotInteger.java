package com.dsalgo.maths;

// https://leetcode.com/problems/find-the-pivot-integer/
public class PivotInteger {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(pivotInteger(n));
    }

    private static int pivotInteger(int n) {
        int ans = (n * n + n) / 2;
        int sq = (int) Math.sqrt(ans);
        if(sq * sq == ans) {
            return sq;
        }
        return -1;
    }
}
