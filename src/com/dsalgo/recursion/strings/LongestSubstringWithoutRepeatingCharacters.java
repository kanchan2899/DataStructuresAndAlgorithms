package com.dsalgo.recursion.strings;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring1(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() < 1) {
            return 0;
        }
        int max_length = 0;
        Set<Character> set = new HashSet<>();
        int j = 0, i = 0;
        while(i < s.length()) {
            if(!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                i++;
                max_length = Math.max(max_length, set.size());
            } else {
                set.remove(s.charAt(j));
                j++;
            }
        }
        return max_length;
    }

    public static int lengthOfLongestSubstring1(String s) {
        if(s == null || s.length() < 1) {
            return 0;
        }
        int max_length = 0;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                if(!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                } else {
                    break;
                }
            }
            max_length = Math.max(max_length, set.size());
            set.remove(s.charAt(i));
        }
        return max_length;
    }
}
