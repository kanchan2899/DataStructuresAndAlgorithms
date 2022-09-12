package com.dsalgo.bit.manipulation;

// https://www.geeksforgeeks.org/program-to-find-whether-a-given-number-is-power-of-2/
public class PowerOf2OrNot {
    public static void main(String[] args) {
        int n = 31;
        System.out.println(isPowerOf2(n));
    }

    private static boolean isPowerOf2(int n) {
        if(n == 0)
            return false;
        if((n & (n - 1)) == 0){
            return true;
        }
        return false;
    }
}
