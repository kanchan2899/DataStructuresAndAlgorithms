package com.dsalgo.bit.manipulation;

// https://www.geeksforgeeks.org/gray-to-binary-and-binary-to-gray-conversion/
public class BinaryToGrayConverter {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(greyConverter(n));
    }

    /**
     * Using bitwise operator: Return XOR of n and (n right shifted by 1)
     *
     * TC: O(1)
     * SC: O(1)
     *
     * @param n
     * @return
     */
    private static int greyConverter(int n) {
        return n ^ (n >> 1);
    }
}
