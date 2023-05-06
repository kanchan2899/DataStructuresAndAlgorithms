package com.dsalgo.recursion.gfSeries;


// https://practice.geeksforgeeks.org/problems/gf-series3535
public class GFSeries {
    public static void main(String[] args) {
        int n = 6;
        gfSeries(n);
    }
    static void gfSeries(int N){
        System.out.print("0 1 ");
        calculateGf(0, 1, N-2);
        System.out.println();
    }
    static void calculateGf(long n1, long n2, int count) {
        if (count <= 0) {
            return;
        }
        long n = (n1 * n1) - n2;
        System.out.print(n + " ");
        calculateGf(n2, n,  count - 1);
    }

}
