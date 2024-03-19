package com.dsalgo.grokking.patterns.dynamic.programming;

// https://leetcode.com/problems/n-th-tribonacci-number/
public class NthTribonacciNumber {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(trifibonacci(n));
    }

    private static int trifibonacci(int n) {
        if(n < 3) {
            return n == 0 ? 0 : 1;
        }
        int first = 0, second = 1, third = 1;
        int temp = 0;

        for(int i = 3; i <= n; i++) {
            temp = first + second + third;

            first = second;
            second = third;
            third = temp;
        }
        return third;
    }
}
