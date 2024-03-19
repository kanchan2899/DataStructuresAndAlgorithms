package com.dsalgo.grokking.patterns.know.what.to.track;


import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/description/
public class LongestPalindromeByConcatenating2LetterWords {
    public static void main(String[] args) {
        String[] words = {"ab", "bc", "cd", "dc", "aa", "dd"};
        System.out.println(longestPalindrome(words));
    }

    private static int longestPalindrome(String[] words) {
        // create a hash map to store word frequencies
        Map<String, Integer> frequencies = new HashMap<>();

        // count the frequencies of words
        for(String s: words) {
            frequencies.put(s, frequencies.getOrDefault(s, 0) + 1);
        }

        int count = 0;

        boolean central = false;

        for(Map.Entry<String, Integer> entry: frequencies.entrySet()) {
            String word = entry.getKey();
            int frequency = entry.getValue();

            // if word is a palindrome
            if(word.charAt(0) == word.charAt(1)) {
                // if a word has even occurrences
                if(frequency % 2 == 0) {
                    count += frequency;
                } else {
                    count += frequency - 1;
                    central = true;
                }
            }
            // if a word is not palindrome, ensure that a word and its reverse is only considered once
            else if(word.charAt(1) > word.charAt(0) &&
                    frequencies.containsKey(word.charAt(1) + "" + word.charAt(0))) {
                // get the minimum of the occurrences of the word and its reverse
                count += 2 * Math.min(frequency, frequencies.get(word.charAt(1) + "" + word.charAt(0)));
            }
        }

        if(central) {
            count += 1;
        }

        return 2 * count;
    }
}
