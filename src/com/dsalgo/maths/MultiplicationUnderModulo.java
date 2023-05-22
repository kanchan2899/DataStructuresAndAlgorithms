package com.dsalgo.maths;

// https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Mathematics/problem/multiplication-under-modulo
public class MultiplicationUnderModulo {
    public static void main(String[] args) {
        long a = 92233720368547758l;
        long b = 92233720368547758l;
        System.out.println(multiplicationUnderModulo(a, b));
    }

    public static long multiplicationUnderModulo(long a, long b){
        long m = 1000000007;
        a = a % m;
        b = b % m;
        return (a * b) % m;
    }
}
