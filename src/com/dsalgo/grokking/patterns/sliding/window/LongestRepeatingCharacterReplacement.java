package com.dsalgo.grokking.patterns.sliding.window;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-repeating-character-replacement/
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String str = "abbaccbbdde";
        int k = 3;
        System.out.println(longestRepeatingCharacterReplacement(str, k));
    }

    private static int longestRepeatingCharacterReplacement(String str, int k) {
        int len = str.length();
        int lengthOfMaxSubstring = 0;
        int start = 0;

        Map<Character, Integer> charFreq = new HashMap<>();
        int mostFreqChar = 0;

        // iterate over the input string
        for(int end = 0; end < len; end++) {
            char currentChar = str.charAt(end);

            // if the new character is not in the hash map, add it, else increment its frequency
            charFreq.put(currentChar, charFreq.getOrDefault(currentChar, 0) + 1);

            // update the most frequency char
            mostFreqChar = Math.max(mostFreqChar, charFreq.get(currentChar));

            // if the number of replacements in the current window have exceeded the limit, slide the
            // window
            if(end - start + 1 - mostFreqChar > k) {
                charFreq.put(str.charAt(start), charFreq.get(str.charAt(start)) - 1);
                start += 1;
            }

            // if the window is the longest so far, update the length of max substring
            lengthOfMaxSubstring = Math.max(lengthOfMaxSubstring, end - start + 1);
        }
        return lengthOfMaxSubstring;
    }
}
