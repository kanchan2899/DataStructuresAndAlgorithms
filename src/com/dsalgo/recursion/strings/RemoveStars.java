package com.dsalgo.recursion.strings;

import java.util.Stack;

// https://leetcode.com/problems/removing-stars-from-a-string/
public class RemoveStars {
    public static void main(String[] args) {
        String s = "leet**c*de";
        System.out.println(removeStars(s));
        System.out.println(removeStars1(s));
    }

    private static String removeStars1(String s) {
        if(s.length() == 0) {
            return s;
        }
        return helper(s, 0);
    }

    private static String helper(String s, int index) {
        if(index == s.length()) {
            return s;
        }
        char c = s.charAt(index);
        if(c == '*') {
            return helper(s.substring(0, index - 1) + s.substring(index + 1), index - 1);
        }
        return helper(s, index + 1);
    }

    public static String removeStars(String s) {
        StringBuffer res = new StringBuffer();
        if(s.isEmpty()) {
            return s;
        }
        int index = 0;
        Stack<Character> stack = new Stack<>();
        while(index != s.length()) {
            if(s.charAt(index) != '*') {
                stack.push(s.charAt(index));
            } else {
                stack.pop();
            }
            index++;
        }
        stack.stream().forEach(S -> res.append(S));
        return res.toString();
    }
}
