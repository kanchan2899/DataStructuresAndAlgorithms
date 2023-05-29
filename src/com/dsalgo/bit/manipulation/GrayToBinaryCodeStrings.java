package com.dsalgo.bit.manipulation;

// https://www.geeksforgeeks.org/gray-to-binary-and-binary-to-gray-conversion/
public class GrayToBinaryCodeStrings {
    public static void main(String[] args) {
        String gray = "01101";
        System.out.println(graytoBinary(gray));
    }

    /**
     * 2 steps algo:
     * 1. The MSB of the binary code is always equal to the MSB of the given gray code
     * 2. Other bits of the output binary code can be obtained by checking the gray code bit at that
     * index. If the current gray code bit is 0, then copy the previous binary code bit, else copy
     * the invert of the previous binary code bit.
     *
     *
     * TC: O(n)
     * SC: O(n)
     * @param gray
     * @return
     */
    private static String graytoBinary(String gray) {
        String  binary = "";
        binary += gray.charAt(0);

        for(int i = 1; i < gray.length(); i++) {
            if(gray.charAt(i) == '0') {
                binary += binary.charAt(i - 1);
            } else {
                binary += flip(binary.charAt(i - 1));
            }
        }

        return binary;
    }

    private static char flip(char a) {
        return (a == '0' ? '1' : '0');
    }
}
