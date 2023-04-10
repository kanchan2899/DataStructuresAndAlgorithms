package com.dsalgo.recursion.strings;

/*
    I/P: abcdefg, k = 2
    O/P: badcfeg
 */
public class ReverseStringInKGroups {
    public static void main(String[] args) {
        String str = "abcdef";
        int k = 3;

        System.out.println(reverseString(str, k));
    }

    private static String reverseString(String str, int k) {
        // Case 1: When the string is less than k, reverse everything
        if(str.length() < k) {
            return str;
        } else if (str.length() <= 2 * k) {
            return reverse(str, 0, 0 + k - 1) + str.substring(k);
        } else {
            return reverse(str, 0, 0 + k - 1) + str.substring(k, 2 * k) + reverseString(str.substring(2 * k), k);
        }
    }

    private static String reverse(String s, int start, int end) {
        if(start > end) {
            return "";
        }
        return s.charAt(end) + reverse(s, start, end - 1);
    }
}
