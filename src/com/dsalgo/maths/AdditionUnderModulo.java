package com.dsalgo.maths;

// https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Mathematics/problem/addition-under-modulo
public class AdditionUnderModulo {
    public static void main(String[] args) {
        long a = 9223372036854775807l;
        long b = 9223372036854775807l;
        System.out.println(sumUnderModulo(a, b));
    }

    public static long sumUnderModulo(long a, long b){
        long m = 1000000007;
        a = a % m;
        b = b % m;
        return (a + b) % m;
    }
}
