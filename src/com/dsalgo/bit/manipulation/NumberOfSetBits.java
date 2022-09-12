package com.dsalgo.bit.manipulation;

// https://www.geeksforgeeks.org/count-set-bits-in-an-integer/
public class NumberOfSetBits {
    public static void main(String[] args) {
        int n = 90;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(countSetBits(n));
        System.out.println(countSetBits1(n));
    }

    private static int countSetBits1(int n) {
        int count = 0;
        while (n > 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    private static int countSetBits(int n) {
        int count = 0;
        while(n > 0){
            count++;
            n = n - (n & -n);
        }
        return count;
    }

}
