package com.dsalgo.bit.manipulation;

// https://www.geeksforgeeks.org/gray-to-binary-and-binary-to-gray-conversion/
public class GrayToBinaryConverter {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(binaryConverter(n));
    }

    /**
     * Using bitwise operator: Initialize result variable with n
     * Start a loop until n > 0, right shift n by 1, then do XOR between result and n. Return result
     *
     * TC: O(log n)
     * SC: O(1)
     *
     * @param n
     * @return
     */
    private static int binaryConverter(int n) {
        int res = n;
        while (n > 0) {
            n >>= 1;
            res ^= n;
        }
        return res;
    }
}
