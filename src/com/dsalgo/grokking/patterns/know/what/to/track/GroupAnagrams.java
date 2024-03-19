package com.dsalgo.grokking.patterns.know.what.to.track;

import java.util.*;

// https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] titles = {"duel", "dule", "speed", "spede", "deul", "cars"};
        System.out.println(groupAnagrams(titles));
    }

    private static List<List<String>> groupAnagrams(String[] titles) {
        if(titles.length == 0) {
            return new ArrayList<List<String>>();
        }

        Map<String, List<String>> map = new HashMap<>();

        // a place for every single alphabet in the string
        int[] count = new int[26];

        for(String s: titles) {
            Arrays.fill(count, 0);

            for(char ch: s.toCharArray()) {
                // calculate index
                int index = ch - 'a';
                count[index]++;
            }

            StringBuilder delimStr = new StringBuilder("");
            for(int i = 0; i < 26; i++) {
                delimStr.append('#');
                delimStr.append(count[i]);
            }

            String key = delimStr.toString();
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
