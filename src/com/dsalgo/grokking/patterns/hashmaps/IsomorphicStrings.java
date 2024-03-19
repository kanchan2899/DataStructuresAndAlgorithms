package com.dsalgo.grokking.patterns.hashmaps;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/isomorphic-strings/
public class IsomorphicStrings {
    public static void main(String[] args) {
        String string1 = "paper";
        String string2 = "total";
        System.out.println(isIsomorphic(string1, string2));
    }

    private static boolean isIsomorphic(String string1, String string2) {
        Map<Character, Character> mapStr1Str2 = new HashMap<>();
        Map<Character, Character> mapStr2Str1 = new HashMap<>();

        int i = 0, j = 0;

        while (i < string1.length()) {
            char ch1 = string1.charAt(i++);
            char ch2 = string2.charAt(j++);

            // return false if char1 in string1 exist in hashmap and char1 has different mapping
            // in hashmap
            if(mapStr1Str2.containsKey(ch1) && mapStr1Str2.get(ch1) != ch2) {
                return false;
            }

            // return false if char2 in string2 exists in hashmap and char2 has different mapping
            // in hashmap
            if(mapStr2Str1.containsKey(ch2) && mapStr2Str1.get(ch2) != ch1) {
                return false;
            }

            // mapping of char of one string to another and vice versa
            mapStr1Str2.put(ch1, ch2);
            mapStr2Str1.put(ch2, ch1);
        }
        return true;
    }
}
