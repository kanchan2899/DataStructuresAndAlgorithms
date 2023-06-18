package com.dsalgo.bit.manipulation;

public class PowerSet {

    public static void main(String[] args) {
        String s = "abc";
        powerSet(s);
    }

    /**
     * Input: Set[], set_size
     * 1. Get the size of power set
     *       powet_set_size = pow(2, set_size)
     * 2  Loop for counter from 0 to pow_set_size
     *     (a) Loop for i = 0 to set_size
     *          (i) If ith bit in counter is set
     *                 Print ith element from set for this subset
     *    (b) Print separator for subsets i.e., newline
     *
     *
     *  TC: O(2^n * n)
     *  SC: O(1)
     *
     * @param s
     */
    static void powerSet(String s) {
        int n = s.length();
        int powerSetSize = 1 << n;

        for(int i = 0; i < powerSetSize; i++) {
            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) != 0) {
                    System.out.print(s.charAt(j));
                }
            }
            System.out.println();
        }
    }
}
