package com.dsalgo.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

// https://www.geeksforgeeks.org/evaluation-of-postfix-expression/
public class PostfixEvaluation {
    public static void main(String[] args) {
        String expr = "100 200 + 2 / 5 * 7 +";
        System.out.println(postfixEvaluation(expr));
    }

    /**
     * Using stack: Iterate the expression from left to right and keep on storing the operands
     * into a stack. Once an operator is received, pop the two topmost elements and evaluate
     * them and push the result in the stack again.
     *
     * 1. Create a stack to store operands (or values).
     * 2. Scan the given expression from left to right and do the following for every scanned
     * element.
     *      a. If the element is a number, push it into the stack.
     *      b. If the element is an operator, pop operands for the operator from the stack.
     *      Evaluate the operator and push the result back to the stack.
     * 3. When the expression is ended, the number in the stack is the final answer.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param expr
     * @return
     */
    private static int postfixEvaluation(String expr) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            if(ch == ' ') {
                continue;
            }
            // if ch is operand, push it to the stack
            else if(Character.isDigit(ch)) {
                int n = 0;

                // extract the characters iand store it in num
                while (Character.isDigit(ch)) {
                    n = n * 10 + (int)(ch - '0');
                    i++;
                    ch = expr.charAt(i);
                }
                i--;
                stack.push(n);
            }
            // if ch is operator, pop two elements from stack, apply the operator
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                    case '^':
                        stack.push((int) Math.pow(val2, val1));
                        break;
                }
            }
        }
        return stack.pop();
    }
}
