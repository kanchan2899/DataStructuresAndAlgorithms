package com.dsalgo.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

// https://www.geeksforgeeks.org/convert-infix-expression-to-postfix-expression/
public class InfixToPostfix {
    public static void main(String[] args) {
        String expr = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(expr));
    }

    /**
     * Using stack: To convert infix expression to postfix expression, use the stack data structure.
     * Scan the infix expression from left to right. Whenever we get an operand, add it to the
     * postfix expression and if we get an operator or parenthesis add it to the stack by
     * maintaining their precedence.
     *
     * 1. Scan the infix expression from left to right.
     * 2. If the scanned character is an operand, put it in the postfix expression.
     * 3. Otherwise, do the following
     *      - If the precedence and associativity of the scanned operator are greater than the
     *      precedence and associativity of the operator in the stack [or the stack is empty or
     *      the stack contains a ‘(‘ ], then push it in the stack. [‘^‘ operator is right
     *      associative and other operators like ‘+‘,’–‘,’*‘ and ‘/‘ are left-associative].
     *          * Check especially for a condition when the operator at the top of the stack and
     *          the scanned operator both are ‘^‘. In this condition, the precedence of the scanned
     *          operator is higher due to its right associativity. So it will be pushed into the
     *          operator stack.
     *          * In all the other cases when the top of the operator stack is the same as the
     *          scanned operator, then pop the operator from the stack because of left associativity
     *          due to which the scanned operator has less precedence.
     * 4. Else, Pop all the operators from the stack which are greater than or equal to in
     * precedence than that of the scanned operator.
     * 5. After doing that Push the scanned operator to the stack. (If you encounter parenthesis
     * while popping then stop there and push the scanned operator in the stack.)
     * 6. If the scanned character is a ‘(‘, push it to the stack.
     * If the scanned character is a ‘)’, pop the stack and output it until a ‘(‘ is encountered,
     * and discard both the parenthesis.
     * 7. Repeat steps 2-5 until the infix expression is scanned.
     * Once the scanning is over, Pop the stack and add the operators in the postfix expression
     * until it is not empty.
     * 8. Finally, print the postfix expression.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param expr
     * @return
     */
    private static String infixToPostfix(String expr) {
        String postfixExpr = new String("");

        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            // if the character is an operand, add it to the output.
            if(Character.isLetterOrDigit(ch)) {
                postfixExpr += ch;
            }

            // if the character is an '(', push it to the stack
            else if(ch == '(') {
                stack.push(ch);
            }

            // if the character is an ')', pop and output from the stack until an '(' is encountered.
            else if(ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfixExpr += stack.peek();
                    stack.pop();
                }
                stack.pop();
            }
            // an operand is encountered
            else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    postfixExpr += stack.peek();
                    stack.pop();
                }
                stack.push(ch);
            }
        }

        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            if(stack.peek() == '(') {
                return "Invalid Expression";
            }
            postfixExpr += stack.peek();
            stack.pop();
        }
        return postfixExpr;
    }

    private static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
}
