package com.dsalgo.recursion.strings;

// https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/
public class FindKthBitInNthBinaryString {
    public static void main(String[] args) {
        int n = 4;
        int k = 11;
        System.out.println(findKthBit(n, k));
        System.out.println(findKthBit1(n, k));
    }

    private static char findKthBit1(int n, int k) {
        if(n == 1) {
            return '0';
        }
        int numberOfColumns = (int)(Math.pow(2, n) - 1);
        int mid = numberOfColumns / 2;

        if(k <= mid) {
            return findKthBit1(n - 1, k);
        } else if(k == mid - 1) {
            return '1';
        } else {
            k = numberOfColumns - k + 1;
            char c = findKthBit1(n - 1, k);
            return c == '0' ? '1' : '0';
        }
    }

    public static char findKthBit(int n, int k) {
        String s = helper(n, "0");
        System.out.println(s);
        return s.charAt(k-1);
    }

    static String helper(int n, String processed) {
        if(n <= 1) {
            return processed;
        }
        String inverted = invert(processed);
        processed = processed + "1" + reverse(inverted);
        return helper(n-1, processed);
    }

    private static String reverse(String str) {
        if(str.length() == 0) {
            return "";
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }


    private static String invert(String processed) {
        StringBuilder inverted = new StringBuilder(processed.length());
        for(int i = 0; i < processed.length(); i++) {
            if(processed.charAt(i) == '1') {
                inverted.insert(i, '0');
            } else {
                inverted.insert(i, '1');
            }
        }
        return inverted.toString();
    }


}
