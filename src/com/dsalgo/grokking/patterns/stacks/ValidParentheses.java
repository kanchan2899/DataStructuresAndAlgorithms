package com.dsalgo.grokking.patterns.stacks;

import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {
    public static void main(String[] args) {
        String str = "()[]{}";
        System.out.println(isValidParentheses(str));
        System.out.println(isValidParentheses1(str));
    }

    private static boolean isValidParentheses1(String str) {
        Stack<Character> stack = new Stack<>();

        for(char ch : str.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }

                char top = stack.peek();

                if((ch == ')' && top == '(') || (ch == ']' && top == '[') || (ch == '}' && top == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isValidParentheses(String str) {
        Stack<Character> stack = new Stack<>();
        for(char ch : str.toCharArray()) {
            if(ch == '(') {
                stack.push(')');
            } else if(ch == '[') {
                stack.push(']');
            } else if(ch == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
