package com.dsalgo.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

// https://www.geeksforgeeks.org/convert-infix-prefix-notation/
public class InfixToPrefix {
    public static void main(String[] args) {
        String expr = "x+y*z/w+u";
        System.out.println(infixToPrefix(expr));
    }

    /**
     * Using stack: To convert an infix expression to a prefix expression, we can use the stack
     * data structure. The idea is as follows:
     *
     * Step 1: Reverse the infix expression. Note while reversing each ‘(‘ will become ‘)’ and each
     * ‘)’ becomes ‘(‘.
     *
     * Step 2: Convert the reversed infix expression to “nearly” postfix expression.
     * While converting to postfix expression, instead of using pop operation to pop operators with
     * greater than or equal precedence, here we will only pop the operators from stack that have
     * greater precedence.
     *
     * Step 3: Reverse the postfix expression.
     * The stack is used to convert infix expression to postfix form.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param expr
     * @return
     */
    private static String infixToPrefix(String expr) {
        String prefix = "";

        Deque<Character> stack = new ArrayDeque<>();

        for(int i = expr.length() - 1; i >= 0; i--) {
            char ch = expr.charAt(i);
            if(precedence(ch) > 0) {
                while (!stack.isEmpty() && precedence(stack.peek()) > precedence(ch)) {
                    prefix += stack.pop();
                }
                stack.push(ch);
            } else if(ch == ')') {
                char x = stack.pop();
                while (x != ')') {
                    prefix += x;
                    x = stack.pop();
                }
            } else if(ch == ')') {
                stack.push(ch);
            } else {
                prefix += ch;
            }
        }

        while (!stack.isEmpty()) {
            prefix += stack.pop();
        }

        String reversedPrefix = "";
        for(int i = prefix.length() - 1; i >= 0; i--) {
            reversedPrefix += prefix.charAt(i);
        }
        return reversedPrefix;
    }

    static int precedence(char ch) {
        if(ch == '-' || ch == '+')
            return 1;
        else if(ch == '*' || ch == '/')
            return 2;
        else if(ch == '^')
            return 3;
        return -1;
    }
}
