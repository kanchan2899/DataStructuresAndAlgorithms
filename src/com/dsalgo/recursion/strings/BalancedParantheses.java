package com.dsalgo.recursion.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/valid-parentheses/description/
public class BalancedParantheses {
    static Map<Character, Character> pairs = new HashMap<>();
    public static void main(String[] args) {
        String[] expressions = {"([{}])", "([{}}])", "([{}]))()[]", "([{}])[", "(())"};
        for (String expr : expressions) {
            System.out.println(areBracketsBalanced(expr));
        }
    }


    private static boolean areBracketsBalanced(String expr) {
        pairs.put('{', '}');
        pairs.put('[', ']');
        pairs.put('(', ')');

        List<Character> list = valid(expr, 0);
        return list.size() == 0;
    }

    private static List<Character> valid(String expr, int index) {
        if(index == expr.length()) {
            return new ArrayList<>();
        }
        char c = expr.charAt(index);
        List<Character> list = valid(expr, index + 1);

        if(!pairs.containsKey(c)) {
            list.add(0, c);
            return list;
        }
        if(list.size() > 0 && list.get(0) == pairs.get(c)) {
            list.remove(0);
        } else {
            list.add('>');
        }
        return list;
    }

}
