package com.dsalgo.bit.manipulation;

// https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-BitMagic/problem/count-total-set-bits-1587115620
public class CountSetBits {
    static int[] bitSetTable = new int[256];
    public static void main(String[] args) {

        int n = 94;
        System.out.println("Number of set bits in " + n + " is " + countSetBits1(n) + " using bruteforce method");
        System.out.println("Number of set bits in " + n + " is " + countSetBits2(n) + " using Brian Kernighan's method");
        System.out.println("Number of set bits in " + n + " is " + countSetBits3(n) + " using lookup table method");
    }

    /**
     * Using lookup table: The idea is to set count bits for all numbers in 8 bits in O(1) tim with
     * some preprocessing involved.
     *
     * Assumption: 32-bit integer
     *
     * Precompute the number of set bits for 8 bits in the table. Then count set bits in a given
     * number n by adding the number of set bits in four 8 bit groups.
     *
     * eg: n = 13: 00000000 000000000 00000000 00001101
     * Right shift by 8/16/24 bits to get the 1st to 3rd 8-bits group.
     * 0xff means 11111111 will get you 8-bits group
     * Assuming
     * @param n
     * @return
     */
    private static int countSetBits3(int n) {
        bitSetTable[0] = 0;
        for(int i = 0; i < bitSetTable.length; i++) {
            bitSetTable[i] = (i & 1) + bitSetTable[i / 2];
        }
        return (bitSetTable[n & 0xff] +
                bitSetTable[(n >> 8) & 0xff] +
                bitSetTable[(n >> 16) & 0xff] +
                bitSetTable[(n >> 24)]);
    }

    /**
     * Brian Kernighan's Method: Loop through the number of set bits only.
     *
     *  1. Initialize count: = 0
     *  2. If integer n is not zero
     *       (a) Do bitwise & with (n-1) and assign the value back to n
     *           n: = n&(n-1)
     *       (b) Increment count by 1
     *       (c) go to step 2
     *   3. Else return count
     *
     *   TC: O(# set bits)
     *   SC: O(1)
     *
     * @param n
     * @return
     */
    private static int countSetBits2(int n) {
        int count = 0;
        while(n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    /**
     * Bruteforce method: Traverse all bits in the number and check if it is set.
     * If it is, increment count. Return count
     *
     * TC: O(# bits in n) or O(log n)
     * SC: O(1)
     *
     * @param n
     * @return
     */
    public static int countSetBits1(int n){
        int count = 0;
        while(n != 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

}
