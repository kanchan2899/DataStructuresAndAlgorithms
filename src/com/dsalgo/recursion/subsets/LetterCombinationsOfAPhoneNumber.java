package com.dsalgo.recursion.subsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    private static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0)
            return result;

        Map<Character, String> characterStringMapmap = new HashMap<>();
        characterStringMapmap.put('2', "abc");
        characterStringMapmap.put('3', "def");
        characterStringMapmap.put('4', "ghi");
        characterStringMapmap.put('5', "jkl");
        characterStringMapmap.put('6', "mno");
        characterStringMapmap.put('7', "pqrs");
        characterStringMapmap.put('8', "tuv");
        characterStringMapmap.put('9', "wxyz");

        result = helper(digits, "", characterStringMapmap);

        return result;
    }

    private static List<String> helper(String digits,
                                       String processed,
                                       Map<Character, String> characterStringMapmap) {

        if(digits.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        char digit = digits.charAt(0);
        List<String> res = new ArrayList<>();
        String str = characterStringMapmap.get(digit);
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            res.addAll(helper(digits.substring(1), processed + c, characterStringMapmap));
        }
        return res;
    }
}
