package com.dsalgo.grokking.patterns.stacks;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        String s = "(qi)(kl)((y(yt))(r(q(g)s)";
        System.out.println(minRemoveParentheses(s));
    }

    private static String minRemoveParentheses(String s) {
        Stack<int[]> stack = new Stack<>();
        char[] array = s.toCharArray();

        for(int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            // if stack is not empty and top element of stack is an opening parenthesis and the
            // current element is a closing parenthesis
            if(!stack.isEmpty() && stack.peek()[0] == '(' && val == ')') {
                // pop the opening parenthesis as it makes a valid pair with the current
                // closing parenthesis
                stack.pop();
            }
            // if the current value is an opening or a closing parenthesis
            else if(val == ')' || val == '(') {
                // push on to the stack
                stack.push(new int[]{val, i});
            }
        }

        // remove the invalid parentheses
        while (!stack.isEmpty()) {
            array[stack.pop()[1]] = ' ';
        }

        // convert the char array to a string
        StringBuilder result = new StringBuilder();
        for(char ch : array) {
            if(ch != ' ') {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
