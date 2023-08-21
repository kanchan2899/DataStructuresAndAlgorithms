package com.dsalgo.strings;

// https://practice.geeksforgeeks.org/problems/binary-string-1587115620/1
public class BinaryString {
    public static void main(String[] args) {
        String str = "001001010101";
        System.out.println(binarySubstring(str));
    }

    /**
     * Using quadratic formula: First count the number of ones. Then, return (ones * (ones - 1) / 2)
     *
     * # 1's -> # substrings
     *  1   ->  0
     *  2   ->  1
     *  3   ->  3
     *  4   ->  6
     *  5   ->  10
     *
     *  TC: O(n)
     *  SC: O(1)
     *
     * @param str
     * @return
     */
    private static int binarySubstring(String str) {
        int onesCount = 0;

        for(char c : str.toCharArray()) {
            if(c == '1') {
                onesCount++;
            }
        }
        return (onesCount * (onesCount - 1)) / 2;
    }
}
