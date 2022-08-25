package com.dsalgo.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// https://leetcode.com/problems/first-unique-character-in-a-string/
public class FirstUniqueCharacterinString {
    public static void main(String[] args) {
        String[] s = {"leetcode", "loveleetcode", "aabb"};
        for(String str: s){
            System.out.println(firstUniqChar1(str));
            System.out.println(firstUniqChar2(str));
        }
    }

    private static int firstUniqChar2(String str) {
        int index = -1;
        char[] chars = str.toCharArray();
        Map<Character, Integer> countMap = new LinkedHashMap<>();
        for(Character c : chars){
            countMap.put(c, countMap.get(c) == null ? 1 : countMap.get(c) + 1);
            System.out.println(countMap);
        }
        for(var entry : countMap.entrySet()){
            if(entry.getValue() == 1){
                index = str.indexOf(entry.getKey());
                break;
            }
        }
        return index;
    }

    public static int firstUniqChar1(String s) {
        Map<Character, Integer> count = new HashMap<>();
        int index = -1;
        for(int i = 0; i < s.length(); i++){
            if(count.containsKey(s.charAt(i))){
                count.put(s.charAt(i), count.get(s.charAt(i)) + 1);
            }
            else {
                count.put(s.charAt(i), 1);
            }
        }
        for(int i = 0; i < s.length(); i++){
            if(count.get(s.charAt(i)) == 1){
                index = i;
                break;
            }
        }
    return index;
    }
}
