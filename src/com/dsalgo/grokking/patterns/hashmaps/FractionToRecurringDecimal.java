package com.dsalgo.grokking.patterns.hashmaps;

import java.util.HashMap;

// https://leetcode.com/problems/fraction-to-recurring-decimal/description/
public class FractionToRecurringDecimal {
    public static void main(String[] args) {
        int numerator = 4;
        int denominator = 333;
        System.out.println(fractionToRecurringDecimal(numerator, denominator));
    }

    private static String fractionToRecurringDecimal(int numerator, int denominator) {
        String recurringDecimals = "";
        HashMap<Integer, Integer> remainderMap = new HashMap<>();

        // if numerator is 0, return 0
        if(numerator == 0) {
            return "0";
        }

        // if numerator or denominator is negative, append "-" to the result
        if(numerator < 0 ^ denominator < 0) {
            recurringDecimals += "-";
        }

        // make numerator and denominator positive after adding "-" to the result
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);

        // calculate the quotient
        int quotient = numerator / denominator;

        int remainder = (numerator % denominator) * 10;

        // append the quotient part in the result
        recurringDecimals += quotient;

        if(remainder == 0) {
            return recurringDecimals;
        } else {
            recurringDecimals += ".";
            while (remainder != 0) {
                if (remainderMap.containsKey(remainder)) {
                    int beginning = remainderMap.get(remainder);
                    String left = recurringDecimals.substring(0, beginning);
                    String right = recurringDecimals.substring(beginning, recurringDecimals.length());
                    recurringDecimals = left + "(" + right + ")";
                    return recurringDecimals;
                } else {
                    remainderMap.put(remainder, recurringDecimals.length());
                    quotient = remainder / denominator;
                    recurringDecimals += String.valueOf(quotient);
                    remainder = (remainder % denominator) * 10;
                }
            }
            return recurringDecimals;
        }
    }
}
