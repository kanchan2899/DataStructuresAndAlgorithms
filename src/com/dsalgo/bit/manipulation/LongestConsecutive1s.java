package com.dsalgo.bit.manipulation;

// https://practice.geeksforgeeks.org/problems/longest-consecutive-1s-1587115620/1
public class LongestConsecutive1s {
    public static void main(String[] args) {
        int n = 222;
        System.out.println(maxConsecutiveOnes(n));
    }
    public static int maxConsecutiveOnes(int n) {
        int max = 0, count = 0;
        for(int i = 0; i < 32; i++) {
            count = 0;
            if(n % 2 == 1) {
                while(n % 2 == 1) {
                    count++;
                    n >>= 1;
                }
            }
            n >>= 1;
            max = Math.max(max, count);
        }
        return max;
    }
}
