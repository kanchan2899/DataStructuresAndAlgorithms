package com.dsalgo.maths;

// https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Mathematics/problem/modular-multiplicative-inverse-1587115620
public class ModularMultiplicativeInverse {
    public static void main(String[] args) {
        int a = 3;
        int m = 11;
        System.out.println(modInverse(a, m));
    }
    public static int modInverse(int a, int m) {
        int inverse = -1;
        for(int i = 0; i < m; i++) {
            if((i * a) % m == 1) {
                inverse = i;
            }
        }
        return inverse;
    }
}
