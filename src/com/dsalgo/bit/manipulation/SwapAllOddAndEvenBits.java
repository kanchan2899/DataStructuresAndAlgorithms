package com.dsalgo.bit.manipulation;

public class SwapAllOddAndEvenBits {
    public static void main(String[] args) {
        int n = 23;
        System.out.println(swapBits(n));
    }

    /**
     * For 32 bit integers, create out variable with 0 value.
     * Start a loop from i = 0 to 30 and increment i by 2
     * If rightmost bit is 1 using (n & 1 == 1), out = out + pow(2, i + 1)
     * If second rightmost bit using (n >> 1 & 1 == 1), out = out + pow(2, i)
     * Right shift n by 2 everytime.
     * Return out.
     *
     * TC: O(1)
     * SC: O(1)
     * @param n
     * @return
     */
    public static int swapBits(int n) {
        int out = 0;
        for(int i = 0; i < 31; i+=2) {
            if((n & 1) == 1) {
                out += Math.pow(2, i + 1);
            }
            if((n >> 1 & 1) == 1) {
                out += Math.pow(2, i);
            }
            n = n >> 2;
        }
        return out;
    }
}
