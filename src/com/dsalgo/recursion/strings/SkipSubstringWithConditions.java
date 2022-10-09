package com.dsalgo.recursion.strings;

/*
    i/p: geekforgeeks -> skip "geek" if it is not "geeks"
    o/p: forgeeks
 */
public class SkipSubstringWithConditions {
    public static void main(String[] args) {
        String str = "geekforgeeks";
        String skippedStr = "geek";
        String requiredStr = "geeks";
        System.out.println(skipSubstringButNotRequiredStr(str, skippedStr, requiredStr));
    }


    private static String skipSubstringButNotRequiredStr(String str, String skippedStr, String requiredStr) {
        if(str.isEmpty()) {
            return "";
        }
        if(str.startsWith(skippedStr) && !str.startsWith(requiredStr)) {
            return skipSubstringButNotRequiredStr(str.substring(skippedStr.length()), skippedStr, requiredStr);
        } else {
            return str.charAt(0) + skipSubstringButNotRequiredStr(str.substring(1), skippedStr, requiredStr);
        }
    }
}
