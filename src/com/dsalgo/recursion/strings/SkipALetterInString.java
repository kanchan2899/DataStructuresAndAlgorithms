package com.dsalgo.recursion.strings;
/*
    i/p: "baccada" - skip/remove letter 'a' from the string and return the result string
    o/p: "bccd"
 */
public class SkipALetterInString {
    public static void main(String[] args) {
        String str = "baddacab";
        skipALetter1(str, "");
        System.out.println(skipALetter3(str, ""));
        System.out.println(skipALetter2(str));
    }

    private static String skipALetter3(String str, String ans) {
        if(str.isEmpty()) {
            return ans;
        }
        char ch = str.charAt(0);
        if(ch == 'a') {
            return skipALetter3(str.substring(1), ans);
        } else {
            return skipALetter3(str.substring(1), ans + ch);
        }
    }

    private static String skipALetter2(String str) {
        if(str.isEmpty()) {
            return "";
        }
        char ch = str.charAt(0);
        if(ch == 'a') {
            return skipALetter2(str.substring(1));
        } else {
            return ch + skipALetter2(str.substring(1));
        }
    }

    private static void skipALetter1(String str, String ansStr) {
        if(str.isEmpty()) {
            System.out.println(ansStr);
            return;
        }
        char ch = str.charAt(0);
        if(ch == 'a') {
            skipALetter1(str.substring(1), ansStr);
        } else {
            skipALetter1(str.substring(1), ansStr + ch);
        }
    }


}
