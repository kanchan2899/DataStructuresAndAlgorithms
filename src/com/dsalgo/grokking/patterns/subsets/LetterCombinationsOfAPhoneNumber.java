package com.dsalgo.grokking.patterns.subsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        String digits = "73";
        System.out.println(letterCombinations(digits));
    }

    private static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();

        // if the input is empty, immediately return an empty answer array
        if(digits.length() == 0) {
            return combinations;
        }

        // Map the digits to their corresponding characters
        Map<Character, String[]> digitsMap = new HashMap<>();
        digitsMap.put('1', new String[]{""});
        digitsMap.put('2', new String[]{"a", "b", "c"});
        digitsMap.put('3', new String[]{"d", "e", "f"});
        digitsMap.put('4', new String[]{"g", "h", "i"});
        digitsMap.put('5', new String[]{"j", "k", "l"});
        digitsMap.put('6', new String[]{"m", "n", "o"});
        digitsMap.put('7', new String[]{"p", "q", "r", "s"});
        digitsMap.put('8', new String[]{"t", "u", "v"});
        digitsMap.put('9', new String[]{"w", "x", "y", "z"});

        // initialize backtracking with an empty path and starting index of 0
        backtrack(digits, digitsMap, combinations, 0, new StringBuilder());

        return combinations;
    }

    private static void backtrack(String digits, Map<Character, String[]> digitsMap, List<String> combinations, int index, StringBuilder path) {

        // if the length of path and digits is same, we have a complete combination
        if(path.length() == digits.length()) {
            // join the path list into a string and add it to the combination list
            combinations.add(path.toString());
            return;
        }

        // get the list of letters using the index and digits[index]
        char digit = digits.charAt(index);
        String[] possibleLetters = digitsMap.get(digit);

        for(String letter: possibleLetters) {
            // add the current letter to the path
            path.append(letter);

            // recursively explore the next digit
            backtrack(digits, digitsMap, combinations, index + 1, path);

            // remove the current letter from the path before backtracking to explore other combinations
            path.deleteCharAt(path.length() - 1);
        }

    }
}
