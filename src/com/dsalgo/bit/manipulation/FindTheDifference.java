package com.dsalgo.bit.manipulation;

import java.util.HashMap;
import java.util.Map;

public class FindTheDifference {

    public static void main(String[] args) {
        String s = "a";
        String t = "aa";
        System.out.println(findTheDifference(s, t));
        System.out.println(findTheDifference1(s, t));
    }

    private static char findTheDifference1(String s, String t) {
        char c = 0;
        for(char sChar: s.toCharArray())
            c = (char) (c ^ sChar);
        for(char tChar: t.toCharArray())
            c = (char) (c ^ tChar);
        return c;
    }

    public static char findTheDifference(String s, String t) {
        char a = '\0';
        Map<Character, Integer> countMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int j = 0; j < t.length(); j++){
            if(countMap.get(t.charAt(j)) == null) {
                a = t.charAt(j);
            }
        }
        return a;
    }
}
