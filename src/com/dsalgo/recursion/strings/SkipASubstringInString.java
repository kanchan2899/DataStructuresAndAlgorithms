package com.dsalgo.recursion.strings;
/*
    i/p: geeksforgeeks -> skip/remove "for"
    o/p: geeksgeeks
 */
public class SkipASubstringInString {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        String skippedStr = "for";
        System.out.println(skipASubstring(str, skippedStr));
    }

    private static String skipASubstring(String str, String skippedStr) {
        if(str.isEmpty())
            return "";
        if(str.startsWith("for")) {
            return skipASubstring(str.substring(skippedStr.length()), skippedStr);
        } else {
            return str.charAt(0) + skipASubstring(str.substring(1), skippedStr);
        }
    }
}
