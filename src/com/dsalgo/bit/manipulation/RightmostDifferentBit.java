package com.dsalgo.bit.manipulation;

// https://practice.geeksforgeeks.org/problems/rightmost-different-bit-1587115621/1
public class RightmostDifferentBit {
    public static void main(String[] args) {
        int n = 11, m = 9;
        System.out.println(posOfRightMostDiffBit(m, n));
    }

    /**
     * Bruteforce: Start a while loop until either m or n is not equal to 0. Compare if rightmost of
     * each number is not equal. If so, return count. Otherwise, increment count and right shift each
     * number by 1.
     *
     * TC: O(max(log m, log n))
     * SC: O(1)
     *
     * @param m
     * @param n
     * @return
     */
    public static int posOfRightMostDiffBit(int m, int n) {
        if(m == n) {
            return -1;
        }
        int pos = 0;
        while(m != 0 || n != 0) {
            int x = m % 2;
            int y = n % 2;
            if(x != y) {
                return ++pos;
            }
            pos++;
            n = n >> 1;
            m = m >> 1;
        }
        return pos;
    }
}
