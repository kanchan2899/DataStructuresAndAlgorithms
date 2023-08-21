package com.dsalgo.strings;

import java.util.Arrays;

// https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
public class LongestSubstringWithDistinctCharacters {
    public static void main(String[] args) {
        String str = "abadcbad";
        System.out.println(longestSubstringWithDistinctCharacters(str));
        System.out.println(longestSubstringWithDistinctCharacters1(str));
        System.out.println(longestSubstringWithDistinctCharacters2(str));
    }

    /**
     *  By storing the last index of each character: The approach stores the last indexes of
     *  already visited characters. The idea is to traverse the string from left to right, for
     *  each character at index j, update the i pointer(starting index of current window) to be
     *  the maximum of its current value and last Index of str[j] + 1. This step ensures that i
     *  is moved to the appropriate position to exclude any repeating characters within the new
     *  window.
     *
     *
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param str
     * @return
     */
    private static int longestSubstringWithDistinctCharacters2(String str) {
        int n = str.length(), len = 0;
        int prev[] = new int[256];

        Arrays.fill(prev, -1);
        int j = 0;
        for(int i = 0; i < n; i++) {
            j = Math.max(j, prev[str.charAt(i)] + 1);
            int maxEnd = i - j + 1;
            len = Math.max(len, maxEnd);
            prev[str.charAt(j)] = j;
        }
        return len;
    }

    /**
     * Using window sliding: The idea is to use window sliding. Whenever we see repetition,
     * we remove the previous occurrence and slide the window.
     *
     * TC: O(n ^ 2)
     * SC: O(1)
     * @param str
     * @return
     */
    private static int longestSubstringWithDistinctCharacters1(String str) {
        int n = str.length();
        int len = 0;

        for(int i = 0; i < n; i++) {
            boolean[] visited = new boolean[256];

            for(int j = i; j < n; j++) {
                if(visited[str.charAt(j)]) {
                    break;
                } else {
                    len = Math.max(len, j - i + 1);
                    visited[str.charAt(j)] = true;
                }
            }
        }
        return len;
    }

    /**
     * Bruteforce: Consider all substrings and check if the characters in each substrings are distinct
     *
     * TC: O(n ^ 3)
     * SC: O(n)
     *
     * @param str
     * @return
     */
    private static int longestSubstringWithDistinctCharacters(String str) {
        int n = str.length();
        int len = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(areDistinct(str, i, j)) {
                    len = Math.max(j - i + 1, len);
                }
            }
        }
        return len;
    }

    private static boolean areDistinct(String str, int i, int j) {
        boolean visited[] = new boolean[256];
        for(int k = i; k <= j; k++) {
            if(visited[str.charAt(k)]) {
                return false;
            }
            visited[str.charAt(k)] = true;
        }
        return true;
    }
}
