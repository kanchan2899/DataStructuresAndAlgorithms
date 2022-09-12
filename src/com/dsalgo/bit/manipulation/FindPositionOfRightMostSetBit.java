package com.dsalgo.bit.manipulation;

// https://www.geeksforgeeks.org/position-of-rightmost-set-bit/
public class FindPositionOfRightMostSetBit {
    public static void main(String[] args) {
        int n = 64;
        System.out.println(rightMostSetBit1(n));
        System.out.println(rightMostSetBit2(n));
    }

    private static int rightMostSetBit2(int n) {
        return (int) (Math.log10(n & ~(n-1)) / Math.log10(2)) + 1;
    }

    private static int rightMostSetBit1(int n) {
        int c = 0;
        while(n != 0) {
            if(n % 2 == 1){
                c++;
                break;
            }
            c++;
            n = n >> 1;
        }
        return c;
    }
}
