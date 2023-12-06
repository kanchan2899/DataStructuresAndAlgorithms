package com.dsalgo.dynamic.programming;

// https://www.geeksforgeeks.org/ways-to-write-n-as-sum-of-two-or-more-positive-integers/
public class WriteNAsSum {
    static int countWays(int n) {
        int[] mem = new int[n + 1];

        // base case if given value is 0
        mem[0] = 1;

        // pick all integer one by one and update the mem[] values after the index
        // greater than or equal to n
        for(int i = 1; i < n; i++) {
            for(int j = i; j <= n; j++) {
                mem[j] += mem[j - i];
            }
        }

        return mem[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(countWays(n));
    }
}
