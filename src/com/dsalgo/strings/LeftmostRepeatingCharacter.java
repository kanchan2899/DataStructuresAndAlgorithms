package com.dsalgo.strings;

import java.util.Arrays;

// https://www.geeksforgeeks.org/repeated-character-whose-first-appearance-is-leftmost/
public class LeftmostRepeatingCharacter {
    static final int CHAR = 256;
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println(leftmostRepeatingCharacter(str));
        System.out.println(leftmostRepeatingCharacter1(str));
        System.out.println(leftmostRepeatingCharacter2(str));
        System.out.println(leftmostRepeatingCharacter3(str));
    }

    /**
     * Using reversal traversal: The idea is to track the characters which have encountered
     * while traversing from right to left. Whenever a character is already repeated then take
     * that index to our answer.
     *
     * 1. Initialise an array visited of size 256 which keeps track of characters that have
     * been encountered.
     * 2. Traverse string from right to left and If a character repeats, add that index to
     * the result.
     *
     * TC: O(n)
     * SC: (n)
     *
     * @param str
     * @return
     */
    private static int leftmostRepeatingCharacter3(String str) {
        boolean[] visited = new boolean[CHAR];
        int index = -1;

        for(int i = str.length() - 1; i >= 0; i--) {
            if(visited[str.charAt(i)]) {
                index = i;
            } else {
                visited[str.charAt(i)] = true;
            }
        }
        return index;
    }

    /**
     * Track first occurrence: The idea is to keep track of first occurrence of every character
     * and whenever a character repeats check whether it is first repeated character or not.
     *
     * 1. Initialise an array firstIndex of size 256 which keeps track of the first occurrence
     * of every character in the string.
     * 2. Traverse string from left to right and If a character repeats, compare its leftmost
     * index with the current result
     * 3. Update the result if the result is greater.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param str
     * @return
     */
    private static int leftmostRepeatingCharacter2(String str) {
        int[] count = new int[CHAR];

        Arrays.fill(count, -1);

        int index = Integer.MAX_VALUE;

        for(int i = 0; i < str.length(); i++) {
            int idx = count[str.charAt(i)];

            if(idx == -1) {
                count[str.charAt(i)] = i;
            } else {
                index = Math.min(index, idx);
            }
        }
        return (index == Integer.MAX_VALUE) ? -1 : index;
    }

    /**
     * Using character frequency:
     * @param str
     * @return
     */
    private static int leftmostRepeatingCharacter1(String str) {
        int[] count = new int[CHAR];

        for(int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }

        for(int i = 0; i < str.length(); i++) {
            if(count[str.charAt(i)] > 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Bruteforce: Traverse the string and in inner loop check if the character is already present.
     *
     * TC: O(n ^ 2)
     * SC: O(1)
     *
     * @param str
     * @return
     */
    private static int leftmostRepeatingCharacter(String str) {
        for(int i = 0; i < str.length(); i++) {
            for(int j = i+1; j < str.length(); j++) {
                if(str.charAt(i) == str.charAt(j)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
