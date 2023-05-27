package com.dsalgo.bit.manipulation;

// https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-BitMagic/problem/find-first-set-bit-1587115620
public class FirstSetBit {
    public static void main(String[] args) {
        int n = 1;
        System.out.println(getFirstSetBit(n));
    }

    public static int getFirstSetBit(int n){
        int t = n;
        int i = 0;
        while (t != 0) {
            if((t & 1) == 1) {
                i++;
                break;
            }
            i++;
            t >>= 1;
        }
        return i;
    }
}
