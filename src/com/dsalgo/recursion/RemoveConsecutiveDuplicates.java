package com.dsalgo.recursion;

import java.util.Arrays;

// https://www.geeksforgeeks.org/remove-consecutive-duplicates-string/
public class RemoveConsecutiveDuplicates {
    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        System.out.println(removeConsecutiveDuplicates(s1));
        System.out.println(removeConsecutiveDuplicates1(s1));
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
}
