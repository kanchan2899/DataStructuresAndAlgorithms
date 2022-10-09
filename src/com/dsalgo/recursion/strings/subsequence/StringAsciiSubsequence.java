package com.dsalgo.recursion.strings.subsequence;

public class StringAsciiSubsequence {
    public static void main(String[] args) {
        String str = "abc";
        subsequenceAscii(str, "");
    }

    private static void subsequenceAscii(String str, String subsequence) {
        if(str.isEmpty()) {
            System.out.println(subsequence);
            return;
        }
        char ch = str.charAt(0);
        subsequenceAscii(str.substring(1), subsequence);
        subsequenceAscii(str.substring(1), subsequence + ch);
        subsequenceAscii(str.substring(1), subsequence + (ch + 0));
    }
}
