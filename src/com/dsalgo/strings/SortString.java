package com.dsalgo.strings;

// https://www.geeksforgeeks.org/sort-string-characters/
public class SortString {
    public static void main(String[] args) {
        String str = "djsfshfjshfjsdf";
        System.out.println(sortString(str));
    }

    /**
     * Using Hashed array: We only have 26 characters only. So we can store the count the occurrences
     * of all the characters from 'a' to 'z' in a hashed array. Then, traverse the hashed array and
     * print the characters from 'a' to 'z' the number of times they occurred in the input string.
     *
     * TC: O(n)
     * SC: O(1)
     * @param str
     * @return
     */
    private static String sortString(String str) {
        int MAX_CHAR = 26;
        int[] letters = new int[MAX_CHAR];
        StringBuilder sortedStr = new StringBuilder();

        for(char x : str.toCharArray()) {
            letters[x - 'a']++;
        }

        for(int i = 0; i < str.length(); i++) {
            for(int j = 0; j < letters[i]; j++) {
                sortedStr.append((char) (i + 'a'));
            }
        }
        return sortedStr.toString();
    }
}
