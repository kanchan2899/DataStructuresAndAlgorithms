package com.dsalgo.bit.manipulation;

// https://practice.geeksforgeeks.org/problems/bit-difference-1587115620/1
public class BitDifference {
    public static void main(String[] args) {
        int a = 10, b = 20;
        System.out.println(countBitsFlip(a, b));
    }

    public static int countBitsFlip(int a, int b){
        int count = 0;
        while(a != 0 || b != 0) {
            int x = a % 2;
            int y = b % 2;
            if(x != y) {
                count++;
            }
            a >>= 1;
            b >>= 1;
        }
        return count;
    }
}
