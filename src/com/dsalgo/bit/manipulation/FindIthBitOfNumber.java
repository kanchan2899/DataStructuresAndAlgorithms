package com.dsalgo.bit.manipulation;

// Given a binary number, find ith bit of that number
// https://www.geeksforgeeks.org/find-value-k-th-bit-binary-representation/
public class FindIthBitOfNumber {
    public static void main(String[] args) {
        int a = 39;
        int i = 5;
        System.out.println("a = " + a);
        System.out.println(findIthBit1(a, i));
        System.out.println(findIthBit2(a, i));
        System.out.println(findIthBit3(a, i));
        System.out.println(findIthBit4(a, i));
        System.out.println(findIthBit5(a, i));
    }

    private static int findIthBit4(int a, int k) {

        for(int i = 0;  i < k - 1; i++) {
            a = a / 2;
        }

        if((a & 1) != 0) {
            return 1;
        }
        return 0;
    }

    private static int findIthBit3(int a, int k) {
        int x = 1;
        for(int i = 0; i < k - 1; i++) {
            x = x * 2;
        }
        if((a & x) != 0) {
            return 1;
        }
        return 0;
    }

    /**
     * If we right shift n by k-1, we get the last bit as 1 if the Kth bit is set else 0
     *
     * TC:O(1)
     *
     * @param a
     * @param i
     * @return
     */
    private static int findIthBit2(int a, int i) {
        return ((a >> (i - 1)) % 2);
    }

    /**
     * Left shift given number 1 by k-1 to create a number that has only set bit as k-th bit.
     * temp = 1 << (k-1)
     * If bitwise AND of n and temp is non-zero, then result is SET else result is NOT SET.
     *
     * TC: O(1)
     * @param a
     * @param i
     * @return
     */
    private static int findIthBit5(int a, int i) {
        int x = 1 << (i - 1);
        return (a & x) != 0 ? 1 : 0;
    }

    private static int findIthBit1(int a, int i) {
        return (a & (1 << (i - 1))) >> (i - 1);
    }
}
