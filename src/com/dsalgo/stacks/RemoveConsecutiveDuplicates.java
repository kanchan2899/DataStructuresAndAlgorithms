package com.dsalgo.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

// https://www.geeksforgeeks.org/remove-consecutive-duplicates-string/
public class RemoveConsecutiveDuplicates {
    public static void main(String[] args) {
        String s = "aaaaabbbbbb";
        System.out.println(removeConsecutiveDuplicates(s));
        System.out.println(removeConsecutiveDuplicates1(s));
        System.out.println(removeConsecutiveDuplicates2(s));
        System.out.println(removeConsecutiveDuplicates3(s));
        System.out.println(removeConsecutiveDuplicates4(s));
    }

    /**
     * Using regex: create a regex to find pattern of characters that occurs more than once. Replace
     * them with one occurrence of the character
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param s
     * @return
     */
    private static String removeConsecutiveDuplicates4(String s) {
        // Create a regular expression pattern that matches
        // any character followed by one or more occurrences
        // of the same character
        String pattern = "(.)\\1+";

        // Use the replaceAll function to replace all
        // occurrences of the pattern in the string with a
        // single occurrence of the matched character
        return s.replaceAll(pattern, "$1");
    }

    /**
     * Using stacks:
     *
     * 1. Traverse through the string
     *  a. If the stack is empty, append to the ans and push the character to stack
     *  b. Else check if current charater is not same as stack's top. If not, push it to the stack and
     *  append it to the answer.
     *
     *  TC: O(n)
     *  SC: O(n)
     *
     * @param str
     * @return
     */
    public static String removeConsecutiveDuplicates(String str) {
        StringBuilder uniqueStr = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : str.toCharArray()) {
            if(stack.isEmpty()) {
                uniqueStr.append(c);
                stack.push(c);
            } else {
                if(!(c == stack.peek())) {
                    stack.push(c);
                    uniqueStr.append(c);
                }
            }
        }
        return uniqueStr.toString();
    }

    /**
     * Using sliding window:
     *
     * 1)  Input String S.
     * 2)  Initialize two pointer i, j and empty string new_elements.
     * 3) Traverse the String Using j.
     * 4) Compare the elements s[i] and s[j].
     *  (i)   if both elements are same skip .
     *  (ii)  if both elements are not same then append into new_elements set and slide over the window.
     * 5) After Traversing return result.
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param str
     * @return
     */
    public static String removeConsecutiveDuplicates1(String str) {
        // Initialize start and stop pointers
        int i = 0, j = 0;
        StringBuilder uniqueStr = new StringBuilder();

        // Iterate string using j pointer
        while (j < str.length()) {
            // If both elements are same then skip
            if(str.charAt(i) == str.charAt(j)) {
                j++;
            }
            // If both elements are not same then append new element
            else if (str.charAt(j) != str.charAt(i) || j == str.length()){
                uniqueStr.append(str.charAt(i));

                // After appending, slide over the window
                i = j;
                j++;
            }
        }
        uniqueStr.append(str.charAt(j - 1));
        return uniqueStr.toString();
    }


    /**
     * Using recursion: If the string is not empty compare the adjacent characters of the string.
     * If they are the same then shift the characters one by one to the left. Call recursion on
     * string S otherwise, call recursion from S+1 string.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param str
     * @return
     */
    public static String removeConsecutiveDuplicates2(String str) {
        if(str.length() <= 1) {
            return str;
        }

        if(str.charAt(0) == str.charAt(1)) {
            return removeConsecutiveDuplicates2(str.substring(1));
        } else {
            return str.charAt(0) + removeConsecutiveDuplicates2(str.substring(1));
        }
    }


    /**
     * Using iterative approach: The idea is to check if current character is equal to the next
     * character or not . If current character is equal to the next character we’ll ignore it and
     * when it is not equal we will add it to our answer. At last add the last character.
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param str
     * @return
     */
    public static String removeConsecutiveDuplicates3(String str) {
        char[] chars = str.toCharArray();
        int n = str.length();

        if(n < 2) {
            return str;
        }

        int j = 0;

        for(int i = 1; i < n; i++) {
            if(chars[i] != chars[j]) {
                j++;
                chars[j] = chars[i];
            }
        }
        return String.valueOf(chars, 0, j + 1);
    }

}
