package com.dsalgo.strings;

import java.util.HashMap;

// https://www.geeksforgeeks.org/return-maximum-occurring-character-in-the-input-string/
public class MaximumOccurringCharacter {
    public static void main(String[] args) {
        String s = "aabbc";
        System.out.println(getMaxOccurringChar(s));
    }

    /**
     * Using HashMap: Use the map to store the frequency of every character and while adding characters
     * to map, take a variable count to determine the element having the highest frequency.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param s
     * @return
     */
    private static char getMaxOccurringChar(String s) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        int n = s.length();
        char ans = 0;
        int count = 0;
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);

            if(count < countMap.get(c)) {
                ans = c;
                count = countMap.get(c);
            } else if(count == countMap.get(c) && ans > c) {
                ans = c;
            }
        }
        return ans;
    }
}
