package com.dsalgo.grokking.patterns.sliding.window;

import java.util.Hashtable;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "abcdeefghihkl";
        System.out.println(findLongestSubstring(str));
    }

    private static int findLongestSubstring(String str) {
        if(str.length() == 0) {
            return 0;
        }
        int n = str.length();
        int windowStart = 0, longest = 0, windowLength = 0, i = 0;

        Hashtable<Character, Integer> lastSeenAt = new Hashtable<>();

        // Traverse input str to find the longest substring without repeating characters
        for(i = 0; i < n; i++) {
            // if the current element is not present in the hash map, then store it in the
            // hash map with the current index as the value.
            if(!lastSeenAt.containsKey(str.charAt(i))) {
                lastSeenAt.put(str.charAt(i), i);
            } else {
                // If the current element is present in the hash map, it means that this element
                // may have appeared before. Check if the current element occurs before or after windowStart
                if(lastSeenAt.get(str.charAt(i)) >= windowStart) {
                    windowLength = i - windowStart;
                    if(longest < windowLength) {
                        longest = windowLength;
                    }
                    windowStart = lastSeenAt.get(str.charAt(i)) + 1;
                }
                // update the last occurrence of the element in the hash table
                lastSeenAt.replace(str.charAt(i), i);
            }
        }

        // update the longest substring's length and starting index
        if(longest < i - windowStart) {
            longest = i - windowStart;
        }
        return longest;
    }
}
