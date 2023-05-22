package com.dsalgo.recursion.numbers;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/different-ways-to-add-parentheses/description/
public class DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        String exp = "2*3-4*5";
        System.out.println(diffWaysToCompute(exp));
    }

    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> results = new ArrayList<>();
        boolean isNumber = true;

        for(int i = 0; i < expression.length(); i++) {
            // Check if the current character is an operator
            if(!Character.isDigit(expression.charAt(i))) {
                // If current character is not a digit, then expression is not purely a number
                isNumber = false;

                // List of first operands
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                // List of second operands
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));

                // Perform operations
                for(int x: left) {
                    for(int y: right) {
                        int val = perform(x, y, expression.charAt(i));
                        results.add(val);
                    }
                }
            }
        }
        if(isNumber) {
            results.add(Integer.valueOf(expression));
        }
        return results;
    }

    static int perform(int x, int y, char op) {
        if(op == '+') {
            return x + y;
        }
        if(op == '-') {
            return x - y;
        }
        if(op == '*') {
            return x * y;
        }
        return 0;
    }

}
