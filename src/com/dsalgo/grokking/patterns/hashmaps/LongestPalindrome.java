package com.dsalgo.grokking.patterns.hashmaps;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-palindrome/
public class LongestPalindrome {
    public static void main(String[] args) {
        String str = "abccccdd";
        System.out.println(longestPalindrome(str));
    }

    private static int longestPalindrome(String str) {
        int length = 0;
        // create a hashset
        Set<Character> set = new HashSet<>();

        // traverse every element through the loop
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // if hash set contains the character already, remove that character and add
            // it means that we get a pair of character which is a plaindrome
            if(set.contains(ch)) {
                length += 2;
                set.remove(ch);
            }
            // otherwise add the character to the set
            else {
                set.add(ch);
            }
        }
        // if the size of the set is greater than 0, move length forward
        if(set.size() > 0) {
            length++;
        }

        return length;
    }
}
