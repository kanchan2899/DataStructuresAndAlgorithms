package com.dsalgo.recursion.strings;
/*
    i/p: "baccada" - skip/remove letter 'a' from the string and return the result string
    o/p: "bccd"
 */
public class SkipALetterInString {
    public static void main(String[] args) {
        String str = "baddacab";
        skipALetter(str, "");
        System.out.println(skipALetter1(str));
    }

    private static String skipALetter1(String str) {
        if(str.isEmpty()) {
            return "";
        }
        char ch = str.charAt(0);
        if(ch == 'a') {
            return skipALetter1(str.substring(1));
        } else {
            return ch + skipALetter1(str.substring(1));
        }
    }

    private static void skipALetter(String str, String ansStr) {
        if(str.isEmpty()) {
            System.out.println(ansStr);
            return;
        }
        char ch = str.charAt(0);
        if(ch == 'a') {
            skipALetter(str.substring(1), ansStr);
        } else {
            skipALetter(str.substring(1), ansStr + ch);
        }
    }


}
