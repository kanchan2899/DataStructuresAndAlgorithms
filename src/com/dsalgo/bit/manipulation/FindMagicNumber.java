package com.dsalgo.bit.manipulation;

// https://www.geeksforgeeks.org/find-nth-magic-number/

public class FindMagicNumber {
    public static void main(String[] args) {
        int n = 10001;
        System.out.println(magicNum(n));
    }

    private static int magicNum(int n) {
        int base  = 5;
        int ans = 0;

        while(n > 0){
            int currentBit = n & 1;
            if(currentBit != 0) {
                ans += currentBit * base;
            }
            base = base * 5;
            n = n >> 1;
        }
        return ans;
    }
}
