package com.dsalgo.arrays;

public class FindTheSafePosition {
    public static void main(String[] args) {
        int n = 2, k = 1;
        System.out.println(safePos(n, k));
    }
    static int safePos(int n, int k) {
        if(n == 1){
            return 1;
        }
        return (safePos(n-1, k) + k - 1) % n + 1;
    }
}
