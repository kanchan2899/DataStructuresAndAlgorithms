package com.dsalgo.grokking.patterns.know.what.to.track;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/ransom-note/
public class RansomNote {
    public static void main(String[] args) {
        String ransom = "codinginterviewquestions";
        String magazine = "aboincsdefoetingvqtniewonoregessnutins";
        System.out.println(canConstruct(ransom, magazine));

    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> frequencyMap = new HashMap<>();

        for(char ch : magazine.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        for(char ch : ransomNote.toCharArray()) {
            if(!frequencyMap.containsKey(ch) || frequencyMap.get(ch) == 0) {
                return false;
            } else {
                frequencyMap.put(ch, frequencyMap.get(ch) - 1);
            }
        }
        return true;
    }
}
