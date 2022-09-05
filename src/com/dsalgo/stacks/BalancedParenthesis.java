package com.dsalgo.stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

// https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
public class BalancedParenthesis {
    public static void main(String[] args) {
        String[] expressions = {"([{}])", "([{}}])", "([{}]))()[]", "([{}])["};
        for (String expr : expressions) {
            System.out.println(areBracketsBalanced(expr));
        }
    }

    private static boolean areBracketsBalanced(String expr) {
        Stack<Character> stack = new Stack<>();

        // Traverse the expression
        for(int i = 0; i < expr.length(); i++){
            char x = expr.charAt(i);
            // Push opening braces into stack
            if(x == '(' || x == '[' || x == '{'){
                stack.push(x);
            } else {
                // If current character is not opening bracket,
                // then it must be closing. So the stack cannot be empty at this point.
                if(stack.isEmpty())
                    return false;
                if (x == ')' && stack.peek() == '(')
                    stack.pop();
                else if (x == ']' && stack.peek() == '[')
                    stack.pop();
                else if (x == '}' && stack.peek() == '{')
                    stack.pop();
                else
                    break;
            }
        }
        return stack.isEmpty();
    }
}
