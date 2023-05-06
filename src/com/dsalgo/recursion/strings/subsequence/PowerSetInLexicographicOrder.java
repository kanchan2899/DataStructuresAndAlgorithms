package com.dsalgo.recursion.strings.subsequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://www.geeksforgeeks.org/powet-set-lexicographic-order/
public class PowerSetInLexicographicOrder {
    public static void main(String[] args) {
        String s = "aa";
        System.out.println(powerSetInLexicographicOrder(s));
    }

    private static List<String> powerSetInLexicographicOrder(String s) {
//        char[] chars = s.toCharArray();
//        Arrays.sort(chars);
//        s = String.copyValueOf(chars);
        return helper(s, "");
    }

    private static List<String> helper(String str, String processed) {
        if(str.isEmpty()) {
            List<String> list = new ArrayList<>();
            if(!processed.isEmpty())
                list.add(processed);
            return list;
        }

        char ch = str.charAt(0);
        List<String> left = helper(str.substring(1), processed);
        List<String> right = helper(str.substring(1), processed + ch);

        left.addAll(right);

        Collections.sort(left);
        return left;
    }
}
