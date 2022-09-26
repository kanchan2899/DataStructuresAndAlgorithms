package com.dsalgo.bit.manipulation;

// https://leetcode.com/problems/number-complement/
public class NumberComplement {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(findComplement(num));
    }
    public static int findComplement(int num) {
        int x = 0;
        int base = 1;
        while(num > 0) {
            x = x + ((num & 1) ^ 1) * base;
            base = base * 2;
            num = num >> 1;
        }
        return x;
    }
}
