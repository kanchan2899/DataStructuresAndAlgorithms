package com.dsalgo.recursion.numbers;

// https://leetcode.com/problems/powx-n/
public class PowerOfX {
    public static void main(String[] args) {
        double x = 2.000;
        int n = -3;
        System.out.println(pow(x, n));
    }

    private static double pow(double x, int n) {
        if(n == 0) {
            return 1;
        }

        if(n < 0) {
            n = Math.abs(n);
            x = 1 / x;
        }

        if(n % 2 == 0) {
            return pow(x * x, n / 2);
        } else {
            return x * pow(x * x, n / 2);
        }
    }
}
