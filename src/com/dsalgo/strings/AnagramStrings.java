package com.dsalgo.strings;

import java.util.Arrays;


// https://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/
public class AnagramStrings {
    static final int CHAR = 256;
    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";
        System.out.println(isAnagram(s1, s2));
        System.out.println(isAnagram1(s1, s2));
        System.out.println(isAnagram2(s1, s2));
    }

    /**
     * Using count characters: This method assumes that the set of possible characters in both strings
     * is small.
     *
     * 1. Create count arrays of size 256 for both strings. Initialize all values in count arrays as 0.
     * 2. Iterate through every character of both strings and increment the count of character
     * in the corresponding count arrays.
     * 3. Compare count arrays. If both count arrays are same, then return true.
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param s1
     * @param s2
     * @return
     */
    private static boolean isAnagram2(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        int[] count1 = new int[CHAR];
        int[] count2 = new int[CHAR];
        int i;

        for(i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i)]++;
            count2[s2.charAt(i)]++;
        }

        for(i = 0; i < CHAR; i++) {
            if(count1[i] != count1[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Using frequency counting: This involves counting of characters in the string. We assume that
     * the set of possible characters in  both strings is small and the characters are stored using 8
     * bit and there can be 256 possible unique characters.
     *
     * 1. Create an array fo size 256 to maintain the frequency of characters for both strings.
     * 2. Iterate through every character of both strings and increment the count of characters in
     * the corresponding count array for the first string and decrement in the count array for the
     * second string.
     * 3. If both strings are anagram, then after the above operation, all value in count[] array must
     * be 0.
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param s1
     * @param s2
     * @return
     */
    private static boolean isAnagram1(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }

        int[] count = new int[CHAR];

        for(int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        for(int i = 0; i < CHAR; i++) {
            if(count[i] != 0)
                return false;
        }
        return true;
    }

    /**
     * Using sorting: Convert both strings to char arrays and sort the array. Then store the string
     * value in the original string variable. Return if they are equal or not.
     *
     * TC: O(n * log n)
     * SC: O(n)
     *
     * @param s1
     * @param s2
     * @return
     */
    private static boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }

        char[] s1chars = s1.toCharArray();
        Arrays.sort(s1chars);
        s1 = String.valueOf(s1chars);

        char[] s2chars = s2.toCharArray();
        Arrays.sort(s2chars);
        s2 = String.valueOf(s2chars);

        return s1.equals(s2);
    }
}
