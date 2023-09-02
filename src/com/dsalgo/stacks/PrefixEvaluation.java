package com.dsalgo.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

// https://www.geeksforgeeks.org/evaluation-prefix-expressions/
public class PrefixEvaluation {
    public static void main(String[] args) {
        String prefix = "+9*26";
        System.out.println(prefixEvaluation(prefix));
    }

    static boolean isOperator(char ch) {
        if(ch >= 48 && ch <= 57) {
            return true;
        }
        return false;
    }
    private static double prefixEvaluation(String prefix) {
        Deque<Double> stack = new ArrayDeque<>();

        for(int i = prefix.length() - 1; i >= 0; i--) {
            char ch = prefix.charAt(i);
            // push the operand to stack to convert ch to digit
            if(isOperator(ch)) {
                stack.push((double)(ch - 48));
            } else {
                // operator encountered, pop two elements from stack

                double op1 = stack.pop();
                double op2 = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(op1 + op2);
                        break;
                    case '-':
                        stack.push(op1 - op2);
                        break;
                    case '*':
                        stack.push(op1 * op2);
                        break;
                    case '/':
                        stack.push(op1 / op2);
                        break;

                }
            }
        }
        return stack.pop();
    }
}
