package com.dsalgo.bit.manipulation;

// https://leetcode.com/problems/binary-number-with-alternating-bits/
public class AlternatingBitsNumber {
    public static void main(String[] args) {
        int num = 11;
        System.out.println(hasAlternatingBits(num));
    }
    public static boolean hasAlternatingBits(int n) {
        int lastBit;
        int secondLastBit;
        while(n > 0) {
            lastBit = n & 1;
            n = n >> 1;
            secondLastBit = n & 1;
            if(lastBit == secondLastBit)
                return false;
        }
        return true;
    }
}
