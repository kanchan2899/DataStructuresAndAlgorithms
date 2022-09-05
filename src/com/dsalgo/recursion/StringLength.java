package com.dsalgo.recursion;

// https://www.geeksforgeeks.org/program-for-length-of-a-string-using-recursion/
public class StringLength {
    public static void main(String[] args) {
        String str = "abcdef";
        System.out.println(printLength(str));
    }

    private static int printLength(String str) {
        if(str.equals(""))
            return 0;
        return 1 + printLength(str.substring(1));
    }
}
