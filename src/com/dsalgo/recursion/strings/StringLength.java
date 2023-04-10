package com.dsalgo.recursion.strings;

// https://www.geeksforgeeks.org/program-for-length-of-a-string-using-recursion/
public class StringLength {
    public static void main(String[] args) {
        String str = "abcdef";
        System.out.println(printLength(str));
        System.out.println(printLength1(str, 0));
        System.out.println(printLength2(str));
    }

    private static int printLength2(String str) {
        if(str.isEmpty()) {
            int count = 0;
            return count;
        }
        int count = 0;
        count++;
        count = count + printLength2(str.substring(1));
        return count;
    }

    private static int printLength1(String str, int len) {
        if(str.isEmpty()) {
            return len;
        }
        return printLength1(str.substring(1), len + 1);
    }

    private static int printLength(String str) {
        if(str.equals(""))
            return 0;
        return 1 + printLength(str.substring(1));
    }
}
