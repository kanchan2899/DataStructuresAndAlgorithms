package com.dsalgo.grokking.patterns.stacks;

import java.util.Stack;

// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        String str = "abbaca";
        System.out.println(removeAdjacentDuplicates(str));
    }

    /**
     * Using stack:
     * 1. If the stack is empty, we’ll push the character onto the stack.
     * 2. If the stack is not empty, we’ll perform the following tasks:
     *     - If the string’s character is different from the stack’s top character, we’ll push
     *     the string’s character onto the stack because we did not find the adjacent duplicate.
     *     - If the string’s character is the same as the stack’s top character, it means that we
     *     found the adjacent duplicate characters. We’ll pop that character from the stack and move
     *     to the next character in the string.
     * 3. After the entire string has been traversed, the remaining characters in the stack will
     * be our result. We’ll form a string from those characters and return it.
     *
     * TC: O(n)
     * SC: O(n)
     * @param str
     * @return
     */
    private static String removeAdjacentDuplicates(String str) {
        Stack<Character> stack = new Stack<>();

        for(char ch: str.toCharArray()) {
            // if the stack has at least one character and stack's top character is same as the
            // string's character
            if(!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                // otherwise push that character onto the stack
                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();

        // Get top element and concatenate to the result string.
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }
}
