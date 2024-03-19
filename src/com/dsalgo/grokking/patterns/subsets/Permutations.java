package com.dsalgo.grokking.patterns.subsets;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations/
public class Permutations {
    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(permuteWord(str));
    }

    private static String swapChar(String word, int i, int j) {
        char[] wordArray = word.toCharArray();
        char temp = wordArray[i];
        wordArray[i] = wordArray[j];
        wordArray[j] = temp;

        return new String(wordArray);
    }

    private static ArrayList<String> permuteWord(String word) {
        ArrayList<String> results = new ArrayList<>();
        permutations(word, 0, results);
        return results;
    }
    private static void permutations(String word, int currentIndex, ArrayList<String> results) {
        // prevents adding duplicate permutations
        if(currentIndex == word.length() - 1) {
            results.add(word);
            return;
        }

        for(int index = currentIndex; index < word.length(); index++) {
            String swappedStr = swapChar(word, currentIndex, index);
            permutations(swappedStr, currentIndex + 1, results);
        }
    }
}
