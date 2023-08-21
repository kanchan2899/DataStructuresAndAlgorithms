package com.dsalgo.strings;

import java.util.Arrays;
import java.util.HashMap;

// https://www.geeksforgeeks.org/check-if-two-given-strings-are-isomorphic-to-each-other/
public class IsomorphicStrings {
    public static void main(String[] args) {
        String s1 = "aab";
        String s2 = "xxy";

        System.out.println(isIsomorphic(s1, s2));
        System.out.println(isIsomorphic1(s1, s2));
    }

    /**
     * Using HashMap: The idea is to store map the character and check whether the mapping is correct or not
     *
     * 1. Create a hashmap of (char, char) to store the mapping of s1 and s2
     * 2. Traverse on the string and check whether the current character is present in the hashmap
     *  a. If it is present, the character that is mapped is there at the ith index or not
     *  b. Else check if s2[i] is not present in the key, then add the new mappings.
     *  c. Else return false
     *
     *  TC: O(n)
     *  SC: O(n)
     *
     * @param s1
     * @param s2
     * @return
     */
    private static boolean isIsomorphic1(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        HashMap<Character, Character> charCount = new HashMap<>();

        char c;
        for(int i = 0; i < s1.length(); i++) {
            if(charCount.containsKey(s1.charAt(i))) {
                c = charCount.get(s1.charAt(i));
                if(c != s2.charAt(i)) {
                    return false;
                }
            } else if (!charCount.containsValue(s2.charAt(i))){
                charCount.put(s1.charAt(i), s2.charAt(i));
            } else  {
                return false;
            }
        }
        return true;
    }

    /**
     * Bruteforce: The idea is to create an array to store mappings of processed characters.
     *
     * 1. If the lengths of s1 and s2 are not same, return false.
     * 2. Do the following for every character in s1 and s2
     *  a. If this character is seen first time in s1, then current of s2 must have not appeared before
     *      - If the current character of s2 is seen, return false. Mark the current character of s2
     *      as visited.
     *      - Store mapping of current characters.
     *  b. Else check if the previous occurrence of s1[i] mapped to the same character.
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param s1
     * @param s2
     * @return
     */
    private static boolean isIsomorphic(String s1, String s2) {
        int size = 256;
        int m = s1.length();
        int n = s2.length();

        if(m != n) {
            return false;
        }

        Boolean[] marked = new Boolean[size];
        Arrays.fill(marked, Boolean.FALSE);

        // to store mapping of every character from s1 to that of s2, initialize all entries of map as -1
        int[] map = new int[size];
        Arrays.fill(map, -1);

        // process all characters one by one
        for(int i = 0; i < n; i++) {
            // if current character of s1 is seen first time in it.
            if(map[s1.charAt(i)] == -1) {
                // if current character of s2 is already seen, one to one mapping not possible
                if(marked[s2.charAt(i)] == true) {
                    return false;
                }
                // mark current character of s2 as visited
                marked[s2.charAt(i)] = true;

                // store mapping of current characters
                map[s1.charAt(i)] = s2.charAt(i);
            } else if(map[s1.charAt(i)] != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
