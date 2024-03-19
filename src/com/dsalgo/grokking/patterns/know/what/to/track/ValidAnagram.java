package com.dsalgo.grokking.patterns.know.what.to.track;

import java.util.HashMap;

// https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaran";
        System.out.println(isAnagram(s, t));
    }

    private static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        // iterate over s to store the count of characters
        for(char ch: s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // iterate over t and update the count of each character
        for(char ch: t.toCharArray()) {
            if(frequencyMap.containsKey(ch)) {
                frequencyMap.put(ch, frequencyMap.get(ch) - 1);
            } else {
                // if the character is not already present in the hashmap, return false
                // because it is an extra character in t
                return false;
            }
        }

        // iterate over the count of each character and check if it is zero
        for(int count: frequencyMap.values()) {
            // if the count of any character is not zero, the strings are not anagrams
            if(count != 0) {
                return false;
            }
        }

        // if the code reaches this point, the strings are anagrams
        return true;
    }
}
