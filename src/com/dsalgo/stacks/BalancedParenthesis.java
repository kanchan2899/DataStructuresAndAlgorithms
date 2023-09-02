package com.dsalgo.stacks;

import java.util.*;

// https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
public class BalancedParenthesis {
    public static void main(String[] args) {
        String[] expressions = {"([{}])", "([{}}])", "([{}]))()[]", "([{}])[", "{{}}", "[{}]"};
        for (String expr : expressions) {
            System.out.println(areBracketsBalanced(expr));
        }
    }

    /**
     * Using stacks
     * TC: O(n)
     * SC: O(n)
     * @param expr
     * @return
     */
    private static boolean areBracketsBalanced(String expr) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');

        // Traverse the expression
        for(int i = 0; i < expr.length(); i++){
            char x = expr.charAt(i);
            // Push opening braces into stack
            if(map.containsKey(x)){
                stack.push(map.get(x));
                continue;
            }
            if (stack.isEmpty() || stack.pop() != x){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
