package com.dsalgo.grokking.patterns.stacks;

import java.util.Stack;

// https://leetcode.com/problems/basic-calculator/
public class BasicCalculator {
    public static boolean dbg;
    public static void main(String[] args) {
        String input = "(12 - 9 + 4) + ( 7 - 5)";
        System.out.println(calculator(input));
    }

    private static int calculator(String expression) {
        int number = 0;
        int sign = 1;
        int result = 0;
        int secondValue = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // To store the consecutive digits that is 52 => 5 x 10 + 2 = 52
            if(Character.isDigit(ch)) {
                number = number * 10 + Character.getNumericValue(ch);
            }

            // evaluate the left expression and store the new sign value
            else if(ch == '-' || ch == '+') {
                result += number * sign;

                if(ch == '-') {
                    sign = -1;
                } else {
                    sign = 1;
                }
                number = 0;
            }
            // push the result calculated till now and store the sign value
            else if(ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }

            // convert current number to positive or negative if we need to perform an addition
            // ot a subtraction respectively and add it to the previously calculated result
            else if(ch == ')') {
                result += sign * number;
                int popSignValue = stack.pop();
                result *= popSignValue;

                secondValue = stack.pop();
                result += secondValue;
                number = 0;
            }
        }


        return result + number * sign;
    }
}
