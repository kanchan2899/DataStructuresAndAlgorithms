package com.dsalgo.recursion.strings;

public class ReverseString {
    public static void main(String[] args) {
        String[] str = {"abc", "", "abcba", "red", "blue"};
        for(String s : str) {
            System.out.println(reverseString(s));
        }
    }

    private static String reverseString(String s) {
        if(s.length() == 0)
            return "";
        return reverseString(s.substring(1)) + s.charAt(0);
    }
}
