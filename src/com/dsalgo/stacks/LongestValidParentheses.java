package com.dsalgo.stacks;

import java.util.Stack;

// https://leetcode.com/problems/longest-valid-parentheses/
public class LongestValidParentheses {
    public static void main(String[] args) {
        String[] expressions = {"()(()","(()", ")()())", "", ")", "()(()))))"};
        for(String s : expressions){
            System.out.println(longestValidParentheses(s));
        }
    }
    public static int longestValidParentheses(String s) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char x = s.charAt(i);
            if(x == '('){
                stack.push(x);
            } else {
                if(stack.empty())
                    continue;
                if(x == ')' && stack.peek() == '(') {
                    stack.pop();
                    count += 2;
                }
            }
        }
        return count;
    }
}
