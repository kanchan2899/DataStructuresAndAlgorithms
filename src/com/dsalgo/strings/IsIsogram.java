package com.dsalgo.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

// https://www.geeksforgeeks.org/check-string-isogram-not/
public class IsIsogram {
    public static void main(String[] args) {
        String s = "redblu";
        System.out.println(isIsogram(s));
        System.out.println(isIsogram1(s));
    }

    /**
     * Using HashMap: In this, the count of characters of the string is stored in the hashmap,
     * and wherever it is found to be greater than 1 for any char, return false else return true
     * at the end
     *
     * 1. Declare a hashmap to store the count of the characters of the string
     * 2. Traverse the string
     *  a. Increase the count of the current character in the hashmap
     *  b. If the count of the current character is greater than one then return false
     * 3. Return true
     * @param s
     * @return
     */
    private static boolean isIsogram1(String s) {
        if(s.length() > 26) {
            return false;
        }
        HashMap<Character, Integer> countMap = new HashMap<>(26);

        for(int i = 0; i < s.length(); i++) {
            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
            if(countMap.containsKey(s.charAt(i)) && countMap.get(s.charAt(i)) > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Using sorting: Sort the string and for every character check, if the current character
     * is equal to the previous character or not. If it is equal then the string is not an isogram.
     *
     * 1. Convert the string into lowercase English letters
     * 2. Sort the string
     * 3. Traverse the string and check for every character
     *  a. If the current character is equal to the character on the previous index then return false
     * 4. Return true
     *
     * TC: O(n * log n)
     * SC: O(1)
     *
     * @param s
     * @return
     */
    private static boolean isIsogram(String s) {
        s = s.toLowerCase();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
