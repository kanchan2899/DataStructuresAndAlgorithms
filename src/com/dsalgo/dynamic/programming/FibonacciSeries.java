package com.dsalgo.dynamic.programming;

public class FibonacciSeries {
    public static void main(String[] args) {
        int n = 7;

        System.out.println(fib(n));
    }

    private static long fib(int n) {
        if(n == 1) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        long[] mem = new long[n + 1];

        return helper(n, mem);
    }

    private static long helper(int n, long[] mem) {
        mem[1] = 0;
        mem[2] = 1;

        for(int i = 3; i <= n; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }

        return mem[n];
    }
}
