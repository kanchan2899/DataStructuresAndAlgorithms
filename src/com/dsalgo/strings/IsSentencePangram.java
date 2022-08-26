package com.dsalgo.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/check-if-the-sentence-is-pangram/
public class IsSentencePangram {
    public static void main(String[] args) {
        String[] sentences = {"thequickbrownfoxjumpsoverthelazydog", "leetcode"};
        for(String sentence: sentences) {
            System.out.println(checkIfPangram1(sentence));
            System.out.println(checkIfPangram2(sentence));
            System.out.println(checkIfPangram3(sentence));
        }
    }

    private static boolean checkIfPangram3(String sentence) {
        // Solution 3 - O(n) TC
        // Store the count of each character in an integer array of length 26.
        // Increment the count of the character that exists in the sentence.
        // Check the integer array if it contains 0, If so, sentence is not pangram
        int[] charCount = new int[26];
        for(char s: sentence.toCharArray()){
            charCount[s - 'a']++;
        }
        for(int i : charCount){
            if(i == 0)
                return false;
        }
        return true;
    }


    private static boolean checkIfPangram2(String sentence) {
        // Solution 2 - O(n) TC
        // Using Set - Add all characters from sentence in a set and check if characters are 26
        Set<Character> characterSet = new HashSet<>();
        char[] a = sentence.toCharArray();
        for(char s: a){
            characterSet.add(Character.valueOf(s));
        }
        if(characterSet.size() == 26){
            return true;
        }
        return false;
    }

    public static boolean checkIfPangram1(String sentence) {
        // Solution 1 - O(n) TC
        // Using Map - Create a map with 26 alphabets as keys and values as 0.
        // Traverse the sentence and increment the key's value if an alphabet exists in the sentence.
        // Then check if the map contains value 0. If so, sentence is not pangram
        Map<String, Integer> charMap = new HashMap<>();
        for(char ch = 'a'; ch <= 'z'; ch++){
            charMap.put(String.valueOf(ch), 0);
        }
        char[] chars = sentence.toCharArray();
        for(int i = 0; i < chars.length; i++){
            char charKey = Character.toLowerCase(chars[i]);
            String key = Character.toString(charKey);
            charMap.put(key, charMap.get(key)+1);
        }
        if(charMap.containsValue(0)){
            return false;
        }
        return true;
    }
}
