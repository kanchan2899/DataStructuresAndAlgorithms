package com.dsalgo.grokking.patterns.subsets;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/
public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(generateParentheses(n));
    }

    private static List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        List<Character> output = new ArrayList<>();

        backtrack(n, 0, 0, output, result);
        return result;
    }

    private static void backtrack(int n, int leftCount, int rightCount, List<Character> output, List<String> result) {
        // base case where count of left and right braces is n
        if(leftCount >= n && rightCount >= n) {
            String outputStr = output.toString();
            result.add(outputStr.substring(1, outputStr.length() - 1).replace(", ", ""));
        }

        // case where we can still add left braces
        if(leftCount < n) {
            output.add('(');
            backtrack(n, leftCount + 1, rightCount, output, result);
            output.remove(output.size() - 1);
        }

        // case where we add right braces if the current count of right braces is less than the
        // count of left braces
        if(rightCount < leftCount) {
            output.add(')');
            backtrack(n, leftCount, rightCount + 1, output, result);
            output.remove(output.size() - 1);
        }
    }
}
