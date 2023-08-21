package com.dsalgo.strings;

import java.util.HashMap;

// https://www.geeksforgeeks.org/find-character-first-string-present-minimum-index-second-string/
public class MinimumIndexedCharacter {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        String pattern = "set";
        System.out.println(printMinIndexChar(str, pattern));
        System.out.println(printMinIndexChar1(str, pattern));
    }

    /**
     * Using hashing:
     *
     * 1. Create a hash table with (key, value) tuple represented as (character, index) tuple.
     * 2. Store the first index of each character of str in the hash table.
     * 3. Now, for each character of patt check if it is present in the hash table or not.
     * 4. If present then get its index from the hash table and update minIndex(minimum index
     * encountered so far).
     * 5. For no matching character print “No character present”.
     *
     * TC: O(m + n)
     * SC: O(m), str length
     *
     * @param str
     * @param pattern
     * @return
     */
    private static int printMinIndexChar1(String str, String pattern) {
        HashMap<Character, Integer> map = new HashMap<>();

        int minIndex = Integer.MAX_VALUE;

        for(int i = 0; i < str.length(); i++) {
            if(!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), i);
            }
        }

        for(int i = 0; i < pattern.length(); i++) {
            if(map.containsKey(pattern.charAt(i)) && map.get(pattern.charAt(i)) < minIndex)
                minIndex = map.get(pattern.charAt(i));
        }

        return (minIndex == Integer.MAX_VALUE) ? -1 : minIndex;
    }

    /**
     * Bruteforce: Using two loops, find the first index of each character of patt in str.
     * Print the character having the minimum index. If no character of patt is present in str
     * then print “No character present”.
     *
     * TC: O(n ^ 2)
     * SC: O(1)
     *
     * @param str
     * @param pattern
     * @return
     */
    private static int printMinIndexChar(String str, String pattern) {
        int minIndex = Integer.MAX_VALUE;

        int m = str.length();
        int n = pattern.length();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(pattern.charAt(i)  == str.charAt(j) && j < minIndex) {
                    minIndex = j;
                    break;
                }
            }
        }
        return (minIndex == Integer.MAX_VALUE) ? -1 : minIndex;
    }
}
