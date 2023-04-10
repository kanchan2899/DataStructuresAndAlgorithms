package com.dsalgo.recursion.numbers;

public class Nto1and1toN {
    public static void main(String[] args) {
        int n = 5;
        nTo1(n);
        System.out.println();
        _1toN(n);
        System.out.println();
        nTo1_1Ton(n);
    }

    private static void nTo1_1Ton(int n) {
        if(n == 0)
            return;
        System.out.print(n + " ");
        nTo1_1Ton(n - 1);
        System.out.print(n + " ");
    }

    private static void _1toN(int n) {
        if(n == 0)
            return;
        _1toN(n - 1);
        System.out.print(n + " ");
    }

    private static void nTo1(int n) {
        if(n == 0)
            return;
        System.out.print(n + " ");
        nTo1(n - 1);
    }
}
