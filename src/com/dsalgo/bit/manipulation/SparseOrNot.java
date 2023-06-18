package com.dsalgo.bit.manipulation;

// https://practice.geeksforgeeks.org/problems/number-is-sparse-or-not-1587115620/1
public class SparseOrNot {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(isSparse(n));
    }

    public static boolean isSparse(int n) {
        int count;
        while (n != 0) {
            count = 0;
            if(n % 2 == 1) {
                while(n % 2 == 1) {
                    count++;
                    n >>= 1;
                    if(count > 1) {
                        return false;
                    }
                }
            }
            n >>= 1;
        }
        return true;
    }
}
