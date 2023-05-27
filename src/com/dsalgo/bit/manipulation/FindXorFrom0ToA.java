package com.dsalgo.bit.manipulation;

// https://www.geeksforgeeks.org/calculate-xor-1-n/
public class FindXorFrom0ToA {

    public static void main(String[] args) {
        int a = 5;
        System.out.println(xorOfN(a));
        System.out.println(xorOfN1(a));
    }

    /**
     * Bruteforce: Initialize res to 0. Traverse all numbers from 1 to n and do XOR of numbers
     * one by one with res. Return res.
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param n
     * @return
     */
    private static int xorOfN1(int n) {
        int res = 0;
        for(int i = 1; i <= n; i++) {
            res ^= i;
        }
        return res;
    }

    /**
     *
     * @param a
     * @return
     */
    private static int xorOfN(int a) {
        if(a % 4 == 0)
            return a;
        if(a % 4 == 1)
            return 1;
        if(a % 4 == 2)
            return a + 1;
        return 0;
    }
}
