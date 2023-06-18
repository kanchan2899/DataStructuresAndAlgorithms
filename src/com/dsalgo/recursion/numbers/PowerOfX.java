package com.dsalgo.recursion.numbers;

// https://leetcode.com/problems/powx-n/
// https://practice.geeksforgeeks.org/problems/power-of-numbers-1587115620/1
public class PowerOfX {
    static int mod = 1000000007;
    public static void main(String[] args) {
        double x = 2.000;
        int n = -3;
        System.out.println(pow(x, n));
        int N = 361;
        int R = 163;
        System.out.println(pow1(N, R));
    }

    private static long pow1(int N, int R) {
        return helper(N, R);
    }

    private static long helper(long n, long r) {
        if(r == 0)
            return 1l;
        long temp = helper(n, r / 2);
        temp = (temp * temp) % mod;
        if(r % 2 == 0)
            return temp % mod;
        else
            return (n * temp) % mod;
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
