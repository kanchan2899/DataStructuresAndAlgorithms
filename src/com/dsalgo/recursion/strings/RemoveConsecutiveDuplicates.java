package com.dsalgo.recursion.strings;

import java.util.Arrays;

// https://www.geeksforgeeks.org/remove-consecutive-duplicates-string/
public class RemoveConsecutiveDuplicates {
    public static void main(String[] args) {
        String[] str = {"geeksforgeeks", "aaaaabbbbb"};
        for(String s: str){
            System.out.println(removeConsecutiveDuplicates(s));
            System.out.println(removeConsecutiveDuplicates1(s));
            System.out.println(removeConsecutiveDuplicates2(s));
        }
    }

    private static String removeConsecutiveDuplicates1(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        if(n < 2)
            return null;
        int j = 0;
        for(int i = 1; i < n; i++){
            if(chars[j] != chars[i]){
                j++;
                chars[j] = chars[i];
            }
        }
        return String.valueOf(Arrays.copyOfRange(chars, 0, j + 1));
    }

    private static String removeConsecutiveDuplicates(String s) {
        if(s.length() <= 1)
            return s;
        if(s.charAt(0) == s.charAt(1))
            return removeConsecutiveDuplicates(s.substring(1));
        else
            return s.charAt(0) + removeConsecutiveDuplicates(s.substring(1));
    }

    private static String removeConsecutiveDuplicates2(String s) {
        if(s.isEmpty()) {
            return s;
        }
        return helper(s, 0);
    }

    private static String helper(String s, int index) {
        if(index >= s.length() - 1){
            return s;
        }
        if(s.charAt(index) == s.charAt(index + 1)) {
            return helper(s.substring(0, index) + s.substring(index + 1), index);
        } else
            return helper(s, index + 1);
    }
}
