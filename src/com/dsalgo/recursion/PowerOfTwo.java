package com.dsalgo.recursion;

// https://leetcode.com/problems/power-of-two/
public class PowerOfTwo {
    public static void main(String[] args) {
        int n = 64;
        System.out.println(isPowerOfTwo(n));
    }
    public static boolean isPowerOfTwo(int n) {
        if(n == 0)
            return false;
        if(n == 1)
            return true;
        if(n % 2 == 0){
            return isPowerOfTwo(n/2);
        }
        return false;
    }
}
