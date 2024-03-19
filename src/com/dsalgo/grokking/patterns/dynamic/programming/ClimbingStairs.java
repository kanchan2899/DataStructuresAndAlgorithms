package com.dsalgo.grokking.patterns.dynamic.programming;

// https://leetcode.com/problems/climbing-stairs/description/
public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbingStairs(n));
    }

    private static int climbingStairs(int n) {
        if(n <= 1) {
            return 1;
        }
        int[] lookup = new int[n + 1];

        lookup[1] = 1;
        lookup[2] = 2;

        for(int i = 3; i <= n; i++) {
            lookup[i] = lookup[i - 1] + lookup[i - 2];
        }

        return lookup[n];
    }
}
