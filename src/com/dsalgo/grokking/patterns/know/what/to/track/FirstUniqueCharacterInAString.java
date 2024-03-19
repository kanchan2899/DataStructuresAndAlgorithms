package com.dsalgo.grokking.patterns.know.what.to.track;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/first-unique-character-in-a-string/description/
public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        String str = "somethingsomethinss";
        System.out.println(firstUniqueChar(str));
    }

    private static int firstUniqueChar(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(frequencyMap.get(ch) == 1) {
                return i;
            }
        }
        return -1;
    }
}
