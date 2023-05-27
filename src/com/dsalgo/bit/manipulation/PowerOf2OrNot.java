package com.dsalgo.bit.manipulation;

// https://www.geeksforgeeks.org/program-to-find-whether-a-given-number-is-power-of-2/
public class PowerOf2OrNot {
    public static void main(String[] args) {
        int n = 31;
        System.out.println(isPowerOf2(n));
        System.out.println(isPowerOf2_1(n));
    }

    /**
     * Bruteforce: Start a while loop until n != 1. If n mod 2 is not equal to 0, return false
     * Keep dividing n by 2 in the while loop. At the end, if it is a power of 2, return true.
     *
     * TC: O(log n)
     * SC: O(1)
     *
     * @param n
     * @return
     */
    private static boolean isPowerOf2_1(int n) {
        if(n == 0)
            return false;
        while (n != 1) {
            if(n % 2 != 0) {
                return false;
            }
            n = n / 2;
        }
        return true;
    }

    /**
     * Using Brian Kernighan's algo: As we know that the number which will be the power of 2,
     * have only one set bit. Therefore, when we do bitwise AND with the number which is just
     * less than the number, then the result will be 0.
     *
     * TC: O(1)
     * SC: O(1)
     * @param n
     * @return
     */
    private static boolean isPowerOf2(int n) {
        if(n == 0)
            return false;
        if((n & (n - 1)) == 0){
            return true;
        }
        return false;
    }
}
