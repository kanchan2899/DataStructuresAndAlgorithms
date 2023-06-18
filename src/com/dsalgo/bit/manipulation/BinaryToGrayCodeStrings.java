package com.dsalgo.bit.manipulation;

// https://www.geeksforgeeks.org/gray-to-binary-and-binary-to-gray-conversion/
public class BinaryToGrayCodeStrings {
    public static void main(String[] args) {
        String binary = "01001";
        System.out.println(binarytoGray(binary));
    }

    /**
     * 2 steps algo:
     * 1. The MSB of the gray code is always equal to the MSB of the given binary code
     * 2. Other bits of the output gray code can be obtained  by XORing binary code bit at that
     * index and previous index.
     *
     * TC: O(n)
     * SC: O(n)
     * @param binary
     * @return
     */
    private static String binarytoGray(String binary) {
        String gray = "";

        gray += binary.charAt(0);

        for(int i = 1; i < binary.length(); i++) {
            gray = gray + xor_c(binary.charAt(i - 1), binary.charAt(i));
        }

        return gray;
    }

    private static char xor_c(char a, char b) {
        return (a == b ? '0' : '1');
    }
}
